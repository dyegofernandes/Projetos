package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.RgDAO;
import br.gov.pi.siste.modelo.cadastro.Rg;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class RgDAOImpl extends BaseDAOImpl<Rg> implements RgDAO {

    @Override
    public Class getEntityClass() {
        return Rg.class;
    }

}
