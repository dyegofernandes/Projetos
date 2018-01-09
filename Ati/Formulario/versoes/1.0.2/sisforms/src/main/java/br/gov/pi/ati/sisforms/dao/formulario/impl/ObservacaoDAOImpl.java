package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.ObservacaoDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.Observacao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ObservacaoDAOImpl extends BaseDAOImpl<Observacao> implements ObservacaoDAO {

    @Override
    public Class getEntityClass() {
        return Observacao.class;
    }

}
