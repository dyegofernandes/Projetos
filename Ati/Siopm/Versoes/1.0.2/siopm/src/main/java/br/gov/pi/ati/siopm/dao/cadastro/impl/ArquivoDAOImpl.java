package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.ArquivoDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Arquivo;
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
