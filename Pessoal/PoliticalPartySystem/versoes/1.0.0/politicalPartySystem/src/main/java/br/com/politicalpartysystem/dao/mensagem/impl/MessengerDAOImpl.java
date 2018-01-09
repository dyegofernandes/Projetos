package br.com.politicalpartysystem.dao.mensagem.impl;

import br.com.politicalpartysystem.application.BaseDAOImpl;
import br.com.politicalpartysystem.dao.mensagem.MessengerDAO;
import br.com.politicalpartysystem.modelo.mensagem.Messenger;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class MessengerDAOImpl extends BaseDAOImpl<Messenger> implements MessengerDAO {

    @Override
    public Class getEntityClass() {
        return Messenger.class;
    }

}
