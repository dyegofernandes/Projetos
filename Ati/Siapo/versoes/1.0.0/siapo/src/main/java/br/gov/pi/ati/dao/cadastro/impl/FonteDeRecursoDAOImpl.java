package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.FonteDeRecursoDAO;
import br.gov.pi.ati.modelo.cadastro.FonteDeRecurso;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FonteDeRecursoDAOImpl extends BaseDAOImpl<FonteDeRecurso> implements FonteDeRecursoDAO {

    @Override
    public Class getEntityClass() {
        return FonteDeRecurso.class;
    }

}
