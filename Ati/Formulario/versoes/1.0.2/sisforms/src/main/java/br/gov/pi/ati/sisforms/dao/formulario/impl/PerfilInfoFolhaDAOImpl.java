package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.PerfilInfoFolhaDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.PerfilInfoFolha;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PerfilInfoFolhaDAOImpl extends BaseDAOImpl<PerfilInfoFolha> implements PerfilInfoFolhaDAO {

    @Override
    public Class getEntityClass() {
        return PerfilInfoFolha.class;
    }

}
