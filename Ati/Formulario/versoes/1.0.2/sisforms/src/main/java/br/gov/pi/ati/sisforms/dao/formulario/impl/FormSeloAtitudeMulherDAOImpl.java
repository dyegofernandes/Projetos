package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.FormSeloAtitudeMulherDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.FormSeloAtitudeMulher;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormSeloAtitudeMulherDAOImpl extends BaseDAOImpl<FormSeloAtitudeMulher> implements FormSeloAtitudeMulherDAO {

    @Override
    public Class getEntityClass() {
        return FormSeloAtitudeMulher.class;
    }

}
