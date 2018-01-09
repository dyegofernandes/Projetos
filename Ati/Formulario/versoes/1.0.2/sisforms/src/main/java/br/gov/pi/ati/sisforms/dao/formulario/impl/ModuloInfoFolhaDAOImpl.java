package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.ModuloInfoFolhaDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloInfoFolha;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ModuloInfoFolhaDAOImpl extends BaseDAOImpl<ModuloInfoFolha> implements ModuloInfoFolhaDAO {

    @Override
    public Class getEntityClass() {
        return ModuloInfoFolha.class;
    }

}
