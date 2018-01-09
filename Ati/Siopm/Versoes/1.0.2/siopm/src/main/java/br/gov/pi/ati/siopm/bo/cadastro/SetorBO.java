package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.SetorDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Setor;

/**
 *
 * @author Juniel
 */
@Stateless
public class SetorBO extends AbstractBusinessObject<Setor> {

    @EJB
    private SetorDAO setorDAO;
    
    @Override
    public SetorDAO getDAO() {
        return setorDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Setor setor) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
