package br.gov.pi.ati.salvavidas.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.salvavidas.dao.cadastro.PoligonoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.salvavidas.modelo.cadastro.Poligono;

/**
 *
 * @author Juniel
 */
@Stateless
public class PoligonoBO extends AbstractBusinessObject<Poligono> {

    @EJB
    private PoligonoDAO poligonoDAO;
    
    @Override
    public PoligonoDAO getDAO() {
        return poligonoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Poligono poligono) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
