package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.LocalIntermediarioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.LocalIntermediario;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class LocalIntermediarioBO extends AbstractBusinessObject<LocalIntermediario> {

    @EJB
    private LocalIntermediarioDAO localIntermediarioDAO;

    @Override
    public LocalIntermediarioDAO getDAO() {
        return localIntermediarioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields()
                .add("nome");
    }

    @Override
    public void validate(LocalIntermediario localIntermediario) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
