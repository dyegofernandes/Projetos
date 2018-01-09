package br.gov.pi.ati.adapi.bo.notificacao;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.adapi.dao.notificacao.NotificacaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.adapi.modelo.notificacao.Notificacao;

/**
 *
 * @author Juniel
 */
@Stateless
public class NotificacaoBO extends AbstractBusinessObject<Notificacao> {

    @EJB
    private NotificacaoDAO notificacaoDAO;
    
    @Override
    public NotificacaoDAO getDAO() {
        return notificacaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Notificacao notificacao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
