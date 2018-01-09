package com.opfacil.mb.pagamento;

import com.opfacil.VOs.FiltroDeBusca;
import com.opfacil.bo.cadastro.EmpresaBO;
import com.opfacil.bo.cadastro.FuncionarioBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.opfacil.bo.pagamento.PagamentoBO;
import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.cadastro.Funcionario;
import com.opfacil.modelo.enums.SituacaoOp;
import com.opfacil.modelo.pagamento.Pagamento;
import com.opfacil.util.SessaoUtils;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class PagamentoMB extends AbstractBaseBean<Pagamento> implements Serializable {

    @EJB
    private PagamentoBO pagamentoBO;

    @EJB
    private FuncionarioBO funcionarioBO;

    @EJB
    private EmpresaBO empresaBO;

    private List<Empresa> empresas;

    private List<Funcionario> funcionarios;

    private List<Pagamento> pagamentosNaoGerados;

    private List<Pagamento> pagamentosPorEmpresa;

    private FiltroDeBusca campoDeBusca;

    private SimpleDateFormat formataData = new SimpleDateFormat("yyyyMMdd");

    @Override
    public PagamentoBO getBO() {
        return pagamentoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void save() {
        getEntity().setUsuario(SessaoUtils.getUser());

        if (getEntity().getId() == null) {
            Long ultimoId = ((Long) pagamentoBO.getDAO().getQueryBuilder().from(Pagamento.class).max("id", 0)) + 1;
            getEntity().setOp(formataData.format(new Date()).concat(ultimoId.toString()).concat("OF"));

            if (getEntity().getFuncionario() != null) {
                Funcionario funcionarioTemp = pagamentoBO.getDAO().getInitialized(getEntity().getFuncionario());
                getEntity().setEmpresa(funcionarioTemp.getEmpresa());
            }
        }

        super.save();
    }

    @Override
    public void delete() {
        Pagamento pagamento = pagamentoBO.getDAO().unique("id", (Long) getId());

        if (pagamento.getSituacao() == SituacaoOp.GERADA) {
            FacesMessageUtils.error("Pagamentos com situação Gerada não podem ser Excluídos, situação será mudada para Cancelada!");
            pagamento.setSituacao(SituacaoOp.CANCELADA);
            pagamentoBO.getDAO().saveOrMerge(pagamento, true);
            postSave();
        } else {
            if (pagamento.getSituacao() == SituacaoOp.CANCELADA) {
                FacesMessageUtils.error("Pagamentos com situação Cancelada não podem ser Excluídos!");
                postSave();
            } else {
                if (pagamento.getSituacao() == SituacaoOp.NAOGERADA) {
                    super.delete();
                }
            }
        }

    }

    @Override
    public void init() {
        campoDeBusca = new FiltroDeBusca();
        pagamentosNaoGerados = pagamentoBO.listarPagamentosPorSituacao(null, SessaoUtils.getUser().getEmpresa(), null, null, SituacaoOp.NAOGERADA);
        funcionarios = funcionarioBO.getFuncionariosAutorizados(SessaoUtils.getUser());
        campoDeBusca.setUsuario(SessaoUtils.getUser());
        pagamentosPorEmpresa = pagamentoBO.listPagamentos(campoDeBusca);
        empresas = empresaBO.getListEmpresasAutorizadas(SessaoUtils.getUser());
    }

    @Override
    public void postSave() {
        setEntity(new Pagamento());
        pagamentosPorEmpresa = pagamentoBO.listPagamentos(campoDeBusca);
        pagamentosNaoGerados = pagamentoBO.listarPagamentosPorSituacao(SessaoUtils.getUser(), null, null, null, SituacaoOp.NAOGERADA);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Pagamento> getPagamentosNaoGerados() {
        return pagamentosNaoGerados;
    }

    public List<Pagamento> getPagamentosPorEmpresa() {
        return pagamentosPorEmpresa;
    }

    public void setPagamentosPorEmpresa(List<Pagamento> pagamentosPorEmpresa) {
        this.pagamentosPorEmpresa = pagamentosPorEmpresa;
    }

    public void setPagamentosNaoGerados(List<Pagamento> pagamentosNaoGerados) {
        this.pagamentosNaoGerados = pagamentosNaoGerados;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public BigDecimal getTotalPagamentos() {
        BigDecimal valor = BigDecimal.ZERO;
        for (Pagamento pagamento : pagamentosNaoGerados) {
            Funcionario funcionario = pagamentoBO.getDAO().getInitialized(pagamento.getFuncionario());
            if (funcionario != null) {
                if (pagamento.getValorPagto() != null) {
                    valor = valor.add(pagamento.getValorPagto());
                }
            }
        }
        return valor;
    }

    public BigDecimal getTotalTarifa() {
        BigDecimal valor = BigDecimal.ZERO;
        for (Pagamento pagamento : pagamentosNaoGerados) {
            Funcionario funcionario = pagamentoBO.getDAO().getInitialized(pagamento.getFuncionario());
            if (funcionario != null) {
                Empresa empresa = pagamentoBO.getDAO().getInitialized(funcionario.getEmpresa());

                valor = valor.add(empresa.getValorTarifa());
            }
        }
        return valor;
    }

    public BigDecimal getTotalPagamentosComTarifa() {
        BigDecimal valor = BigDecimal.ZERO;
        for (Pagamento pagamento : pagamentosNaoGerados) {
            Funcionario funcionario = pagamentoBO.getDAO().getInitialized(pagamento.getFuncionario());
            if (funcionario != null) {
                Empresa empresa = pagamentoBO.getDAO().getInitialized(funcionario.getEmpresa());

                valor = valor.add(empresa.getValorTarifa()).add(pagamento.getValorPagto());
            }

        }
        return valor;
    }

    public FiltroDeBusca getCampoDeBusca() {
        return campoDeBusca;
    }

    public void setCampoDeBusca(FiltroDeBusca campoDeBusca) {
        this.campoDeBusca = campoDeBusca;
    }

    public void gerarPagamentos() throws IOException, BusinessException {
        pagamentoBO.gerarPagamento(pagamentosNaoGerados);
        pagamentosNaoGerados = pagamentoBO.listarPagamentosPorSituacao(SessaoUtils.getUser(), null, null, null, SituacaoOp.NAOGERADA);
        FacesMessageUtils.info("Arquivo Gerado com Sucesso!");
    }

    public void listPagamentos() {
        campoDeBusca.setUsuario(SessaoUtils.getUser());
        pagamentosPorEmpresa = pagamentoBO.listPagamentos(campoDeBusca);
    }

}
