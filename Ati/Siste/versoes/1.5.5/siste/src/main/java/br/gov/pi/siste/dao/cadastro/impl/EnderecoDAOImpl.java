package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.EnderecoDAO;
import br.gov.pi.siste.modelo.cadastro.Endereco;
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
