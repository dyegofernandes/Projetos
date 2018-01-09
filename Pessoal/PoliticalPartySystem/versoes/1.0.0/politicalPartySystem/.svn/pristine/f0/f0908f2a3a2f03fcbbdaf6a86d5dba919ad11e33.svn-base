package br.com.politicalpartysystem.bo.mensagem;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.mensagem.MessageBoardsDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.mensagem.MessageBoards;

/**
 *
 * @author Juniel
 */
@Stateless
public class MessageBoardsBO extends AbstractBusinessObject<MessageBoards> {

    @EJB
    private MessageBoardsDAO messageBoardsDAO;
    
    @Override
    public MessageBoardsDAO getDAO() {
        return messageBoardsDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(MessageBoards messageBoards) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
