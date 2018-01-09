package br.com.politicalpartysystem.bo.mensagem;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.mensagem.MailBoxDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.mensagem.MailBox;

/**
 *
 * @author Juniel
 */
@Stateless
public class MailBoxBO extends AbstractBusinessObject<MailBox> {

    @EJB
    private MailBoxDAO mailBoxDAO;
    
    @Override
    public MailBoxDAO getDAO() {
        return mailBoxDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(MailBox mailBox) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
