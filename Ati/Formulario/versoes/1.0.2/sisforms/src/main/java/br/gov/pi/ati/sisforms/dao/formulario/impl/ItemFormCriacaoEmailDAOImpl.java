package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.ItemFormCriacaoEmailDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemFormCriacaoEmail;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemFormCriacaoEmailDAOImpl extends BaseDAOImpl<ItemFormCriacaoEmail> implements ItemFormCriacaoEmailDAO {

    @Override
    public Class getEntityClass() {
        return ItemFormCriacaoEmail.class;
    }

}
