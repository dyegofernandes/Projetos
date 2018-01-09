package br.gov.pi.salvemaria.dao.cadastro.impl;

import br.gov.pi.salvemaria.application.BaseDAOImpl;
import br.gov.pi.salvemaria.dao.cadastro.CidadeRegiaoDAO;
import br.gov.pi.salvemaria.modelo.cadastro.CidadeRegiao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CidadeRegiaoDAOImpl extends BaseDAOImpl<CidadeRegiao> implements CidadeRegiaoDAO {

    @Override
    public Class getEntityClass() {
        return CidadeRegiao.class;
    }

}
