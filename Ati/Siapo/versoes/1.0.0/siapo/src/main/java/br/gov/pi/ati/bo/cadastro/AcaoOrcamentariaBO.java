package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.AcaoOrcamentariaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.AcaoOrcamentaria;

/**
 *
 * @author Juniel
 */
@Stateless
public class AcaoOrcamentariaBO extends AbstractBusinessObject<AcaoOrcamentaria> {

    @EJB
    private AcaoOrcamentariaDAO acaoOrcamentariaDAO;
    
    @Override
    public AcaoOrcamentariaDAO getDAO() {
        return acaoOrcamentariaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(AcaoOrcamentaria acaoOrcamentaria) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
