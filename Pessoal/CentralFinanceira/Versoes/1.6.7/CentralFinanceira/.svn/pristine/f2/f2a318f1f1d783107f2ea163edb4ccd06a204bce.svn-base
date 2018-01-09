package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.FornecedorDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Fornecedor;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class FornecedorBO extends AbstractBusinessObject<Fornecedor> {

    @EJB
    private FornecedorDAO fornecedorDAO;
    
    @Override
    public FornecedorDAO getDAO() {
        return fornecedorDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa","nome");
    }

    @Override
    public void validate(Fornecedor fornecedor) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
