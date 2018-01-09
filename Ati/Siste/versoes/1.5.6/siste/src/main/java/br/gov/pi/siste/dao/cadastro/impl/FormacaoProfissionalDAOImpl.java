package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.FormacaoProfissionalDAO;
import br.gov.pi.siste.modelo.cadastro.FormacaoProfissional;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormacaoProfissionalDAOImpl extends BaseDAOImpl<FormacaoProfissional> implements FormacaoProfissionalDAO {

    @Override
    public Class getEntityClass() {
        return FormacaoProfissional.class;
    }

}
