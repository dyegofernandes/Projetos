package com.ebol.mb.venda;

import com.ebol.bo.cadastro.ClienteBO;
import com.ebol.bo.cadastro.Padrao_CobrancaBO;
import com.ebol.bo.venda.BoletoBO;
import com.ebol.bo.venda.ItemBO;
import com.ebol.bo.venda.Item_VendidoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.venda.VendaBO;
import com.ebol.modelo.cadastro.Cliente;
import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.cadastro.Padrao_Cobranca;
import com.ebol.modelo.controleacesso.Usuario;
import com.ebol.modelo.enuns.Meses;
import com.ebol.modelo.enuns.SituacaoBoleto;
import com.ebol.modelo.venda.Boleto;
import com.ebol.modelo.venda.Item;
import com.ebol.modelo.venda.Item_Vendido;
import com.ebol.modelo.venda.Venda;
import com.ebol.modelo.vos.FiltroBusca;
import com.ebol.util.SessaoUtils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class VendaMB extends AbstractBaseBean<Venda> implements Serializable {

    @EJB
    private VendaBO vendaBO;

    @EJB
    private ItemBO itemBO;

    @EJB
    private BoletoBO boletoBO;

    @EJB
    private Item_VendidoBO itemVendidoBO;

    @EJB
    private Padrao_CobrancaBO padraoBO;

    @EJB
    private ClienteBO clienteBO;

    @EJB
    private ItemBO itemAutBO;

    private Item itemAutocomplete;

    private List<Item> itensPorConvenio;

    private Item_Vendido itemAdd;

    private BigDecimal unitario;

    private BigDecimal qtd;

    private List<Item_Vendido> itens;

    private List<Item_Vendido> itensDeletados;

    private List<Boleto> boletos;

    private List<Boleto> boletosDeletados;

    private Boleto boletoAdd = new Boleto();

    private Integer dia;

    private Meses meses;

    private Integer ano;

    private int size = 0;

    private Long ultimoNossoNum = 1L;

    private Usuario usuario = new Usuario();

    private Convenio convenio = new Convenio();

    private Padrao_Cobranca padrao = new Padrao_Cobranca();

    private List<Cliente> clientes;

    private List<Venda> vendasPorConvenio = new ArrayList<Venda>();

    private FiltroBusca filtros;

    public Item getItemAutocomplete() {
        return itemAutocomplete;
    }

    public void setItemAutocomplete(Item itemAutocomplete) {
        this.itemAutocomplete = itemAutocomplete;
    }

    public Item_Vendido getItemAdd() {
        return itemAdd;
    }

    public void setItemAdd(Item_Vendido itemAdd) {
        this.itemAdd = itemAdd;
    }

    public BigDecimal getUnitario() {
        return unitario;
    }

    public void setUnitario(BigDecimal unitario) {
        this.unitario = unitario;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }

    public List<Item_Vendido> getItens() {
        return itens;
    }

    public void setItens(List<Item_Vendido> itens) {
        this.itens = itens;
    }

    public List<Item_Vendido> getItensDeletados() {
        return itensDeletados;
    }

    public void setItensDeletados(List<Item_Vendido> itensDeletados) {
        this.itensDeletados = itensDeletados;
    }

    public FiltroBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltroBusca filtros) {
        this.filtros = filtros;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public List<Boleto> getBoletosDeletados() {
        return boletosDeletados;
    }

    public void setBoletosDeletados(List<Boleto> boletosDeletados) {
        this.boletosDeletados = boletosDeletados;
    }

    public Boleto getBoletoAdd() {
        return boletoAdd;
    }

    public void setBoletoAdd(Boleto boletoAdd) {
        this.boletoAdd = boletoAdd;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Item> getItensPorConvenio() {
        return itensPorConvenio;
    }

    public void setItensPorConvenio(List<Item> itensPorConvenio) {
        this.itensPorConvenio = itensPorConvenio;
    }

    @Override
    public void init() {
        filtros = new FiltroBusca();
        itensDeletados = new ArrayList<Item_Vendido>();
        boletosDeletados = new ArrayList<Boleto>();

        itensPorConvenio = new ArrayList<Item>();

        itens = new ArrayList<Item_Vendido>();
        boletos = new ArrayList<Boleto>();

        if (getEntity().getId() != null) {
            itens = itemVendidoBO.getDAO().list("venda_id", getEntity().getId());
            boletos = boletoBO.getDAO().list("venda_id", getEntity().getId());
        }
        usuario = SessaoUtils.getUser();
        filtros.setUsuario(usuario);
        Calendar dataCal = Calendar.getInstance();
        dataCal.setTime(new Date());
        dia = dataCal.get(Calendar.DAY_OF_MONTH) > 28 ? 28 : dataCal.get(Calendar.DAY_OF_MONTH);
        meses = getMesAtual(dataCal.get(Calendar.MONTH));
        ano = dataCal.get(Calendar.YEAR);
        convenio = boletoBO.getDAO().getInitialized(usuario.getConvenio());
        getEntity().setConvenio(convenio);
        padrao = boletoBO.getDAO().getInitialized(convenio.getPadrao());
        if (padrao != null) {
            boletoAdd.setDesconto(padrao.getDesconto() != null ? padrao.getDesconto() : BigDecimal.ZERO);
            boletoAdd.setJuros(padrao.getJuros() != null ? padrao.getJuros() : BigDecimal.ZERO);
            boletoAdd.setMulta(padrao.getMulta() != null ? padrao.getMulta() : BigDecimal.ZERO);
        }
        ultimoNossoNum = ((Long) boletoBO.getDAO().getQueryBuilder().from(Boleto.class).add("convenio", convenio).max("nossoNumero", 0L)).intValue() + 1L;

        clientes = clienteBO.getDAO().list("convenio", convenio);
        itensPorConvenio = itemAutBO.getDAO().list("convenio", convenio);
    }

    @Override
    public void save() {
        if (getEntity().getId() != null) {
            super.save();
            for (Boleto boletu : boletos) {
                boletu.setCliente(getEntity().getCliente());
                boletu.setReferenteA(getEntity().getReferenteA());
                boletu.setInstrucao_exclusiva(getEntity().getDescricao());
                boletoBO.getDAO().saveOrMerge(boletu, true);
            }
        } else {
            if (itens.size() < 1) {
                FacesMessageUtils.error("A venda deverá ter no minímo um item!");
            } else {
                if (boletos.size() < 1) {
                    FacesMessageUtils.error("A venda deverá ter no minímo um Boleto gerado!");
                } else {
                    super.save();

                    if (getEntity().getId() != null) {

                        for (Item_Vendido iten : itens) {
                            itemVendidoBO.getDAO().saveOrMerge(iten);
                        }

                        for (Item_Vendido iten : itensDeletados) {
                            try {
                                itemVendidoBO.remove(iten);
                            } catch (DeleteException ex) {
                                Logger.getLogger(VendaMB.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        for (Boleto boletu : boletos) {
                            boletoBO.getDAO().saveOrMerge(boletu, true);
                        }

                        for (Boleto boletu : boletosDeletados) {
                            try {
                                boletoBO.remove(boletu);
                            } catch (DeleteException ex) {
                                Logger.getLogger(VendaMB.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        boletoBO.gerarBoletosEmLote(boletos);

                        setEntity(new Venda());
                        boletoAdd = new Boleto();

                        init();

                        FacesMessageUtils.info("Boletos Gerados com Sucesso!");
                    }
                }

            }
        }

    }

    public void addItens() {
        if (itemAutocomplete == null) {
            FacesMessageUtils.error("O Item é obrigatório!");
        } else {
            if (unitario.compareTo(BigDecimal.ZERO) <= 0 || unitario == null) {
                FacesMessageUtils.error("O valor unitario do Item deve ser maior do que 0 (Zero)!");
            } else {
                if (qtd.compareTo(BigDecimal.ZERO) <= 0 || qtd == null) {
                    FacesMessageUtils.error("O valor da Quantidade do Item deve ser maior do que 0 (Zero)!");
                } else {
                    if (verificarExistenciaItem()) {
                        FacesMessageUtils.error("Item já adicionado!");
                    } else {
                        itemAdd = new Item_Vendido();
                        itemAdd.setVenda(getEntity());
                        itemAdd.setItem(itemAutocomplete);
                        itemAdd.setUnitario(unitario);
                        itemAdd.setQtd(qtd);

                        itens.add(itemAdd);

                        itemAutocomplete = new Item();
                        unitario = null;
                        qtd = null;
                        boletoAdd.setValor_cobrado(totalVenda());
                    }
                }
            }
        }
    }

    public void removerItem(Item_Vendido item) {
        if (item.getId() != null) {
            itensDeletados.add(item);
        }

        itens.remove(item);
        boletoAdd.setValor_cobrado(totalVenda());
    }

    public void removerBoleto(Boleto boleto) {
        if (boleto.getId() != null) {
            boletosDeletados.add(boleto);
        }

        boletosDeletados.remove(boleto);
    }

    public void addBoleto() {
        int contMes = meses.getNum() - 1;
        int parcela = 1;

        BigDecimal valor;

        if (getEntity().getCliente() == null) {
            FacesMessageUtils.error("O cliente é obrigatório!");
        } else {
            if (dia > 28) {
                FacesMessageUtils.error("O dia do vencimento deve ser menor ou igual a 28!");
            } else {
                if (boletoAdd.getParcela() == null || boletoAdd.getParcela() < 1) {
                    FacesMessageUtils.error("A parcela deve ser maior ou igual a 1 (um)!");
                } else {
                    if (boletoAdd.getValor_cobrado() == null || boletoAdd.getValor_cobrado().compareTo(BigDecimal.ZERO) == 0) {
                        FacesMessageUtils.error("O valor deve ser maior ou igual a zero!");
                    } else {
                        if (boletoAdd.getReferenteA() == null || boletoAdd.getReferenteA().equals("")) {
                            FacesMessageUtils.error("Referente A é obrigatoria!");
                        } else {
                            valor = boletoAdd.getValor_cobrado().divide(new BigDecimal(boletoAdd.getParcela()), 2, RoundingMode.UP);
                            for (int i = 0; i < boletoAdd.getParcela(); i++) {
                                Boleto boleto = new Boleto();
                                boleto.setConvenio(convenio);
                                boleto.setVenda(getEntity());
                                boleto.setCliente(getEntity().getCliente());

                                Calendar vencimento = Calendar.getInstance();

                                if (contMes > 11) {
                                    ano++;
                                    contMes = 0;
                                }

                                vencimento.set(ano, contMes, dia);

                                boleto.setCriacao(new Date());

                                boleto.setVencimento(vencimento.getTime());

                                boleto.setInstrucao_exclusiva(boletoAdd.getInstrucao_exclusiva());

                                boleto.setParcela(parcela);

                                boleto.setReferenteA(getEntity().getReferenteA());

                                boleto.setTotalParcela(boletoAdd.getParcela());

                                boleto.setSituacao(SituacaoBoleto.EMABERTO);

                                boleto.setTravado(false);

                                boleto.setValor_cobrado(valor);

                                boleto.setDesconto(porcentagemParaValor(boletoAdd.getDesconto(), valor));

                                boleto.setMulta(porcentagemParaValor(boletoAdd.getMulta(), valor));

                                boleto.setJuros(porcentagemParaValor(boletoAdd.getJuros(), valor));

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

    public void setarRefenteA() {
        boletoAdd.setReferenteA(getEntity().getReferenteA() != null ? getEntity().getReferenteA() : null);
    }

    public void setarInstrucaoExclusiva() {
        boletoAdd.setInstrucao_exclusiva(getEntity().getDescricao() != null ? getEntity().getDescricao() : null);
    }

    public void setarValorCobrado() {
        boletoAdd.setValor_cobrado(totalVenda());
    }

    public void setarUnitario() {
        unitario = itemAutocomplete.getUnitario();
        qtd = BigDecimal.ONE;
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

    @Override
    public VendaBO getBO() {
        return vendaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    private boolean verificarExistenciaItem() {
        for (Item_Vendido iten : itens) {
            if (itemAutocomplete.equals(iten.getItem())) {
                return true;
            }
        }
        return false;
    }

    public BigDecimal totalPorItem(BigDecimal qtd, BigDecimal unitario) {
        BigDecimal valor = BigDecimal.ZERO;

        if (qtd != null && unitario != null) {
            valor = qtd.multiply(unitario);
        }

        return valor;
    }

    public BigDecimal totalQtd() {
        BigDecimal valor = BigDecimal.ZERO;

        for (Item_Vendido iten : itens) {
            valor = valor.add(iten.getQtd());
        }

        return valor;
    }

    public BigDecimal totalUnitario() {
        BigDecimal valor = BigDecimal.ZERO;

        for (Item_Vendido iten : itens) {
            valor = valor.add(iten.getUnitario());
        }

        return valor;
    }

    public BigDecimal totalVenda() {
        BigDecimal valor = BigDecimal.ZERO;

        for (Item_Vendido iten : itens) {
            valor = valor.add(iten.getQtd().multiply(iten.getUnitario()));
        }

        return valor;
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

    public List<Venda> vendasPorConvenio() {
        vendasPorConvenio = vendaBO.vendasPorConvenio(filtros);
        return vendasPorConvenio;
    }

    public void gerarBoleto(Boleto boleto) {
        List<Boleto> boletosTemp = new ArrayList<Boleto>();
        boletosTemp.add(boleto);
        boletoBO.gerarBoletosEmLote(boletosTemp);
    }

    public void gerarBoletosEmLote() {
        boletoBO.gerarBoletosEmLote(boletos);
    }

    public void carregarLista(Venda venda) {
        itens = itemVendidoBO.getDAO().list("venda_id", venda.getId());
        boletos = boletoBO.getDAO().list("venda_id", venda.getId());
    }

}
