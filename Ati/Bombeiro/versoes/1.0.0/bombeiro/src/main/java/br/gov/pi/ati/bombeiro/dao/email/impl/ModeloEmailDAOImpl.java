package br.gov.pi.ati.bombeiro.dao.email.impl;

import br.gov.pi.ati.bombeiro.application.BaseDAOImpl;
import br.gov.pi.ati.bombeiro.dao.email.ModeloEmailDAO;
import br.gov.pi.ati.bombeiro.modelo.email.ModeloEmail;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class ModeloEmailDAOImpl extends BaseDAOImpl<ModeloEmail> implements ModeloEmailDAO {

    @Override
    public Class getEntityClass() {
        return ModeloEmail.class;
    }

}
