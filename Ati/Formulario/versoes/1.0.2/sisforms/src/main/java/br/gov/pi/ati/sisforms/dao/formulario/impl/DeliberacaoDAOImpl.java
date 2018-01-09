package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.DeliberacaoDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.Deliberacao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class DeliberacaoDAOImpl extends BaseDAOImpl<Deliberacao> implements DeliberacaoDAO {

    @Override
    public Class getEntityClass() {
        return Deliberacao.class;
    }

}
