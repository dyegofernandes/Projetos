package br.gov.pi.ati.cfcpm.dao.cadastro.impl;

import br.gov.pi.ati.cfcpm.application.BaseDAOImpl;
import br.gov.pi.ati.cfcpm.dao.cadastro.CabosAutorizadosDAO;
import br.gov.pi.ati.cfcpm.modelo.cadastro.CabosAutorizados;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CabosAutorizadosDAOImpl extends BaseDAOImpl<CabosAutorizados> implements CabosAutorizadosDAO {

    @Override
    public Class getEntityClass() {
        return CabosAutorizados.class;
    }

}
