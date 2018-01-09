package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.ParametroSistemaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.ParametroSistema;

/**
 *
 * @author Juniel
 */
@Stateless
public class ParametroSistemaBO extends AbstractBusinessObject<ParametroSistema> {

    @EJB
    private ParametroSistemaDAO parametroSistemaDAO;
    
    @Override
    public ParametroSistemaDAO getDAO() {
        return parametroSistemaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ParametroSistema parametroSistema) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
