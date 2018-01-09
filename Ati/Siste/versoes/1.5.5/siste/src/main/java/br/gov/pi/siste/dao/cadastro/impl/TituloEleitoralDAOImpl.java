package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.TituloEleitoralDAO;
import br.gov.pi.siste.modelo.cadastro.TituloEleitoral;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class TituloEleitoralDAOImpl extends BaseDAOImpl<TituloEleitoral> implements TituloEleitoralDAO {

    @Override
    public Class getEntityClass() {
        return TituloEleitoral.class;
    }

}
