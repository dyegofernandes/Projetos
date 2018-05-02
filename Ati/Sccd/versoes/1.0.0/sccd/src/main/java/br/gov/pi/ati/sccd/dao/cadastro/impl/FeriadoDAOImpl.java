package br.gov.pi.ati.sccd.dao.cadastro.impl;

import br.gov.pi.ati.sccd.application.BaseDAOImpl;
import br.gov.pi.ati.sccd.dao.cadastro.FeriadoDAO;
import br.gov.pi.ati.sccd.modelo.cadastro.Feriado;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FeriadoDAOImpl extends BaseDAOImpl<Feriado> implements FeriadoDAO {

    @Override
    public Class getEntityClass() {
        return Feriado.class;
    }

}
