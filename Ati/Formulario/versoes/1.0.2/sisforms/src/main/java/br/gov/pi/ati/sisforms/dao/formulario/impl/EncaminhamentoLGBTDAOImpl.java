package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.EncaminhamentoLGBTDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.EncaminhamentoLGBT;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class EncaminhamentoLGBTDAOImpl extends BaseDAOImpl<EncaminhamentoLGBT> implements EncaminhamentoLGBTDAO {

    @Override
    public Class getEntityClass() {
        return EncaminhamentoLGBT.class;
    }

}
