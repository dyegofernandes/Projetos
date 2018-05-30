package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.FuncaoDAO;
import br.gov.pi.ati.modelo.cadastro.Funcao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FuncaoDAOImpl extends BaseDAOImpl<Funcao> implements FuncaoDAO {

    @Override
    public Class getEntityClass() {
        return Funcao.class;
    }

}
