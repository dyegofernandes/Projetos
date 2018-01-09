package com.ebol.mb.venda;

import com.ebol.bo.cadastro.ClienteBO;
import com.ebol.bo.cadastro.Padrao_CobrancaBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.venda.BoletoBO;
import com.ebol.modelo.cadastro.Cliente;
import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.cadastro.Padrao_Cobranca;
import com.ebol.modelo.controleacesso.Usuario;
import com.ebol.modelo.enuns.Meses;
import com.ebol.modelo.enuns.SituacaoBoleto;
import com.ebol.modelo.venda.Boleto;
import com.ebol.modelo.vos.FiltroBusca;
import com.ebol.util.SessaoUtils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.faces.utils.FacesUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BoletoMB extends AbstractBaseBean<Boleto> implements Serializable {

    @EJB
    private BoletoBO boletoBO;

    @EJB
    private Padrao_CobrancaBO padraoBO;

    @EJB
    private ClienteBO clienteBO;

    private List<Boleto> boletos;

    private List<Boleto> boletosPorConvenio = new ArrayList<Boleto>();

    List<Cliente> clientes;

    private Integer dia;

    private Meses meses;

    private Integer ano;

    private int size = 0;

    private Long ultimoNossoNum = 1L;

    private Usuario usuario = new Usuario();

    private Convenio convenio = new Convenio();

    private FiltroBusca filtros;

    @Override
    public void init() {
        filtros = new FiltroBusca();
        usuario = SessaoUtils.getUser();
        filtros.setUsuario(usuario);
        boletos = new ArrayList<Boleto>();

        Calendar dataCal = Calendar.getInstance();
        dataCal.setTime(new Date());
        dia = dataCal.get(Calendar.DAY_OF_MONTH) > 28 ? 28 : dataCal.get(Calendar.DAY_OF_MONTH);
        meses = getMesAtual(dataCal.get(Calendar.MONTH));
        ano = dataCal.get(Calendar.YEAR);
        convenio = boletoBO.getDAO().getInitialized(usuario.getConvenio());

        getEntity().setConvenio(convenio);
        Padrao_Cobranca padrao = boletoBO.getDAO().getInitialized(convenio.getPadrao());

        if (padrao != null) {
            getEntity().setDesconto(padrao.getDesconto() != null ? padrao.getDesconto() : BigDecimal.ZERO);
            getEntity().setJuros(padrao.getJuros() != null ? padrao.getJuros() : BigDecimal.ZERO);
            getEntity().setMulta(padrao.getMulta() != null ? padrao.getMulta() : BigDecimal.ZERO);
        }
        clientes = boletoBO.clientesPorConvenio(usuario);
        ultimoNossoNum = ((Long) boletoBO.getDAO().getQueryBuilder().from(Boleto.class).add("convenio", convenio).max("nossoNumero", 0L)).intValue() + 1L;

    }

    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/venda/boleto/listBoleto.jsf");
        } else {
            setEntity(new Boleto());
            limparCampos();
        }
    }

    @Override
    public void save() {
        if (getEntity().getId() != null && !getEntity().isTravado() && getEntity().getSituacao() == SituacaoBoleto.EMABERTO) {
            BigDecimal jurosPorc = BigDecimal.ZERO, multaPorc = BigDecimal.ZERO, descontoPorc = BigDecimal.ZERO;

            multaPorc = valorParaPorcentagem(getEntity().getMulta(), getEntity().getValor_cobrado());

            jurosPorc = valorParaPorcentagem(getEntity().getJuros(), getEntity().getValor_cobrado());

            descontoPorc = valorParaPorcentagem(getEntity().getDesconto(), getEntity().getValor_cobrado());

            getEntity().setDesconto(porcentagemParaValor(descontoPorc, getEntity().getValor_cobrado()));
            getEntity().setJuros(porcentagemParaValor(jurosPorc, getEntity().getValor_cobrado()));
            getEntity().setMulta(porcentagemParaValor(multaPorc, getEntity().getValor_cobrado()));

            super.save();
        }
    }

    public void saveAll() {
        if (boletos.size() > 1) {
            for (Boleto boleto : boletos) {

                boletoBO.getDAO().saveOrMerge(boleto, true);
            }

            boletoBO.gerarBoletosEmLote(boletos);

            setEntity(new Boleto());

            init();

            FacesMessageUtils.info("Boletos Gerados com Sucesso!");
        } else {
            FacesMessageUtils.info("Não existe boleto (s) gerado (s)!");
        }

    }

    public void gerararBoleto(Boleto boleto) {
        List<Boleto> boletosTemp = new ArrayList<Boleto>();
        boletosTemp.add(boleto);
        boletoBO.gerarBoletosEmLote(boletosTemp);
    }

    public void limparCampos() {
        boletos = new ArrayList<Boleto>();
        Calendar dataCal = Calendar.getInstance();
        dataCal.setTime(new Date());
        dia = dataCal.get(Calendar.DAY_OF_MONTH) > 28 ? 28 : dataCal.get(Calendar.DAY_OF_MONTH);
        meses = getMesAtual(dataCal.get(Calendar.MONTH));
        ano = dataCal.get(Calendar.YEAR);

    }

    public void travarTodosBoletos() {
        boletoBO.travarTodosBoletos(boletosPorConvenio);
        FacesMessageUtils.info("Boletos travados com sucesso!");
    }

    public void cancelarBoleto(Boleto boletoCancel) {
        boletoCancel.setSituacao(SituacaoBoleto.CANCELADO);
        boletoCancel.setTravado(true);
        boletoBO.getDAO().saveOrMerge(boletoCancel, true);
        FacesMessageUtils.info("Boleto cancelado com sucesso!");
    }

    public void travarUmBoleto(Boleto boletoTemp) {
        List<Boleto> boletosTemp = new ArrayList<Boleto>();
        boletosTemp.add(boletoTemp);
        boletoBO.travarTodosBoletos(boletosTemp);
        FacesMessageUtils.info("Boleto travado com sucesso!");
        boletosPorConvenio();
    }

    @Override
    public BoletoBO getBO() {
        return boletoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Meses getMeses() {
        return meses;
    }

    public void setMeses(Meses meses) {
        this.meses = meses;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public FiltroBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltroBusca filtros) {
        this.filtros = filtros;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void gerarBoletos() {
        int contMes = meses.getNum() - 1;
        int parcela = 1;
        BigDecimal valor;
        if (dia > 28) {
            FacesMessageUtils.error("O dia do vencimento deve ser menor ou igual a 28!");
        } else {
            if (getEntity().getParcela() == null || getEntity().getParcela() < 1) {
                FacesMessageUtils.error("A parcela deve ser maior ou igual a 1 (um)!");
            } else {
                if (getEntity().getValor_cobrado() == null || getEntity().getValor_cobrado().compareTo(BigDecimal.ZERO) == 0) {
                    FacesMessageUtils.error("O valor deve ser maior ou igual a zero!");
                } else {
                    if (getEntity().getReferenteA() == null || getEntity().getReferenteA().equals("")) {
                        FacesMessageUtils.error("Referente A é obrigatoria!");
                    } else {
                        valor = getEntity().getValor_cobrado().divide(new BigDecimal(getEntity().getParcela()), 2, RoundingMode.UP);
                        for (int i = 0; i < getEntity().getParcela(); i++) {
                            Boleto boleto = new Boleto();
                            boleto.setConvenio(convenio);
                            boleto.setCliente(getEntity().getCliente());

                            Calendar vencimento = Calendar.getInstance();
                            if (contMes > 11) {
                                ano++;
                                contMes = 0;
                            }

                            vencimento.set(ano, contMes, dia);

                            boleto.setCriacao(new Date());

                            boleto.setVencimento(vencimento.getTime());

                            boleto.setInstrucao_exclusiva(getEntity().getInstrucao_exclusiva());

                            boleto.setParcela(parcela);

                            boleto.setReferenteA(getEntity().getReferenteA());

                            boleto.setTotalParcela(getEntity().getParcela());

                            boleto.setSituacao(SituacaoBoleto.EMABERTO);

                            boleto.setTravado(false);

                            boleto.setValor_cobrado(valor);

                            boleto.setDesconto(porcentagemParaValor(getEntity().getDesconto(), valor));

                            boleto.setMulta(porcentagemParaValor(getEntity().getMulta(), valor));

                            boleto.setJuros(porcentagemParaValor(getEntity().getJuros(), valor));

                            String nossoNumero = (lpadTo(ultimoNossoNum.toString(), 9, '0'));

                            boleto.setNossoNumero(Long.parseLong(nossoNumero));

                            boletos.add(boleto);

                            contMes++;
                            parcela++;
                            ultimoNossoNum++;
                        }
                    }
                }
            }
        }

        size = boletos.size();

    }

    private BigDecimal porcentagemParaValor(BigDecimal porcentagem, BigDecimal valorTotal) {
        BigDecimal valorFinal = BigDecimal.ZERO;

        //valor - (percentual * valor);
        valorFinal = porcentagem.divide(new BigDecimal(100)).multiply(valorTotal);

        return valorFinal;
    }

    private BigDecimal valorParaPorcentagem(BigDecimal valor, BigDecimal valorTotal) {
        BigDecimal valorFinal = BigDecimal.ZERO;

        //acertos / perguntas) * 100)
        valorFinal = valor.divide(valorTotal, 2, RoundingMode.UP).multiply(new BigDecimal(100));

        return valorFinal;
    }

    public void cancelarBoletosGeradados() {
        if (getEntity() != null) {
            boletos = new ArrayList<Boleto>();
        }
    }

    private Meses getMesAtual(int mes) {
        Meses mesTemp = null;

        if (mes == 0) {
            mesTemp = Meses.JANEIRO;
        }
        if (mes == 1) {
            mesTemp = Meses.FEVEREIRO;
        }
        if (mes == 2) {
            mesTemp = Meses.MARCO;
        }
        if (mes == 3) {
            mesTemp = Meses.ABRIL;
        }
        if (mes == 4) {
            mesTemp = Meses.MAIO;
        }
        if (mes == 5) {
            mesTemp = Meses.JUNHO;
        }
        if (mes == 6) {
            mesTemp = Meses.JULHO;
        }
        if (mes == 7) {
            mesTemp = Meses.AGOSTO;
        }
        if (mes == 8) {
            mesTemp = Meses.SETEMBRO;
        }
        if (mes == 9) {
            mesTemp = Meses.OUTUBRO;
        }
        if (mes == 10) {
            mesTemp = Meses.NOVEMBRO;
        }
        if (mes == 11) {
            mesTemp = Meses.DEZEMBRO;
        }
        return mesTemp;
    }

    private String lpadTo(String input, int width, char ch) {
        String strPad = "";

        StringBuilder sb = new StringBuilder(input.trim());
        while (sb.length() < width) {
            sb.insert(0, ch);
        }
        strPad = sb.toString();

        if (strPad.length() > width) {
            strPad = strPad.substring(0, width);
        }
        return strPad;
    }

    public List<Boleto> boletosPorConvenio() {
        boletosPorConvenio = boletoBO.boletosPorConvenio(filtros);
        return boletosPorConvenio;
    }

}
