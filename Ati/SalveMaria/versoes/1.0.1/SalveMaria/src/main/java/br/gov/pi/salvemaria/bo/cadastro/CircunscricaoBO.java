package br.gov.pi.salvemaria.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.cadastro.CircunscricaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao;
import com.xpert.core.validation.UniqueFields;

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