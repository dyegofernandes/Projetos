package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.GuarnicaoViaturaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.GuarnicaoViatura;

/**
 *
 * @author Juniel
 */
@Stateless
public class GuarnicaoViaturaBO extends AbstractBusinessObject<GuarnicaoViatura> {

    @EJB
    private GuarnicaoViaturaDAO componenteViaturaDAO;
    
    @Override
    public GuarnicaoViaturaDAO getDAO() {
        return componenteViaturaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(GuarnicaoViatura componenteViatura) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
