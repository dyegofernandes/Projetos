package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.PessoaEnvolvidaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.PessoaEnvolvida;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PessoaEnvolvidaDAOImpl extends BaseDAOImpl<PessoaEnvolvida> implements PessoaEnvolvidaDAO {

    @Override
    public Class getEntityClass() {
        return PessoaEnvolvida.class;
    }

}
