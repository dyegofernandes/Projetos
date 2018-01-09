package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.SolicitanteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Solicitante;

/**
 *
 * @author Juniel
 */
@Stateless
public class SolicitanteBO extends AbstractBusinessObject<Solicitante> {

    @EJB
    private SolicitanteDAO solicitanteDAO;
    
    @Override
    public SolicitanteDAO getDAO() {
        return solicitanteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Solicitante solicitante) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
