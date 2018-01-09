package com.opfacil.bo.cadastro;

import com.opfacil.VOs.FiltroDeBusca;
import com.xpert.core.crud.AbstractBusinessObject;
import com.opfacil.dao.cadastro.FuncionarioDAO;
import com.opfacil.modelo.cadastro.Empresa;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.opfacil.modelo.cadastro.Funcionario;
import com.opfacil.modelo.controleacesso.Usuario;
import com.opfacil.util.SessaoUtils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class FuncionarioBO extends AbstractBusinessObject<Funcionario> {

    @EJB
    private FuncionarioDAO funcionarioDAO;

    @Override
    public FuncionarioDAO getDAO() {
        return funcionarioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa", "cpf");
    }

    @Override
    public void validate(Funcionario funcionario) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Funcionario> getFuncionariosAutorizados(Usuario usuario) {

        List<Funcionario> funcionarios;

        Restrictions restrictions = new Restrictions();
        Empresa empresa = funcionarioDAO.getInitialized(usuario.getEmpresa());
        restrictions.equals("empresa_id", empresa.getId());
        restrictions.equals("ativo", true);
        funcionarios = funcionarioDAO.list(restrictions);

        return funcionarios;
    }

    public List<Funcionario> buscarFuncionarios(FiltroDeBusca filtros) {
        List<Funcionario> funcionarios;

        Restrictions restrictions = new Restrictions();

        if (SessaoUtils.getUser().isSuperUsuario()) {
            if (filtros.getEmpresa() != null) {
                restrictions.add("empresa", filtros.getEmpresa());
            }
        } else {
            if (filtros.getEmpresa() != null) {
                restrictions.add("empresa", filtros.getEmpresa());
            } else {
                restrictions.add("empresa", SessaoUtils.getUser().getEmpresa());
            }
        }

        if (filtros.getNome() != null && !filtros.getNome().equals("")) {
            restrictions.like("nome", filtros.getNome());
        }

        if (filtros.getCpf() != null && !filtros.getCpf().equals("")) {
            restrictions.equals("cpf", filtros.getCpf());
        }

        if (filtros.getFuncao() != null && !filtros.getFuncao().equals("")) {
            restrictions.like("funcao", filtros.getFuncao());
        }

        if (filtros.getRg() != null && !filtros.getRg().equals("")) {
            restrictions.equals("rg", filtros.getRg());
        }

        if (filtros.getAtivo() != null) {
            restrictions.add("ativo", filtros.getAtivo());
        }

        funcionarios = funcionarioDAO.list(restrictions, "nome");

        return funcionarios;
    }

}
