package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.RelatorioDeViagemDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.RelatorioDeViagem;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class RelatorioDeViagemDAOImpl extends BaseDAOImpl<RelatorioDeViagem> implements RelatorioDeViagemDAO {

    @Override
    public Class getEntityClass() {
        return RelatorioDeViagem.class;
    }

}
