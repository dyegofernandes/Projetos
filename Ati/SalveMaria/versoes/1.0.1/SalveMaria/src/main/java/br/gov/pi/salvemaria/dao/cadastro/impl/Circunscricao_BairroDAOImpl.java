package br.gov.pi.salvemaria.dao.cadastro.impl;

import br.gov.pi.salvemaria.application.BaseDAOImpl;
import br.gov.pi.salvemaria.dao.cadastro.Circunscricao_BairroDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao_Bairro;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class Circunscricao_BairroDAOImpl extends BaseDAOImpl<Circunscricao_Bairro> implements Circunscricao_BairroDAO {

    @Override
    public Class getEntityClass() {
        return Circunscricao_Bairro.class;
    }

}
