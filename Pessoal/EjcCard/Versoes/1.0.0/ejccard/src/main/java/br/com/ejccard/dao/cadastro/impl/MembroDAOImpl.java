package br.com.ejccard.dao.cadastro.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.cadastro.MembroDAO;
import br.com.ejccard.modelo.cadastro.Membro;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class MembroDAOImpl extends BaseDAOImpl<Membro> implements MembroDAO {

    @Override
    public Class getEntityClass() {
        return Membro.class;
    }

}
