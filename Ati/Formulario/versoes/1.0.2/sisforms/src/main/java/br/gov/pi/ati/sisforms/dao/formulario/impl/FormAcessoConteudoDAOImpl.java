package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.FormAcessoConteudoDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.FormAcessoConteudo;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormAcessoConteudoDAOImpl extends BaseDAOImpl<FormAcessoConteudo> implements FormAcessoConteudoDAO {

    @Override
    public Class getEntityClass() {
        return FormAcessoConteudo.class;
    }

}
