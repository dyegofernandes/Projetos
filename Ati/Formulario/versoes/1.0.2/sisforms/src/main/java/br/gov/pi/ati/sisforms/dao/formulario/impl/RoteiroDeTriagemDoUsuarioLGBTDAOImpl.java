package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.RoteiroDeTriagemDoUsuarioLGBTDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.RoteiroDeTriagemDoUsuarioLGBT;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class RoteiroDeTriagemDoUsuarioLGBTDAOImpl extends BaseDAOImpl<RoteiroDeTriagemDoUsuarioLGBT> implements RoteiroDeTriagemDoUsuarioLGBTDAO {

    @Override
    public Class getEntityClass() {
        return RoteiroDeTriagemDoUsuarioLGBT.class;
    }

}
