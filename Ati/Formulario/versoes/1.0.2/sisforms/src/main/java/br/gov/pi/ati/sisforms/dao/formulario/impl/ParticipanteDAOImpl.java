package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.ParticipanteDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.Participante;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ParticipanteDAOImpl extends BaseDAOImpl<Participante> implements ParticipanteDAO {

    @Override
    public Class getEntityClass() {
        return Participante.class;
    }

}
