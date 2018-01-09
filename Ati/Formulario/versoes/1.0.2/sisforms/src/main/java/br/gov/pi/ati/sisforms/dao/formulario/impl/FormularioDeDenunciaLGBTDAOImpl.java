package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.FormularioDeDenunciaLGBTDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.FormularioDeDenunciaLGBT;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormularioDeDenunciaLGBTDAOImpl extends BaseDAOImpl<FormularioDeDenunciaLGBT> implements FormularioDeDenunciaLGBTDAO {

    @Override
    public Class getEntityClass() {
        return FormularioDeDenunciaLGBT.class;
    }

}
