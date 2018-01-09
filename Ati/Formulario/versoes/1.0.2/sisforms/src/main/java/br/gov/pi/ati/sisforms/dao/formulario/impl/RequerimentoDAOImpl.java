package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.RequerimentoDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.Requerimento;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class RequerimentoDAOImpl extends BaseDAOImpl<Requerimento> implements RequerimentoDAO {

    @Override
    public Class getEntityClass() {
        return Requerimento.class;
    }

}
