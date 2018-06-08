package br.com.facilpagar.dao.dados.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.dados.ConvenioDAO;
import br.com.facilpagar.modelo.dados.Convenio;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ConvenioDAOImpl extends BaseDAOImpl<Convenio> implements ConvenioDAO {

    @Override
    public Class getEntityClass() {
        return Convenio.class;
    }

}
