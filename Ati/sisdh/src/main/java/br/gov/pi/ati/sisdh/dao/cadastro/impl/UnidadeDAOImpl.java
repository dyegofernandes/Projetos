package br.gov.pi.ati.sisdh.dao.cadastro.impl;

import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.dao.cadastro.UnidadeDAO;
import br.gov.pi.ati.sisdh.modelo.cadastro.Unidade;
import javax.ejb.Stateless;

/**
 *
 * @author ads01
 */
@Stateless
public class UnidadeDAOImpl extends BaseDAOImpl<Unidade> implements UnidadeDAO {

    @Override
    public Class getEntityClass() {
        return Unidade.class;
    }

}
