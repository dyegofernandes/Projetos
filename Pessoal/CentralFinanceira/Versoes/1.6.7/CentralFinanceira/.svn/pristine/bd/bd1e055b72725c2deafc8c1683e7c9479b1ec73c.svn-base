package br.com.jsoft.centralfinanceira.mb.financeiro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.financeiro.ContasAPagarBO;
import br.com.jsoft.centralfinanceira.bo.financeiro.ContasAPagarVencimentosBO;
import br.com.jsoft.centralfinanceira.bo.financeiro.ReceitaDespesaBO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.modelo.enums.NaturezaDespesa;
import br.com.jsoft.centralfinanceira.modelo.enums.Periodicidade;
import br.com.jsoft.centralfinanceira.modelo.enums.Quitado;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagar;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagarVencimentos;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ReceitaDespesa;
import br.com.jsoft.centralfinanceira.util.SessaoUtils;
import br.com.jsoft.centralfinanceira.vo.VencimentoParcela;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
import com.xpert.utils.DateUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.context.RequestContext;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class ContasAPagarMB extends AbstractBaseBean<ContasAPagar> implements Serializable {

    @EJB
    private ContasAPagarBO contasAPagarBO;

    @EJB
    private ContasAPagarVencimentosBO vencimentosBO;
    
    @EJB
    private ReceitaDespesaBO receitaDespesaBO;

    ContasAPagarVencimentos vencimento;

    ContasAPagarVencimentos vencimentoCancelado;

    List<ContasAPagarVencimentos> vencimentos;

    List<ContasAPagarVencimentos> vencimentosDeletados;
    
    List<ReceitaDespesa> despesas;

    private BigDecimal aliqIss;

    private BigDecimal aliqIrrf;

    private BigDecimal aliqIcms;

    private BigDecimal aliqPiCoCs;

    private BigDecimal aliqInss;

    private VencimentoParcela vencimentoParcela;

    private boolean atualizar = false;

    @Override
    public void init() {
        despesas = receitaDespesaBO.getDAO().list("natureza", NaturezaDespesa.SAIDA, "nome");
        vencimentosDeletados = new ArrayList<ContasAPagarVencimentos>();
        setarPeriodo(getEntity().getEntrada());
        Empresa empresa = contasAPagarBO.getDAO().getInitialized(SessaoUtils.getUser().getEmpresa());
        getEntity().setEmpresa(empresa);
        if (getEntity().getId() != null) {
            vencimentos = vencimentosBO.getDAO().list("contasapagar_id", getEntity().getId(), "data DESC");
        } else {
            vencimentos = new ArrayList<ContasAPagarVencimentos>();
        }
    }

    @Override
    public void save() {
        if (vencimentos.size() < 1) {
            FacesMessageUtils.error("Nenhum vencimento cadastrado!");
        } else {
            if (verificaSeExisteDatasMenosQueDataEntrega()) {
                FacesMessageUtils.error("Não pode existir data de vencimentos inferiores a data de entrada!");
            } else {
                if (verificaSeExisteDatasIguais()) {
                    FacesMessageUtils.error("Não pode existir vencimentos com a mesma data!");
                } else {
                    if (!(getEntity().getValor().compareTo(somaDosVencimentos()) == 0)) {
                        getEntity().setValorBruto(somaDosVencimentos());
                    }

                    setarValorLiquido();

                    super.save();

                    for (ContasAPagarVencimentos vencDeletados : vencimentosDeletados) {
                        try {
                            vencimentosBO.getDAO().delete(vencDeletados.getId(), true);
                        } catch (DeleteException ex) {
                            Logger.getLogger(ContasAPagarMB.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    for (ContasAPagarVencimentos vencimento1 : vencimentos) {
                        vencimentosBO.getDAO().saveOrMerge(vencimento1, true);
                    }

                }
            }
        }
    }

    @Override
    public ContasAPagarBO getBO() {
        return contasAPagarBO;
    }

    @Override
    public String getDataModelOrder() {
        return "estabelecimento, fornecedor, entrada";
    }

    public void novoVencimentoView(ContasAPagarVencimentos vencimentoEditado) {
        if (vencimentoEditado != null) {
            atualizar = true;
            vencimento = vencimentoEditado;
        } else {
            atualizar = false;
            novoVencimento();
        }

        RequestContext.getCurrentInstance().execute("PF('widgetNovoVencimento').show()");
    }

    public List<ContasAPagarVencimentos> getVencimentos() {
        return vencimentos;
    }

    public List<ReceitaDespesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<ReceitaDespesa> despesas) {
        this.despesas = despesas;
    }

    public ContasAPagarVencimentos getVencimento() {
        return vencimento;
    }

    public void setVencimento(ContasAPagarVencimentos vencimento) {
        this.vencimento = vencimento;
    }

    public void setVencimentos(List<ContasAPagarVencimentos> vencimentos) {
        this.vencimentos = vencimentos;
    }

    public BigDecimal getAliqIss() {
        BigDecimal valor = BigDecimal.ZERO;

        if (getEntity().getIssValor() != null && getEntity().getIssBase() != null && !(getEntity().getIssBase().compareTo(BigDecimal.ZERO) == 0)) {
            valor = valor.add(getEntity().getIssValor().multiply(new BigDecimal(100)).divide(getEntity().getIssBase()));
        }

        return valor;
    }

    public BigDecimal getAliqIrrf() {

        BigDecimal valor = BigDecimal.ZERO;

        if ((getEntity().getIrrfCnpj() != null) && (getEntity().getIrrfBase() != null) && !(getEntity().getIrrfCnpj().compareTo(BigDecimal.ZERO) == 0)) {
            valor = valor.add(getEntity().getIrrfCnpj().multiply(new BigDecimal(100)).divide(getEntity().getIrrfBase()));
        }

        return valor;
    }

    public BigDecimal getAliqIcms() {
        BigDecimal valor = BigDecimal.ZERO;

        if ((getEntity().getIcmsValor() != null) && (getEntity().getIcmsBase() != null) && !(getEntity().getIcmsBase().compareTo(BigDecimal.ZERO) == 0)) {
            valor = valor.add(getEntity().getIcmsValor().multiply(new BigDecimal(100)).divide(getEntity().getIcmsBase()));
        }

        return valor;
    }

    public BigDecimal getAliqPiCoCs() {
        BigDecimal valor = BigDecimal.ZERO;

        if ((getEntity().getPisValor() != null) && (getEntity().getPisBase() != null) && !(getEntity().getPisBase().compareTo(BigDecimal.ZERO) == 0)) {
            valor = valor.add(getEntity().getPisValor().multiply(new BigDecimal(100)).divide(getEntity().getPisBase()));
        }

        return valor;
    }

    public BigDecimal getAliqInss() {
        BigDecimal valor = BigDecimal.ZERO;

        if ((getEntity().getInssCnpj() != null) && (getEntity().getInssBase() != null) && !(getEntity().getInssBase().compareTo(BigDecimal.ZERO) == 0)) {
            valor = valor.add(getEntity().getInssCnpj().multiply(new BigDecimal(100)).divide(getEntity().getInssBase()));
        }

        return valor;
    }

    public void setAliqIss(BigDecimal aliqIss) {
        this.aliqIss = aliqIss;
    }

    public void setAliqIrrf(BigDecimal aliqIrrf) {
        this.aliqIrrf = aliqIrrf;
    }

    public void setAliqIcms(BigDecimal aliqIcms) {
        this.aliqIcms = aliqIcms;
    }

    public void setAliqPiCoCs(BigDecimal aliqPiCoCs) {
        this.aliqPiCoCs = aliqPiCoCs;
    }

    public void setAliqInss(BigDecimal aliqInss) {
        this.aliqInss = aliqInss;
    }

    public VencimentoParcela getVencimentoParcela() {
        return vencimentoParcela;
    }

    public void setVencimentoParcela(VencimentoParcela vencimentoParcela) {
        this.vencimentoParcela = vencimentoParcela;
    }

    public void setarValorIss() {
        BigDecimal valor = BigDecimal.ZERO;

        if (aliqIss != null && getEntity().getIssBase() != null) {
            valor = valor.add(getEntity().getIssBase().multiply(aliqIss).divide(new BigDecimal(100)));
        }

        getEntity().setIssValor(valor);
        setarValorLiquido();
    }

    public void setarValorIrrf() {
        BigDecimal valor = BigDecimal.ZERO;

        if (aliqIrrf != null && getEntity().getIrrfBase() != null) {
            valor = valor.add(getEntity().getIrrfBase().multiply(aliqIrrf).divide(new BigDecimal(100)));
        }

        getEntity().setIrrfCnpj(valor);
        setarValorLiquido();
    }

    public void setarValorIcms() {
        BigDecimal valor = BigDecimal.ZERO;

        if (aliqIcms != null && getEntity().getIcmsBase() != null) {
            valor = valor.add(getEntity().getIcmsBase().multiply(aliqIcms).divide(new BigDecimal(100)));
        }

        getEntity().setIcmsValor(valor);
        setarValorLiquido();
    }

    public void setarValorPis() {
        BigDecimal valor = BigDecimal.ZERO;

        if (aliqPiCoCs != null && getEntity().getPisBase() != null) {
            valor = valor.add(getEntity().getPisBase().multiply(aliqPiCoCs).divide(new BigDecimal(100)));
        }

        getEntity().setPisValor(valor);
        setarValorLiquido();
    }

    public void setarValorInss() {
        BigDecimal valor = BigDecimal.ZERO;

        if (aliqInss != null && getEntity().getInssBase() != null) {
            valor = valor.add(getEntity().getInssBase().multiply(aliqInss).divide(new BigDecimal(100)));
        }

        getEntity().setInssCnpj(valor);
        setarValorLiquido();
    }

    public void setarValorLiquido() {
        BigDecimal valorIss = getEntity().getIssValor() != null ? getEntity().getIssValor() : BigDecimal.ZERO;
        BigDecimal valorIrr = getEntity().getIrrfCnpj() != null ? getEntity().getIrrfCnpj() : BigDecimal.ZERO;
        BigDecimal valorIcms = getEntity().getIcmsValor() != null ? getEntity().getIcmsValor() : BigDecimal.ZERO;
        BigDecimal valorPis = getEntity().getPisValor() != null ? getEntity().getPisValor() : BigDecimal.ZERO;
        BigDecimal valorInss = getEntity().getInssCnpj() != null ? getEntity().getInssCnpj() : BigDecimal.ZERO;

        BigDecimal valorLiquido = BigDecimal.ZERO;

        valorLiquido = valorLiquido.subtract(valorIss).subtract(valorIrr).subtract(valorIcms).subtract(valorPis).subtract(valorInss);

        if (getEntity().getValorBruto() != null) {
            valorLiquido = valorLiquido.add(getEntity().getValorBruto());
        }

        getEntity().setValor(valorLiquido);
    }

    public ContasAPagarVencimentos getVencimentoCancelado() {
        return vencimentoCancelado;
    }

    public void setVencimentoCancelado(ContasAPagarVencimentos vencimentoCancelado) {
        this.vencimentoCancelado = vencimentoCancelado;
    }

    public boolean isAtualizar() {
        return atualizar;
    }

    public void setAtualizar(boolean atualizar) {
        this.atualizar = atualizar;
    }

    public void novoVencimento() {
        vencimento = new ContasAPagarVencimentos();

        vencimento.setContasAPagar(getEntity());

        vencimento.setEmpresa(getEntity().getEmpresa());

        vencimento.setData(getEntity().getEntrada());

        vencimento.setValor(somaDosVencimentos().subtract(getEntity().getValor()));

        vencimento.setSequencial(1);
    }

    public void adicionarVencimento() {
        if (somaDosVencimentos().compareTo(getEntity().getValor()) > 0) {
            FacesMessageUtils.error("Valor da soma dos vencimentos não pode ser maior que o valor bruto!");
        } else {
            if (vencimento.getData().before(getEntity().getEntrada())) {
                FacesMessageUtils.error("Data do vencimento não pode ser inferior a data da entrada!");
            } else {
                if (vencimento.getValor().compareTo(BigDecimal.ZERO) == 0) {
                    FacesMessageUtils.error("O valor do vencimento não pode ser igual a 0 (zero)!");
                } else {
                    if (seExisteDataVencimento()) {
                        FacesMessageUtils.error("Já existe vencimento para esta data!");
                    } else {
                        RequestContext.getCurrentInstance().execute("PF('widgetNovoVencimento').hide()");
                        if (atualizar) {
                            FacesMessageUtils.info("Vencimento atualizado!");
                        } else {
                            vencimentos.add(vencimento);
                        }

                    }

                }
            }
        }

    }
    

    public void cancelarVencimentoView(ContasAPagarVencimentos vencCancel) {
        if (vencCancel.getQuitado() == Quitado.SIM) {
            FacesMessageUtils.error("Vencimento quitado não pode ser cancelado!");
        } else {
            vencCancel.setDataCancelamento(new Date());
            vencimentoCancelado = vencCancel;
            RequestContext.getCurrentInstance().execute("PF('widgetCanceldarVencimento').show()");
        }
    }

    public void cancelarVencimento() {

        if (vencimentoCancelado.getDataCancelamento().before(getEntity().getEntrada())) {
            FacesMessageUtils.error("Data de Cancelamento não pode ser inferior a data de Entrada!");
        } else {
            if (vencimentoCancelado.getMotivoCancelamento().length() < 15) {
                FacesMessageUtils.error("Motivo deve ter no mínimo 15 caracteres!");
            } else {
                RequestContext.getCurrentInstance().execute("PF('widgetCanceldarVencimento').hide()");
                FacesMessageUtils.info("Vencimento cancelado!");
            }
        }

    }

    private BigDecimal somaDosVencimentos() {
        BigDecimal soma = BigDecimal.ZERO;

        for (ContasAPagarVencimentos vencimentoTemp : vencimentos) {
            if (vencimento != vencimentoTemp) {
                soma = soma.add(vencimentoTemp.getValor());
            }
        }

        if (vencimento != null) {
            if (vencimento.getValor() != null) {
                soma = soma.add(vencimento.getValor());
            }
        }

        return soma;

    }

    private boolean seExisteDataVencimento() {
        boolean retorno = false;
        for (ContasAPagarVencimentos vencimentoTemp : vencimentos) {
            if (vencimento != vencimentoTemp) {
                if (vencimento.getData().equals(vencimentoTemp.getData())) {
                    retorno = true;
                }
            }
        }

        return retorno;
    }

    public void setarPeriodo(Date data) {
        String periodo = "";

        if (data != null) {
            periodo = DateUtils.dateToString(data, "yyyyMM");
        }
        getEntity().setAnoMesComp(periodo);

    }

    public void gerarVencimentosView() {
        vencimentoParcela = new VencimentoParcela();
        RequestContext.getCurrentInstance().execute("PF('widgetVencimentoParcelas').show()");
    }

    /**
     * Metodo usado para gerar os parcelas de vencimentos
     */
    public void gerarVencimento() {
        BigDecimal adicionalParcela = BigDecimal.ZERO;
        BigDecimal valorParcela = BigDecimal.ZERO;

        Date dataParcela = vencimentoParcela.getPrimeiraParcela();

        if (vencimentoParcela.getValorAdicional() != null) {

            adicionalParcela = adicionalParcela.add(vencimentoParcela.getValorAdicional().
                    divide(new BigDecimal(vencimentoParcela.getNumParcelas())));
        }

        valorParcela = valorParcela.add(vencimentoParcela.getValorDaParcela()).add(adicionalParcela);

        for (int i = 0; i < vencimentoParcela.getNumParcelas(); i++) {
            vencimento = new ContasAPagarVencimentos();

            vencimento.setContasAPagar(getEntity());

            vencimento.setEmpresa(getEntity().getEmpresa());

            vencimento.setData(dataParcela);

            vencimento.setValor(valorParcela);

            vencimento.setSequencial(i + 1);

            vencimento.setNumTitulo(vencimentoParcela.getTitulo().concat("-").concat((i + 1) + "/").concat(vencimentoParcela.getNumParcelas() + ""));

            vencimentos.add(vencimento);

            dataParcela = addPeriodicidade(dataParcela, vencimentoParcela.getPeriodicidade(), vencimentoParcela.getNumPeriodicidade());

        }

        RequestContext.getCurrentInstance().execute("PF('widgetVencimentoParcelas').hide()");
    }

    private Date addPeriodicidade(Date data, Periodicidade periodicidade, Integer numPeriod) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);

        if (periodicidade == Periodicidade.DIAS) {
            c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + numPeriod);
        } else {
            c.set(Calendar.MONTH, c.get(Calendar.MONTH) + numPeriod);
        }

        return c.getTime();
    }

    private boolean verificaSeExisteDatasIguais() {
        int cont = 0;

        for (ContasAPagarVencimentos vencimentoVerificado : vencimentos) {
            for (ContasAPagarVencimentos vencimentoComparado : vencimentos) {
                if (vencimentoVerificado.getData().equals(vencimentoComparado.getData())) {
                    cont++;
                    if (cont > 1) {
                        return true;
                    }
                }
            }
            cont = 0;
        }
        return false;
    }

    private boolean verificaSeExisteDatasMenosQueDataEntrega() {
        for (ContasAPagarVencimentos vencimentoVerificado : vencimentos) {
            if (vencimentoVerificado.getData().before(getEntity().getEntrada())) {
                return true;
            }
        }
        return false;
    }

    public void excluirLista(ContasAPagarVencimentos vencimentoDeletado) {
        if (vencimentoDeletado.getId() != null) {
            vencimentosDeletados.add(vencimentoDeletado);
        }

        vencimentos.remove(vencimentoDeletado);
    }   
}
