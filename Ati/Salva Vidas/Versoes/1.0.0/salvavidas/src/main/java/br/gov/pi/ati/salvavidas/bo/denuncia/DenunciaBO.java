package br.gov.pi.ati.salvavidas.bo.denuncia;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.salvavidas.dao.denuncia.DenunciaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.salvavidas.modelo.denuncia.Denuncia;

/**
 *
 * @author Juniel
 */
@Stateless
public class DenunciaBO extends AbstractBusinessObject<Denuncia> {

    @EJB
    private DenunciaDAO denunciaDAO;
    
    @Override
    public DenunciaDAO getDAO() {
        return denunciaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Denuncia denuncia) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
