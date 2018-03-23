package br.gov.pi.ati.cfcpm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.cfcpm.dao.cadastro.ArquivoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.cfcpm.modelo.cadastro.Arquivo;

/**
 *
 * @author Juniel
 */
@Stateless
public class ArquivoBO extends AbstractBusinessObject<Arquivo> {

    @EJB
    private ArquivoDAO arquivoDAO;
    
    @Override
    public ArquivoDAO getDAO() {
        return arquivoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Arquivo arquivo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
