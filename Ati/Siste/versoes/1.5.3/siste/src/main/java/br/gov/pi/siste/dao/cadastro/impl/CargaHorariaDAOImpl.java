package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.CargaHorariaDAO;
import br.gov.pi.siste.modelo.cadastro.CargaHoraria;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CargaHorariaDAOImpl extends BaseDAOImpl<CargaHoraria> implements CargaHorariaDAO {

    @Override
    public Class getEntityClass() {
        return CargaHoraria.class;
    }

}
