package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.FormCriacaoEmailDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.FormCriacaoEmail;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormCriacaoEmailDAOImpl extends BaseDAOImpl<FormCriacaoEmail> implements FormCriacaoEmailDAO {

    @Override
    public Class getEntityClass() {
        return FormCriacaoEmail.class;
    }

}
