package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.MarcaVeiculoDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.MarcaVeiculo;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class MarcaVeiculoDAOImpl extends BaseDAOImpl<MarcaVeiculo> implements MarcaVeiculoDAO {

    @Override
    public Class getEntityClass() {
        return MarcaVeiculo.class;
    }

}
