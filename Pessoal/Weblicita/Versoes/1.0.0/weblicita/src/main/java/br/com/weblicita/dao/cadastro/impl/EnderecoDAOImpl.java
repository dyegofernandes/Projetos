package br.com.weblicita.dao.cadastro.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.cadastro.EnderecoDAO;
import br.com.weblicita.modelo.cadastro.Endereco;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class EnderecoDAOImpl extends BaseDAOImpl<Endereco> implements EnderecoDAO {

    @Override
    public Class getEntityClass() {
        return Endereco.class;
    }

}
