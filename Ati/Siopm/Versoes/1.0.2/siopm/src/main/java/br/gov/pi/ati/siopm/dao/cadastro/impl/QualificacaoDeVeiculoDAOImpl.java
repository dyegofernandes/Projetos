package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.QualificacaoDeVeiculoDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.QualificacaoDeVeiculo;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class QualificacaoDeVeiculoDAOImpl extends BaseDAOImpl<QualificacaoDeVeiculo> implements QualificacaoDeVeiculoDAO {

    @Override
    public Class getEntityClass() {
        return QualificacaoDeVeiculo.class;
    }

}
