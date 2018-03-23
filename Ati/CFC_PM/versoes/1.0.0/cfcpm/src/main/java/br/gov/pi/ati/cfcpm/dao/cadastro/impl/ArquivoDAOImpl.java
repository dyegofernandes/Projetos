package br.gov.pi.ati.cfcpm.dao.cadastro.impl;

import br.gov.pi.ati.cfcpm.application.BaseDAOImpl;
import br.gov.pi.ati.cfcpm.dao.cadastro.ArquivoDAO;
import br.gov.pi.ati.cfcpm.modelo.cadastro.Arquivo;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ArquivoDAOImpl extends BaseDAOImpl<Arquivo> implements ArquivoDAO {

    @Override
    public Class getEntityClass() {
        return Arquivo.class;
    }

}
