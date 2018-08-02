package br.com.ejccard.dao.financeiro.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.financeiro.EjcCardDAO;
import br.com.ejccard.modelo.financeiro.EjcCard;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class EjcCardDAOImpl extends BaseDAOImpl<EjcCard> implements EjcCardDAO {

    @Override
    public Class getEntityClass() {
        return EjcCard.class;
    }

}
