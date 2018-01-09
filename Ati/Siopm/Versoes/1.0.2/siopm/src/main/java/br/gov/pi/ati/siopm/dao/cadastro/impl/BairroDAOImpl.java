package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.BairroDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Bairro;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class BairroDAOImpl extends BaseDAOImpl<Bairro> implements BairroDAO {

    @Override
    public Class getEntityClass() {
        return Bairro.class;
    }

}
