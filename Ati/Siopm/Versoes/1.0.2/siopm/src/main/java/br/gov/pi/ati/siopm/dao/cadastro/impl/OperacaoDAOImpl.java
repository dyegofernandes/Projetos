package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.OperacaoDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Operacao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class OperacaoDAOImpl extends BaseDAOImpl<Operacao> implements OperacaoDAO {

    @Override
    public Class getEntityClass() {
        return Operacao.class;
    }

}
