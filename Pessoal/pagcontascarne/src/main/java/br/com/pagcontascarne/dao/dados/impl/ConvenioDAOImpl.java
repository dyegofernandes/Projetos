package br.com.pagcontascarne.dao.dados.impl;

import br.com.pagcontascarne.application.BaseDAOImpl;
import br.com.pagcontascarne.dao.dados.ConvenioDAO;
import br.com.pagcontascarne.modelo.dados.Convenio;
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
