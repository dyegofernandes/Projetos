package br.gov.pi.salvemaria.dao.cadastro.impl;

import br.gov.pi.salvemaria.application.BaseDAOImpl;
import br.gov.pi.salvemaria.dao.cadastro.EnderecoDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Endereco;
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
