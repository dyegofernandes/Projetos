package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.CircunscricaoDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Circunscricao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CircunscricaoDAOImpl extends BaseDAOImpl<Circunscricao> implements CircunscricaoDAO {

    @Override
    public Class getEntityClass() {
        return Circunscricao.class;
    }

}
