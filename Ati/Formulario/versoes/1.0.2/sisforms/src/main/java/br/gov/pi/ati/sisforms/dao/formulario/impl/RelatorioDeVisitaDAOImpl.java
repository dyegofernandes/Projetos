package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.RelatorioDeVisitaDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.RelatorioDeVisita;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class RelatorioDeVisitaDAOImpl extends BaseDAOImpl<RelatorioDeVisita> implements RelatorioDeVisitaDAO {

    @Override
    public Class getEntityClass() {
        return RelatorioDeVisita.class;
    }

}
