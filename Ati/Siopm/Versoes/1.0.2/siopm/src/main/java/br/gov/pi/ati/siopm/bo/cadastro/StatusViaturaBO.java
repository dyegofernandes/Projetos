package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.StatusViaturaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.StatusViatura;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class StatusViaturaBO extends AbstractBusinessObject<StatusViatura> {

    @EJB
    private StatusViaturaDAO statusViaturaDAO;

    @Override
    public StatusViaturaDAO getDAO() {
        return statusViaturaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo");
    }

    @Override
    public void validate(StatusViatura statusViatura) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
