package br.gov.pi.ati.agendacultural.dao.eventos.impl;

import br.gov.pi.ati.agendacultural.application.BaseDAOImpl;
import br.gov.pi.ati.agendacultural.dao.eventos.CategoriaEventoDAO;
import br.gov.pi.ati.agendacultural.modelo.eventos.CategoriaEvento;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CategoriaEventoDAOImpl extends BaseDAOImpl<CategoriaEvento> implements CategoriaEventoDAO {

    @Override
    public Class getEntityClass() {
        return CategoriaEvento.class;
    }

}
