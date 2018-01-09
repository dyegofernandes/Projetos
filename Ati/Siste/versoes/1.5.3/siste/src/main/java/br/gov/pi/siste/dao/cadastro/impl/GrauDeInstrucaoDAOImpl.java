package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.GrauDeInstrucaoDAO;
import br.gov.pi.siste.modelo.cadastro.GrauDeInstrucao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class GrauDeInstrucaoDAOImpl extends BaseDAOImpl<GrauDeInstrucao> implements GrauDeInstrucaoDAO {

    @Override
    public Class getEntityClass() {
        return GrauDeInstrucao.class;
    }

}
