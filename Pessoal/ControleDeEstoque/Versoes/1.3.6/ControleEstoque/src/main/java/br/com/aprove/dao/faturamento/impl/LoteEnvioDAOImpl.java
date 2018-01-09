package br.com.aprove.dao.faturamento.impl;

import br.com.aprove.application.BaseDAOImpl;
import br.com.aprove.dao.faturamento.LoteEnvioDAO;
import br.com.aprove.modelo.faturamento.LoteEnvio;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class LoteEnvioDAOImpl extends BaseDAOImpl<LoteEnvio> implements LoteEnvioDAO {

    @Override
    public Class getEntityClass() {
        return LoteEnvio.class;
    }

}
