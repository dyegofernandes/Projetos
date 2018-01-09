package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.ItemViaturaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.ItemViatura;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemViaturaDAOImpl extends BaseDAOImpl<ItemViatura> implements ItemViaturaDAO {

    @Override
    public Class getEntityClass() {
        return ItemViatura.class;
    }

}
