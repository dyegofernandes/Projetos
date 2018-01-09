package br.gov.pi.salvemaria.dao.cadastro.impl;

import br.gov.pi.salvemaria.application.BaseDAOImpl;
import br.gov.pi.salvemaria.dao.cadastro.ViaturaDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Viatura;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ViaturaDAOImpl extends BaseDAOImpl<Viatura> implements ViaturaDAO {

    @Override
    public Class getEntityClass() {
        return Viatura.class;
    }

}
