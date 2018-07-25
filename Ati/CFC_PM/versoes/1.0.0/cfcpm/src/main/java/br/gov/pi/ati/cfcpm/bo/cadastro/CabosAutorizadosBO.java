package br.gov.pi.ati.cfcpm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.cfcpm.dao.cadastro.CabosAutorizadosDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.cfcpm.modelo.cadastro.CabosAutorizados;

/**
 *
 * @author Juniel
 */
@Stateless
public class CabosAutorizadosBO extends AbstractBusinessObject<CabosAutorizados> {

    @EJB
    private CabosAutorizadosDAO cabosAutorizadosDAO;
    
    @Override
    public CabosAutorizadosDAO getDAO() {
        return cabosAutorizadosDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(CabosAutorizados cabosAutorizados) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public CabosAutorizados cabosPelaMatricula(String matricula){
        return getDAO().unique("matricula", matricula);
    }
}
