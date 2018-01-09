package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.ObjetoApreendidoDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.ObjetoApreendido;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ObjetoApreendidoDAOImpl extends BaseDAOImpl<ObjetoApreendido> implements ObjetoApreendidoDAO {

    @Override
    public Class getEntityClass() {
        return ObjetoApreendido.class;
    }

}
