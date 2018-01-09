package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.CircunscricaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Circunscricao;

/**
 *
 * @author Juniel
 */
@Stateless
public class CircunscricaoBO extends AbstractBusinessObject<Circunscricao> {

    @EJB
    private CircunscricaoDAO circunscricaoDAO;

    @Override
    public CircunscricaoDAO getDAO() {
        return circunscricaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Circunscricao circunscricao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    

}
