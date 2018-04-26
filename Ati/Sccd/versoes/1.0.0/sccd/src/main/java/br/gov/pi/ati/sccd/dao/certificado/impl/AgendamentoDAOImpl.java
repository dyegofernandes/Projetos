package br.gov.pi.ati.sccd.dao.certificado.impl;

import br.gov.pi.ati.sccd.application.BaseDAOImpl;
import br.gov.pi.ati.sccd.dao.certificado.AgendamentoDAO;
import br.gov.pi.ati.sccd.modelo.certificado.Agendamento;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AgendamentoDAOImpl extends BaseDAOImpl<Agendamento> implements AgendamentoDAO {

    @Override
    public Class getEntityClass() {
        return Agendamento.class;
    }

}
