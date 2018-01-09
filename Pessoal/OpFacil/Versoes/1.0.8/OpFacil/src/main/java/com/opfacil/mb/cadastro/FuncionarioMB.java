package com.opfacil.mb.cadastro;

import com.opfacil.VOs.FiltroDeBusca;
import com.opfacil.bo.cadastro.EmpresaBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.opfacil.bo.cadastro.FuncionarioBO;
import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.cadastro.Funcionario;
import com.opfacil.modelo.enums.Ativo;
import com.opfacil.util.SessaoUtils;
import java.util.List;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class FuncionarioMB extends AbstractBaseBean<Funcionario> implements Serializable {

    private List<Empresa> empresas;

    private List<Funcionario> funcioriosPorEmpresa;
    private List<Funcionario> funcioriosPorEmpresaFiltrados;

    private FiltroDeBusca campoDeBusca;

    @EJB
    private FuncionarioBO funcionarioBO;

    @EJB
    private EmpresaBO empresaBO;

    private Ativo ativo;

    @Override
    public FuncionarioBO getBO() {
        return funcionarioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        campoDeBusca = new FiltroDeBusca();
        empresas = empresaBO.getListEmpresasAutorizadas(SessaoUtils.getUser());
        funcioriosPorEmpresa = funcionarioBO.buscarFuncionarios(campoDeBusca);
    }

    @Override
    public void postSave() {
        setEntity(new Funcionario());
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public List<Funcionario> getFuncioriosPorEmpresa() {
        return funcioriosPorEmpresa;
    }

    public void setFuncioriosPorEmpresa(List<Funcionario> funcioriosPorEmpresa) {
        this.funcioriosPorEmpresa = funcioriosPorEmpresa;
    }

    public List<Funcionario> getFuncioriosPorEmpresaFiltrados() {
        return funcioriosPorEmpresaFiltrados;
    }

    public void setFuncioriosPorEmpresaFiltrados(List<Funcionario> funcioriosPorEmpresaFiltrados) {
        this.funcioriosPorEmpresaFiltrados = funcioriosPorEmpresaFiltrados;
    }

    public FiltroDeBusca getCampoDeBusca() {
        return campoDeBusca;
    }

    public void setCampoDeBusca(FiltroDeBusca campoDeBusca) {
        this.campoDeBusca = campoDeBusca;
    }

    public void buscar() {
        if (ativo == Ativo.SIM) {
            campoDeBusca.setAtivo(true);
        } else {
            if (ativo == Ativo.NAO) {
                campoDeBusca.setAtivo(false);
            }
        }
        funcioriosPorEmpresa = funcionarioBO.buscarFuncionarios(campoDeBusca);
    }

    @Override
    public void delete() {
        super.delete();
        funcioriosPorEmpresa = funcionarioBO.buscarFuncionarios(campoDeBusca);
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

}
