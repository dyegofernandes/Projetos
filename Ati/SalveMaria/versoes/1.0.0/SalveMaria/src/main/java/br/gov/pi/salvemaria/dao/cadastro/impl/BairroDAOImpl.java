package br.gov.pi.salvemaria.dao.cadastro.impl;

import br.gov.pi.salvemaria.application.BaseDAOImpl;
import br.gov.pi.salvemaria.dao.cadastro.BairroDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class BairroDAOImpl extends BaseDAOImpl<Bairro> implements BairroDAO {

    @Override
    public Class getEntityClass() {
        return Bairro.class;
    }

}
