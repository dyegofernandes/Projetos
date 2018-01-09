package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.TelefoneDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Telefone;

/**
 *
 * @author Juniel
 */
@Stateless
public class TelefoneBO extends AbstractBusinessObject<Telefone> {

    @EJB
    private TelefoneDAO telefoneDAO;
    
    @Override
    public TelefoneDAO getDAO() {
        return telefoneDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Telefone telefone) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
