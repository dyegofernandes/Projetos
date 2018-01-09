package br.gov.pi.ati.adapi.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.adapi.dao.cadastro.EspecieDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.adapi.modelo.cadastro.Especie;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class EspecieBO extends AbstractBusinessObject<Especie> {

    @EJB
    private EspecieDAO especieDAO;
    
    @Override
    public EspecieDAO getDAO() {
        return especieDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome");
    }

    @Override
    public void validate(Especie especie) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
