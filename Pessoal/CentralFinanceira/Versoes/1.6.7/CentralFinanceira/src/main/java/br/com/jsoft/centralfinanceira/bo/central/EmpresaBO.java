package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.EmpresaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import com.xpert.core.validation.UniqueFields;

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
        return new UniqueFields().add("nome");
    }

    @Override
    public void validate(Empresa empresa) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
