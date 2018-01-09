package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.ParticipanteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.Participante;

/**
 *
 * @author Juniel
 */
@Stateless
public class ParticipanteBO extends AbstractBusinessObject<Participante> {

    @EJB
    private ParticipanteDAO participanteDAO;
    
    @Override
    public ParticipanteDAO getDAO() {
        return participanteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Participante participante) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
