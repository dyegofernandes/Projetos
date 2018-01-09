package br.com.politicalpartysystem.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.cadastro.NeighborhoodDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.cadastro.Neighborhood;

/**
 *
 * @author Juniel
 */
@Stateless
public class NeighborhoodBO extends AbstractBusinessObject<Neighborhood> {

    @EJB
    private NeighborhoodDAO neighborhoodDAO;
    
    @Override
    public NeighborhoodDAO getDAO() {
        return neighborhoodDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Neighborhood neighborhood) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
