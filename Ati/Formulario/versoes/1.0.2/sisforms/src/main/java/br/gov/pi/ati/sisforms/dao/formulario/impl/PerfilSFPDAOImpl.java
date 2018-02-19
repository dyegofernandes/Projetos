package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.PerfilSFPDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.PerfilSFP;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PerfilSFPDAOImpl extends BaseDAOImpl<PerfilSFP> implements PerfilSFPDAO {

    @Override
    public Class getEntityClass() {
        return PerfilSFP.class;
    }

}
