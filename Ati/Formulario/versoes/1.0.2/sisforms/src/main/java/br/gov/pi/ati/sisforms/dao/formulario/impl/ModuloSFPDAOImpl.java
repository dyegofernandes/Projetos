package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.ModuloSFPDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloSFP;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ModuloSFPDAOImpl extends BaseDAOImpl<ModuloSFP> implements ModuloSFPDAO {

    @Override
    public Class getEntityClass() {
        return ModuloSFP.class;
    }

}
