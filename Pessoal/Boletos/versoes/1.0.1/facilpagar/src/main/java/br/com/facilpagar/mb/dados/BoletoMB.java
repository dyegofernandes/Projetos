package br.com.facilpagar.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.facilpagar.bo.dados.BoletoBO;
import br.com.facilpagar.bo.dados.CidadeBO;
import br.com.facilpagar.bo.dados.ClienteBO;
import br.com.facilpagar.bo.dados.ConvenioBO;
import br.com.facilpagar.bo.dados.ProdutoBO;
import br.com.facilpagar.modelo.controleacesso.Usuario;
import br.com.facilpagar.modelo.dados.Boleto;
import br.com.facilpagar.modelo.dados.Cidade;
import br.com.facilpagar.modelo.dados.Cliente;
import br.com.facilpagar.modelo.dados.Convenio;
import br.com.facilpagar.modelo.dados.Produto;
import br.com.facilpagar.modelo.dados.Uf;
import br.com.facilpagar.modelo.dados.vos.BoletoVO;
import br.com.facilpagar.modelo.enums.SituacaoBoleto;
import br.com.facilpagar.modelo.vos.FiltrosBusca;
import br.com.facilpagar.util.SessaoUtils;
import br.com.facilpagar.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.faces.utils.FacesMessageUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

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
    private ClienteBO clienteBO;

    @EJB
    private ProdutoBO produtoBO;

    @EJB
    private CidadeBO cidadeBO;

    @EJB
    private ConvenioBO convenioBO;

    private List<Boleto> boletos;

    private List<Boleto> boletosFind;

    Usuario usuarioAtual;

    private boolean confirmar = false;

    private Date dataMinima = new Date();

    private Date dataMaxima;

    private String nomeBotaoAvancar = "Avançar";

    private String nomeBotaoVoltar = "Voltar";

    private FiltrosBusca filtros;

    private List<Convenio> conveniosFiltros;

    @Override
    public BoletoBO getBO() {
        return boletoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        usuarioAtual = SessaoUtils.getUser();
        confirmar = false;
        filtros = new FiltrosBusca();
        filtros.setFranquia(getDAO().getInitialized(usuarioAtual.getFranquia()));
        filtros.setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
        pegarConveniosFiltros();
        if (getEntity().getId() == null) {
            getEntity().setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
        }
    }

    @Override
    public void save() {
        if (getEntity().getId() == null) {
            getEntity().setNossonumero(getBO().proximoNossoNumero());
        }
        getEntity().setCb(getBO().getCodigoDeBarrasSicoob(getEntity()));
        super.save();
    }

    public Date getDataMinima() {
        return dataMinima;
    }

    public void setDataMinima(Date dataMinima) {
        this.dataMinima = dataMinima;
    }

    public Date getDataMaxima() {
        return dataMaxima;
    }

    public void setDataMaxima(Date dataMaxima) {
        this.dataMaxima = dataMaxima;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public String getNomeBotaoAvancar() {
        return nomeBotaoAvancar;
    }

    public void setNomeBotaoAvancar(String nomeBotaoAvancar) {
        this.nomeBotaoAvancar = nomeBotaoAvancar;
    }

    public String getNomeBotaoVoltar() {
        return nomeBotaoVoltar;
    }

    public void setNomeBotaoVoltar(String nomeBotaoVoltar) {
        this.nomeBotaoVoltar = nomeBotaoVoltar;
    }

    public List<Boleto> getBoletosFind() {
        return boletosFind;
    }

    public void setBoletosFind(List<Boleto> boletosFind) {
        this.boletosFind = boletosFind;
    }

    public FiltrosBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosBusca filtros) {
        this.filtros = filtros;
    }

    public List<Convenio> getConveniosFiltros() {
        return conveniosFiltros;
    }

    public void setConveniosFiltros(List<Convenio> conveniosFiltros) {
        this.conveniosFiltros = conveniosFiltros;
    }

    public String onFlowProcess(FlowEvent event) {

        if (confirmar) {
            setEntity(new Boleto());
            getEntity().setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
            boletos = new ArrayList<Boleto>();

            return "criar";
        } else {
            if (event.getNewStep().equals("criar")) {
                nomeBotaoAvancar = "Gerar Boletos";
                nomeBotaoVoltar = "Voltar";
                boletos = new ArrayList<Boleto>();
                confirmar = false;
            } else {
                if (event.getNewStep().equals("editar")) {
                    nomeBotaoAvancar = "Confirmar";
                    nomeBotaoVoltar = "Voltar";
                    parcelaFixaBoleto();
                    confirmar = false;
                } else {
                    if (event.getNewStep().equals("imprimir")) {
                        nomeBotaoVoltar = "Gerar Novos Boletos";
                        for (Boleto boleto : boletos) {
                            boleto.setNossonumero(getBO().proximoNossoNumero());
                            boleto.setCb(getBO().getCodigoDeBarrasSicoob(boleto));
                            getDAO().saveOrMerge(boleto, true);
                        }
                        confirmar = true;
                    }
                }
            }
        }

        return event.getNewStep();
    }

    public void mudarProduto() {
        if (getEntity().getProduto() != null) {
            Produto produto = getDAO().getInitialized(getEntity().getProduto());
            getEntity().setVl_nominal(produto.getValor_base());
        } else {
            FacesMessageUtils.error("Produto é obrigatório!");
        }
    }

    public void calcularValores(Boleto boleto) {
        if (boleto.getVl_nominal() != null) {
            if (getEntity().getConvenio() != null) {
                Convenio convenio = getDAO().getInitialized(getEntity().getConvenio());

                BigDecimal desconto = Utils.calcularPorcentagem(convenio.getDesconto(), boleto.getVl_nominal());
                BigDecimal juros = Utils.calcularPorcentagem(convenio.getJuros(), boleto.getVl_nominal());
                BigDecimal multa = Utils.calcularPorcentagem(convenio.getMulta(), boleto.getVl_nominal());

                boleto.setVl_desconto(desconto);
                boleto.setVl_juros(juros);
                boleto.setVl_multa(multa);

            } else {
                boleto.setVl_nominal(BigDecimal.ZERO);
                boleto.setVl_desconto(BigDecimal.ZERO);
                boleto.setVl_juros(BigDecimal.ZERO);
                boleto.setVl_multa(BigDecimal.ZERO);
            }
        } else {
            FacesMessageUtils.error("O valor deve ser informado!");
        }
    }

    private void parcelarBoleto() {
        boletos = new ArrayList<Boleto>();

        Convenio convenio = getDAO().getInitialized(getEntity().getConvenio());
        BigDecimal valorParcela = getEntity().getVl_nominal().
                divide(new BigDecimal(getEntity().getQtd_total_parcela()), 2, RoundingMode.DOWN);
        Calendar vencimento = Calendar.getInstance();

        BigDecimal valorTotalTemp = valorParcela.multiply(new BigDecimal(getEntity().getQtd_total_parcela()));
        BigDecimal resto = getEntity().getVl_nominal().subtract(valorTotalTemp);

        BigDecimal desconto = Utils.calcularPorcentagem(convenio.getDesconto(), valorParcela);
        BigDecimal juros = Utils.calcularPorcentagem(convenio.getJuros(), valorParcela);
        BigDecimal multa = Utils.calcularPorcentagem(convenio.getMulta(), valorParcela);
        for (int i = 0; i < getEntity().getQtd_total_parcela(); i++) {

            Boleto boletoTemp = new Boleto();
            boletoTemp.setConvenio(getEntity().getConvenio());
            boletoTemp.setProduto(getEntity().getProduto());
            boletoTemp.setCliente(getEntity().getCliente());
            boletoTemp.setDt_criacao(new Date());

            boletoTemp.setInstrucao_exclusiva(getEntity().getInstrucao_exclusiva());

            boletoTemp.setBanco(convenio.getEmissor());
            boletoTemp.setTiporepasse(convenio.getTipoRepasse());
            boletoTemp.setVl_tarifa(convenio.getComissao());

            vencimento.setTime(getEntity().getDt_vencimento());
            vencimento.add(Calendar.MONTH, i);
            boletoTemp.setDt_vencimento(vencimento.getTime());
            boletoTemp.setDt_impressao(new Date());

            boletoTemp.setNr_parcela(i + 1);
            boletoTemp.setQtd_total_parcela(getEntity().getQtd_total_parcela());

            if (i == getEntity().getQtd_total_parcela() - 1) {
                BigDecimal valorUltima = valorParcela.add(resto);
                BigDecimal descontoUltima = Utils.calcularPorcentagem(convenio.getDesconto(), valorUltima);
                BigDecimal jurosUltima = Utils.calcularPorcentagem(convenio.getJuros(), valorUltima);
                BigDecimal multaUltima = Utils.calcularPorcentagem(convenio.getMulta(), valorUltima);

                boletoTemp.setVl_nominal(valorUltima);
                boletoTemp.setVl_desconto(descontoUltima);
                boletoTemp.setVl_juros(jurosUltima);
                boletoTemp.setVl_multa(multaUltima);
            } else {
                boletoTemp.setVl_nominal(valorParcela);
                boletoTemp.setVl_desconto(desconto);
                boletoTemp.setVl_juros(juros);
                boletoTemp.setVl_multa(multa);
            }

            boletoTemp.setReferentea("Referente à parcela " + boletoTemp.getNr_parcela() + "/" + boletoTemp.getQtd_total_parcela());

            boletos.add(boletoTemp);

        }
    }

    private void parcelaFixaBoleto() {
        boletos = new ArrayList<Boleto>();

        Convenio convenio = getDAO().getInitialized(getEntity().getConvenio());
        BigDecimal valorParcela = getEntity().getVl_nominal();
        Calendar vencimento = Calendar.getInstance();

        BigDecimal desconto = Utils.calcularPorcentagem(convenio.getDesconto(), valorParcela);
        BigDecimal juros = Utils.calcularPorcentagem(convenio.getJuros(), valorParcela);
        BigDecimal multa = Utils.calcularPorcentagem(convenio.getMulta(), valorParcela);
        for (int i = 0; i < getEntity().getQtd_total_parcela(); i++) {

            Boleto boletoTemp = new Boleto();
            boletoTemp.setConvenio(getEntity().getConvenio());
            boletoTemp.setProduto(getEntity().getProduto());
            boletoTemp.setCliente(getEntity().getCliente());
            boletoTemp.setDt_criacao(new Date());

            boletoTemp.setInstrucao_exclusiva(getEntity().getInstrucao_exclusiva());

            boletoTemp.setBanco(convenio.getEmissor());
            boletoTemp.setTiporepasse(convenio.getTipoRepasse());
            boletoTemp.setVl_tarifa(convenio.getComissao());

            vencimento.setTime(getEntity().getDt_vencimento());
            vencimento.add(Calendar.MONTH, i);
            boletoTemp.setDt_vencimento(vencimento.getTime());
            boletoTemp.setDt_impressao(new Date());

            boletoTemp.setNr_parcela(i + 1);
            boletoTemp.setQtd_total_parcela(getEntity().getQtd_total_parcela());

            boletoTemp.setVl_nominal(valorParcela);
            boletoTemp.setVl_desconto(desconto);
            boletoTemp.setVl_juros(juros);
            boletoTemp.setVl_multa(multa);

            boletoTemp.setReferentea("Referente à parcela " + boletoTemp.getNr_parcela() + "/" + boletoTemp.getQtd_total_parcela());

            boletos.add(boletoTemp);

        }
    }
    
    public void gerarBoletoSicob(Boleto boleto) {

        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");

        params.put("LOGO_SICOOB", caminhoImg.concat("/sicoob-logo.png"));

        List<BoletoVO> boletosTemp = new ArrayList<BoletoVO>();
        Convenio convenio = getDAO().getInitialized(boleto.getConvenio());
        Cliente cliente = getDAO().getInitialized(boleto.getCliente());
        Cidade cidade = getDAO().getInitialized(cliente.getCidade());
        Uf estado = getDAO().getInitialized(cidade.getUf());

        BoletoVO boletoTemp = new BoletoVO(convenio.toString(), boleto.getNossonumero().toString(), boleto.getNossonumero(), boleto.getDt_vencimento(),
                boleto.getVl_nominal(), boleto.getVl_multa(), boleto.getVl_desconto(), boleto.getVl_juros(), cliente.toString(), convenio.getLocalPagto(),
                boleto.getDt_criacao(), boleto.getInstrucao_exclusiva(), boleto.getReferentea() + " - 2º Via ",
                (cliente.getEndereco() + ", " + cliente.getBairro() + ", " + cidade.getNome() + "-" + estado.getSigla()),
                getBO().linhaEditavel(boleto.getCb()), boleto.getCb());
        boletosTemp.add(boletoTemp);

        FacesJasper.createJasperReport(boletosTemp, params,
                "/WEB-INF/report/boletos/boletoSicoob.jasper", "Boleto" + ".pdf");
    }
    
    public void gerarBoletoBB(Boleto boleto) {

        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");

        params.put("LOGO_SICOOB", caminhoImg.concat("/bb-logo.png"));

        List<BoletoVO> boletosTemp = new ArrayList<BoletoVO>();
        Convenio convenio = getDAO().getInitialized(boleto.getConvenio());
        Cliente cliente = getDAO().getInitialized(boleto.getCliente());
        Cidade cidade = getDAO().getInitialized(cliente.getCidade());
        Uf estado = getDAO().getInitialized(cidade.getUf());

        BoletoVO boletoTemp = new BoletoVO(convenio.toString(), boleto.getNossonumero().toString(), boleto.getNossonumero(), boleto.getDt_vencimento(),
                boleto.getVl_nominal(), boleto.getVl_multa(), boleto.getVl_desconto(), boleto.getVl_juros(), cliente.toString(), convenio.getLocalPagto(),
                boleto.getDt_criacao(), boleto.getInstrucao_exclusiva(), boleto.getReferentea() + " - 2º Via ",
                (cliente.getEndereco() + ", " + cliente.getBairro() + ", " + cidade.getNome() + "-" + estado.getSigla()),
                getBO().linhaEditavel(boleto.getCb()), boleto.getCb());
        boletosTemp.add(boletoTemp);

        FacesJasper.createJasperReport(boletosTemp, params,
                "/WEB-INF/report/boletos/boletobb.jasper", "Boleto" + ".pdf");
    }

    public void gerarBoletosSicoob() {

        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");

        params.put("LOGO_SICOOB", caminhoImg.concat("/sicoob-logo.png"));

        List<BoletoVO> boletosTemp = new ArrayList<BoletoVO>();

        for (Boleto boleto : boletos) {
            Convenio convenio = getDAO().getInitialized(boleto.getConvenio());
            Cliente cliente = getDAO().getInitialized(boleto.getCliente());
            Cidade cidade = getDAO().getInitialized(cliente.getCidade());
            Uf estado = getDAO().getInitialized(cidade.getUf());

            BoletoVO boletoTemp = new BoletoVO(convenio.toString(), boleto.getNossonumero().toString(), boleto.getNossonumero(), boleto.getDt_vencimento(),
                    boleto.getVl_nominal(), boleto.getVl_multa(), boleto.getVl_desconto(), boleto.getVl_juros(), cliente.toString(), convenio.getLocalPagto(),
                    boleto.getDt_criacao(), boleto.getInstrucao_exclusiva(), boleto.getReferentea(),
                    (cliente.getEndereco() + ", " + cliente.getBairro() + ", " + cidade.getNome() + "-" + estado.getSigla()),
                    getBO().linhaEditavel(boleto.getCb()), boleto.getCb());
            boletosTemp.add(boletoTemp);
        }

        FacesJasper.createJasperReport(boletosTemp, params,
                "/WEB-INF/report/boletos/boletoSicoob.jasper", "Boleto" + ".pdf");
    }
    
    public void gerarBoletosBB() {

        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");

        params.put("LOGO_SICOOB", caminhoImg.concat("/bb-logo.png"));

        List<BoletoVO> boletosTemp = new ArrayList<BoletoVO>();

        for (Boleto boleto : boletos) {
            Convenio convenio = getDAO().getInitialized(boleto.getConvenio());
            Cliente cliente = getDAO().getInitialized(boleto.getCliente());
            Cidade cidade = getDAO().getInitialized(cliente.getCidade());
            Uf estado = getDAO().getInitialized(cidade.getUf());

            BoletoVO boletoTemp = new BoletoVO(convenio.toString(), boleto.getNossonumero().toString(), boleto.getNossonumero(), boleto.getDt_vencimento(),
                    boleto.getVl_nominal(), boleto.getVl_multa(), boleto.getVl_desconto(), boleto.getVl_juros(), cliente.toString(), convenio.getLocalPagto(),
                    boleto.getDt_criacao(), boleto.getInstrucao_exclusiva(), boleto.getReferentea(),
                    (cliente.getEndereco() + ", " + cliente.getBairro() + ", " + cidade.getNome() + "-" + estado.getSigla()),
                    getBO().linhaEditavel(boleto.getCb()), boleto.getCb());
            boletosTemp.add(boletoTemp);
        }

        FacesJasper.createJasperReport(boletosTemp, params,
                "/WEB-INF/report/boletos/boletobb.jasper", "Boleto" + ".pdf");
    }

    public void cancelarBoleto(Boleto boleto) {
        if (boleto.getSituacao() == SituacaoBoleto.EM_ABERTO) {
            boleto.setSituacao(SituacaoBoleto.CANCELADO);
            boleto.setDt_baixado(new Date());
            getDAO().saveOrMerge(boleto, true);
            FacesMessageUtils.sucess();
        } else {
            FacesMessageUtils.error("Boleto só pode ser cancelado com situação Em Aberto!");
        }
    }

    public List<Cliente> autocompleteCliente(String nome) {
        return clienteBO.clientesPeloNomeOrCnpjOuCpf(nome, getEntity().getConvenio());
    }

    public List<Produto> autocompleteProduto(String nome) {
        return produtoBO.produtosPeloNomeEConvenio(nome, getEntity().getConvenio());
    }

    public List<Cliente> autocompleteClienteFiltros(String nome) {
        return clienteBO.clientesPeloNomeOrCnpjOuCpf(nome, filtros.getConvenio());
    }

    public List<Produto> autocompleteProdutoFiltros(String nome) {
        return produtoBO.produtosPeloNomeEConvenio(nome, filtros.getConvenio());
    }

    public void buscar() {
        boletosFind = getBO().listar(filtros);
    }

    public List<Cidade> autocompleteCidadeFiltro(String nome) {
        return cidadeBO.listarCidadePeloNomeEEstado(filtros.getEstado(), nome);
    }

    /**
     *
     * @param valorTotal
     * @param parcelas
     * @return
     */
    public String valorParcelaDivide(BigDecimal valorTotal, Integer parcelas) {
        if (valorTotal != null && parcelas != null) {
            if (parcelas > 0) {
                BigDecimal resultado = valorTotal.divide(new BigDecimal(parcelas), 2, RoundingMode.DOWN);
                return parcelas.toString().concat("x de R$ ").concat(Utils.moeda(resultado));
            } else {
                FacesMessageUtils.error("O número de parcelas deve ser maior que Zero!");
                return "";
            }
        }
        return "";
    }
    
    public String valorParcela(BigDecimal valorTotal, Integer parcelas) {
        if (valorTotal != null && parcelas != null) {
            if (parcelas > 0) {
                BigDecimal resultado = valorTotal;
                return parcelas.toString().concat("x de R$ ").concat(Utils.moeda(resultado));
            } else {
                FacesMessageUtils.error("O número de parcelas deve ser maior que Zero!");
                return "";
            }
        }
        return "";
    }


    public void pegarConveniosFiltros() {
        conveniosFiltros = new ArrayList<Convenio>();

        if (filtros.getFranquia() != null) {
            conveniosFiltros = convenioBO.convenioPelaFranquia(filtros.getFranquia());
        }
    }

    public List<Convenio> convenioPeloNomeEFranquia(String nome) {
        return convenioBO.conveniosPeloNomeOrCnpjOuCpfEFranquia(usuarioAtual.getFranquia(), nome);
    }

}
