package br.gov.pi.ati.sisdh.dao.cadastro.impl;

import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.dao.cadastro.BairroDAO;
import br.gov.pi.ati.sisdh.modelo.cadastro.Bairro;
import javax.ejb.Stateless;

/**
 *
 * @author ads01
 */
@Stateless
public class BairroDAOImpl extends BaseDAOImpl<Bairro> implements BairroDAO {

    @Override
    public Class getEntityClass() {
        return Bairro.class;
    }

}
