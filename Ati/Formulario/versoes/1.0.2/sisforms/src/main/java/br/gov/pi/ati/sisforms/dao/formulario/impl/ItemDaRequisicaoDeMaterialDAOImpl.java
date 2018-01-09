package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.ItemDaRequisicaoDeMaterialDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemDaRequisicaoDeMaterial;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemDaRequisicaoDeMaterialDAOImpl extends BaseDAOImpl<ItemDaRequisicaoDeMaterial> implements ItemDaRequisicaoDeMaterialDAO {

    @Override
    public Class getEntityClass() {
        return ItemDaRequisicaoDeMaterial.class;
    }

}
