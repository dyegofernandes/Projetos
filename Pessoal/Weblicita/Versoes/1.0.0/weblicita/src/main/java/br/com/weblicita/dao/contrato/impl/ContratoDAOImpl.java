package br.com.weblicita.dao.contrato.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.contrato.ContratoDAO;
import br.com.weblicita.modelo.contrato.Contrato;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ContratoDAOImpl extends BaseDAOImpl<Contrato> implements ContratoDAO {

    @Override
    public Class getEntityClass() {
        return Contrato.class;
    }

}
