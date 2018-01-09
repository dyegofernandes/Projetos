package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.AtividadeRelatorioViagemDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.AtividadeRelatorioViagem;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AtividadeRelatorioViagemDAOImpl extends BaseDAOImpl<AtividadeRelatorioViagem> implements AtividadeRelatorioViagemDAO {

    @Override
    public Class getEntityClass() {
        return AtividadeRelatorioViagem.class;
    }

}
