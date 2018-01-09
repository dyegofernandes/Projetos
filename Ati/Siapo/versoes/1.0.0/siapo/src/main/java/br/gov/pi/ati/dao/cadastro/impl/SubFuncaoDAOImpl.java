package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.SubFuncaoDAO;
import br.gov.pi.ati.modelo.cadastro.SubFuncao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class SubFuncaoDAOImpl extends BaseDAOImpl<SubFuncao> implements SubFuncaoDAO {

    @Override
    public Class getEntityClass() {
        return SubFuncao.class;
    }

}
