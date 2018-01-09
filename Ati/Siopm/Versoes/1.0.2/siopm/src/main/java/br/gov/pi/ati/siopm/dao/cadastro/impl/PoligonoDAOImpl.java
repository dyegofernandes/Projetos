package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.PoligonoDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Poligono;
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
