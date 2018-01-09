package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.FormRegistroDominioDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.FormRegistroDominio;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormRegistroDominioDAOImpl extends BaseDAOImpl<FormRegistroDominio> implements FormRegistroDominioDAO {

    @Override
    public Class getEntityClass() {
        return FormRegistroDominio.class;
    }

}
