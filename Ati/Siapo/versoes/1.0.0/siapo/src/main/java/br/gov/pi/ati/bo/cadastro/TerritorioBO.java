package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.TerritorioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.Territorio;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class TerritorioBO extends AbstractBusinessObject<Territorio> {

    @EJB
    private TerritorioDAO territorioDAO;
    
    @Override
    public TerritorioDAO getDAO() {
        return territorioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo").add("nome");
    }

    @Override
    public void validate(Territorio territorio) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
