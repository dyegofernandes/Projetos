package br.com.politicalpartysystem.bo.mensagem;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.mensagem.MessengerDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.mensagem.Messenger;

/**
 *
 * @author Juniel
 */
@Stateless
public class MessengerBO extends AbstractBusinessObject<Messenger> {

    @EJB
    private MessengerDAO messengerDAO;
    
    @Override
    public MessengerDAO getDAO() {
        return messengerDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Messenger messenger) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
