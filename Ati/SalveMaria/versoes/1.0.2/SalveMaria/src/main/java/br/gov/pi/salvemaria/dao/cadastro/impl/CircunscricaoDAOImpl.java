package br.gov.pi.salvemaria.dao.cadastro.impl;

import br.gov.pi.salvemaria.application.BaseDAOImpl;
import br.gov.pi.salvemaria.dao.cadastro.CircunscricaoDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao;
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
