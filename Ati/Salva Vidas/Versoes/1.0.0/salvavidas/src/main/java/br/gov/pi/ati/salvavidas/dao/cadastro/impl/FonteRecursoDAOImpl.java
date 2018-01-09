package br.gov.pi.ati.salvavidas.dao.cadastro.impl;

import br.gov.pi.ati.salvavidas.application.BaseDAOImpl;
import br.gov.pi.ati.salvavidas.dao.cadastro.FonteRecursoDAO;
import br.gov.pi.ati.salvavidas.modelo.cadastro.FonteRecurso;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FonteRecursoDAOImpl extends BaseDAOImpl<FonteRecurso> implements FonteRecursoDAO {

    @Override
    public Class getEntityClass() {
        return FonteRecurso.class;
    }

}
