package br.com.aprove.bo.faturamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.aprove.dao.faturamento.LoteEnvioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.aprove.modelo.faturamento.LoteEnvio;

/**
 *
 * @author Juniel
 */
@Stateless
public class LoteEnvioBO extends AbstractBusinessObject<LoteEnvio> {

    @EJB
    private LoteEnvioDAO loteEnvioDAO;
    
    @Override
    public LoteEnvioDAO getDAO() {
        return loteEnvioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(LoteEnvio loteEnvio) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
