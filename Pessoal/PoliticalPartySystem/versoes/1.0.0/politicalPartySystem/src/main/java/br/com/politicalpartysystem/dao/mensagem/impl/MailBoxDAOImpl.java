package br.com.politicalpartysystem.dao.mensagem.impl;

import br.com.politicalpartysystem.application.BaseDAOImpl;
import br.com.politicalpartysystem.dao.mensagem.MailBoxDAO;
import br.com.politicalpartysystem.modelo.mensagem.MailBox;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class MailBoxDAOImpl extends BaseDAOImpl<MailBox> implements MailBoxDAO {

    @Override
    public Class getEntityClass() {
        return MailBox.class;
    }

}
