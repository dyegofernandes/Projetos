package br.gov.pi.ati.sccd.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.cadastro.FornecedorDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.cadastro.Fornecedor;
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
        return new UniqueFields().add("autoridadeCertificadora");
    }

    @Override
    public void validate(Fornecedor fornecedor) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
