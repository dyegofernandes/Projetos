package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.CadastroPessoalDAO;
import br.gov.pi.siste.modelo.cadastro.CadastroPessoal;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CadastroPessoalDAOImpl extends BaseDAOImpl<CadastroPessoal> implements CadastroPessoalDAO {

    @Override
    public Class getEntityClass() {
        return CadastroPessoal.class;
    }

}
