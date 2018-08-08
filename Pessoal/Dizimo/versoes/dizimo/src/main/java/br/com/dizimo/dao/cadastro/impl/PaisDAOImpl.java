package br.com.dizimo.dao.cadastro.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.cadastro.PaisDAO;
import br.com.dizimo.modelo.cadastro.Pais;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PaisDAOImpl extends BaseDAOImpl<Pais> implements PaisDAO {

    @Override
    public Class getEntityClass() {
        return Pais.class;
    }

}
