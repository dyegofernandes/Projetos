package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.MarcaDeArmaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.MarcaDeArma;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class MarcaDeArmaDAOImpl extends BaseDAOImpl<MarcaDeArma> implements MarcaDeArmaDAO {

    @Override
    public Class getEntityClass() {
        return MarcaDeArma.class;
    }

}
