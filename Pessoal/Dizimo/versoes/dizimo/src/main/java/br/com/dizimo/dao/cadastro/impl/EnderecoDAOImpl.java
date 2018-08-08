package br.com.dizimo.dao.cadastro.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.cadastro.EnderecoDAO;
import br.com.dizimo.modelo.cadastro.Endereco;
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
