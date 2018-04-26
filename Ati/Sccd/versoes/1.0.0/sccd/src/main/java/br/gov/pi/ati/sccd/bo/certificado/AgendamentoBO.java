package br.gov.pi.ati.sccd.bo.certificado;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.certificado.AgendamentoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.certificado.Agendamento;

/**
 *
 * @author Juniel
 */
@Stateless
public class AgendamentoBO extends AbstractBusinessObject<Agendamento> {

    @EJB
    private AgendamentoDAO agendamentoDAO;
    
    @Override
    public AgendamentoDAO getDAO() {
        return agendamentoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Agendamento agendamento) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
