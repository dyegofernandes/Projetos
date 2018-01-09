package com.opfacil.bo.cadastro;

import com.opfacil.VOs.EmpresaInforAdicionaisVO;
import com.xpert.core.crud.AbstractBusinessObject;
import com.opfacil.dao.cadastro.EmpresaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.controleacesso.Usuario;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class EmpresaBO extends AbstractBusinessObject<Empresa> {

    @EJB
    private EmpresaDAO empresaDAO;

    @Override
    public EmpresaDAO getDAO() {
        return empresaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cnpj");
    }

    @Override
    public void validate(Empresa empresa) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Empresa> getListEmpresasAutorizadas(Usuario usuario) {
        List<Empresa> empresas;
        if (usuario.isSuperUsuario()) {
            empresas = empresaDAO.listAll("nomefantasia");
        } else {
            Restrictions restrictions = new Restrictions();
            Empresa empresa = empresaDAO.getInitialized(usuario.getEmpresa());
            restrictions.equals("id", empresa.getId());
            empresas = empresaDAO.list(restrictions,"nomefantasia");
        }

        return empresas;
    }

    public EmpresaInforAdicionaisVO getEmpresaInfAdicionais(Integer cdBanco){
        return empresaDAO.listarInformacoesAdicEmpresa(cdBanco);
    }
}
