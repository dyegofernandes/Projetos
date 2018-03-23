package br.com.pagcontascarne.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.BoletoBO;
import br.com.pagcontascarne.bo.dados.ClienteBO;
import br.com.pagcontascarne.bo.dados.ProdutoBO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Banco;
import br.com.pagcontascarne.modelo.dados.Boleto;
import br.com.pagcontascarne.modelo.dados.Cidade;
import br.com.pagcontascarne.modelo.dados.Cliente;
import br.com.pagcontascarne.modelo.dados.Convenio;
import br.com.pagcontascarne.modelo.dados.Produto;
import br.com.pagcontascarne.modelo.dados.Uf;
import br.com.pagcontascarne.modelo.dados.vos.BoletoVO;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
import br.com.pagcontascarne.util.SessaoUtils;
import br.com.pagcontascarne.util.Utils;
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

    private List<Boleto> boletos;

    private List<Boleto> boletosFind;

    Usuario usuarioAtual = SessaoUtils.getUser();

    private boolean confirmar = false;

    private Date dataMinima = new Date();

    private Date dataMaxima;

    private String nomeBotaoAvancar = "Avançar";

    private String nomeBotaoVoltar = "Voltar";

    private FiltrosBusca filtros;

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
        filtros = new FiltrosBusca();
        filtros.setConvenio(usuarioAtual.getConvenio());
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

    public String onFlowProcess(FlowEvent event) {

        if (event.getNewStep().equals("criar")) {
            nomeBotaoAvancar = "Gerar Boletos";
            nomeBotaoVoltar = "Voltar";
            boletos = new ArrayList<Boleto>();
            confirmar = false;
        }

        if (event.getNewStep().equals("editar")) {
            nomeBotaoAvancar = "Confirmar";
            nomeBotaoVoltar = "Voltar";
            parcelarBoleto();
            confirmar = false;
        }

        if (event.getNewStep().equals("imprimir")) {
            nomeBotaoVoltar = "Gerar Novos Boletos";
            for (Boleto boleto : boletos) {
                boleto.setNossonumero(getBO().proximoNossoNumero());
                boleto.setCb(getBO().getCodigoDeBarrasSicoob(boleto));
                getDAO().save(boleto, true);
            }
            confirmar = true;
        }

        if (confirmar) {
            setEntity(new Boleto());
            getEntity().setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
            boletos = new ArrayList<Boleto>();

            return "criar";
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

    public void gerarBoleto(Boleto boleto) {

        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");

        params.put("LOGO_SICOOB", caminhoImg.concat("/sicoob.png"));

        List<BoletoVO> boletosTemp = new ArrayList<BoletoVO>();
        Convenio convenio = getDAO().getInitialized(boleto.getConvenio());
        Cliente cliente = getDAO().getInitialized(boleto.getCliente());
        Cidade cidade = getDAO().getInitialized(cliente.getCidade());
        Uf estado = getDAO().getInitialized(cidade.getUf());

        BoletoVO boletoTemp = new BoletoVO(boleto.getNossonumero().toString(), boleto.getNossonumero(), boleto.getDt_vencimento(),
                boleto.getVl_nominal(), boleto.getVl_multa(), boleto.getVl_desconto(), cliente.toString(), convenio.getLocalPagto(),
                boleto.getDt_criacao(), boleto.getInstrucao_exclusiva(), boleto.getReferentea(),
                (cliente.getEndereco() + ", " + cliente.getBairro() + ", " + cidade.getNome() + "-" + estado.getSigla()),
                getBO().linhaEditavel(boleto.getCb()), boleto.getCb());
        boletosTemp.add(boletoTemp);

        FacesJasper.createJasperReport(boletosTemp, params,
                "/WEB-INF/boletos/boletosSicoob.jasper", "Boleto" + ".pdf");
    }

    public void gerarBoletos(List<Boleto> boletos) {

        HashMap params = new HashMap();
        String caminhoImg = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");

        params.put("LOGO_SICOOB", caminhoImg.concat("/sicoob.png"));

        List<BoletoVO> boletosTemp = new ArrayList<BoletoVO>();

        for (Boleto boleto : boletos) {
            Convenio convenio = getDAO().getInitialized(boleto.getConvenio());
            Cliente cliente = getDAO().getInitialized(boleto.getCliente());
            Cidade cidade = getDAO().getInitialized(cliente.getCidade());
            Uf estado = getDAO().getInitialized(cidade.getUf());

            BoletoVO boletoTemp = new BoletoVO(boleto.getNossonumero().toString(), boleto.getNossonumero(), boleto.getDt_vencimento(),
                    boleto.getVl_nominal(), boleto.getVl_multa(), boleto.getVl_desconto(), cliente.toString(), convenio.getLocalPagto(),
                    boleto.getDt_criacao(), boleto.getInstrucao_exclusiva(), boleto.getReferentea(),
                    (cliente.getEndereco() + ", " + cliente.getBairro() + ", " + cidade.getNome() + "-" + estado.getSigla()),
                    getBO().linhaEditavel(boleto.getCb()), boleto.getCb());
            boletosTemp.add(boletoTemp);
        }

        FacesJasper.createJasperReport(boletosTemp, params,
                "/WEB-INF/boletos/boletosSicoob.jasper", "Boletos " + ".pdf");
    }

    public List<Cliente> autocompleteCliente(String nome) {
        return clienteBO.clientesPeloNomeOrCnpjOuCpf(nome, getEntity().getConvenio());
    }

    public List<Produto> autocompleteProduto(String nome) {
        return produtoBO.produtosPeloNomeEConvenio(nome, getEntity().getConvenio());
    }

    public void buscar() {
        boletosFind = getBO().listar(filtros);
    }
}
