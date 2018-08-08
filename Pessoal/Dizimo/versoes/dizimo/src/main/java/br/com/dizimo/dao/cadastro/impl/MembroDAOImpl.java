package br.com.dizimo.dao.cadastro.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.cadastro.MembroDAO;
import br.com.dizimo.modelo.cadastro.Membro;
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
