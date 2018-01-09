package br.com.politicalpartysystem.dao.mensagem.impl;

import br.com.politicalpartysystem.application.BaseDAOImpl;
import br.com.politicalpartysystem.dao.mensagem.MessageBoardsDAO;
import br.com.politicalpartysystem.modelo.mensagem.MessageBoards;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class MessageBoardsDAOImpl extends BaseDAOImpl<MessageBoards> implements MessageBoardsDAO {

    @Override
    public Class getEntityClass() {
        return MessageBoards.class;
    }

}
