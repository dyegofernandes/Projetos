package br.gov.pi.salvemaria.dao.cadastro.impl;

import br.gov.pi.salvemaria.application.BaseDAOImpl;
import br.gov.pi.salvemaria.dao.cadastro.CidadeDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CidadeDAOImpl extends BaseDAOImpl<Cidade> implements CidadeDAO {

    @Override
    public Class getEntityClass() {
        return Cidade.class;
    }

}
