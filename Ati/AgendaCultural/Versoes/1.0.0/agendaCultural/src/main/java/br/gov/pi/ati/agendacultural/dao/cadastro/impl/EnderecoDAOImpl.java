package br.gov.pi.ati.agendacultural.dao.cadastro.impl;

import br.gov.pi.ati.agendacultural.application.BaseDAOImpl;
import br.gov.pi.ati.agendacultural.dao.cadastro.EnderecoDAO;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Endereco;
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
