package br.gov.pi.ati.sisforms.dao.cadastro.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.cadastro.TermoDAO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Termo;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class TermoDAOImpl extends BaseDAOImpl<Termo> implements TermoDAO {

    @Override
    public Class getEntityClass() {
        return Termo.class;
    }

}
