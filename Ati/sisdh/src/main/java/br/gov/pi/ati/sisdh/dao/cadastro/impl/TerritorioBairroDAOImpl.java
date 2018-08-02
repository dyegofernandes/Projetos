package br.gov.pi.ati.sisdh.dao.cadastro.impl;

import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.dao.cadastro.TerritorioBairroDAO;
import br.gov.pi.ati.sisdh.modelo.cadastro.TerritorioBairro;
import javax.ejb.Stateless;

/**
 *
 * @author ads01
 */
@Stateless
public class TerritorioBairroDAOImpl extends BaseDAOImpl<TerritorioBairro> implements TerritorioBairroDAO {

    @Override
    public Class getEntityClass() {
        return TerritorioBairro.class;
    }

}
