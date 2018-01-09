package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.ModeloVeiculoDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.ModeloVeiculo;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ModeloVeiculoDAOImpl extends BaseDAOImpl<ModeloVeiculo> implements ModeloVeiculoDAO {

    @Override
    public Class getEntityClass() {
        return ModeloVeiculo.class;
    }

}
