package br.com.politicalpartysystem.dao.mensagem;

import com.xpert.persistence.dao.BaseDAO;
import br.com.politicalpartysystem.modelo.mensagem.MessageBoards;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface MessageBoardsDAO extends BaseDAO<MessageBoards> {
    
}
