package br.gov.pi.ati.salvavidas.dao.cadastro.impl;

import br.gov.pi.ati.salvavidas.application.BaseDAOImpl;
import br.gov.pi.ati.salvavidas.dao.cadastro.PoligonoDAO;
import br.gov.pi.ati.salvavidas.modelo.cadastro.Poligono;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PoligonoDAOImpl extends BaseDAOImpl<Poligono> implements PoligonoDAO {

    @Override
    public Class getEntityClass() {
        return Poligono.class;
    }

}
