package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.UnidadeDeMedidaDAO;
import br.gov.pi.ati.modelo.cadastro.UnidadeDeMedida;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeDeMedidaDAOImpl extends BaseDAOImpl<UnidadeDeMedida> implements UnidadeDeMedidaDAO {

    @Override
    public Class getEntityClass() {
        return UnidadeDeMedida.class;
    }

}
