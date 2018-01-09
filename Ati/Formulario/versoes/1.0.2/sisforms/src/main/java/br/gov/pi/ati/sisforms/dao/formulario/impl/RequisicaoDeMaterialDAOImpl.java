package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.RequisicaoDeMaterialDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.RequisicaoDeMaterial;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class RequisicaoDeMaterialDAOImpl extends BaseDAOImpl<RequisicaoDeMaterial> implements RequisicaoDeMaterialDAO {

    @Override
    public Class getEntityClass() {
        return RequisicaoDeMaterial.class;
    }

}
