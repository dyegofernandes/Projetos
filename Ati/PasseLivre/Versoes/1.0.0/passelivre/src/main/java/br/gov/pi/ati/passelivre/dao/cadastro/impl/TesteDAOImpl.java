package br.gov.pi.ati.passelivre.dao.cadastro.impl;

import br.gov.pi.ati.passelivre.application.BaseDAOImpl;
import br.gov.pi.ati.passelivre.dao.cadastro.TesteDAO;
import br.gov.pi.ati.passelivre.modelo.cadastro.Teste;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class TesteDAOImpl extends BaseDAOImpl<Teste> implements TesteDAO {

    @Override
    public Class getEntityClass() {
        return Teste.class;
    }

}
