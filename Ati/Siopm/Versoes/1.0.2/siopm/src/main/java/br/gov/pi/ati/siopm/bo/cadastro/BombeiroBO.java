package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.BombeiroDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Bombeiro;

/**
 *
 * @author Juniel
 */
@Stateless
public class BombeiroBO extends AbstractBusinessObject<Bombeiro> {

    @EJB
    private BombeiroDAO bombeiroDAO;
    
    @Override
    public BombeiroDAO getDAO() {
        return bombeiroDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Bombeiro bombeiro) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
