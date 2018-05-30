package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.ModalidadeDeAplicacaoDAO;
import br.gov.pi.ati.modelo.cadastro.ModalidadeDeAplicacao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ModalidadeDeAplicacaoDAOImpl extends BaseDAOImpl<ModalidadeDeAplicacao> implements ModalidadeDeAplicacaoDAO {

    @Override
    public Class getEntityClass() {
        return ModalidadeDeAplicacao.class;
    }

}
