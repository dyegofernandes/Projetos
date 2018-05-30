package br.gov.pi.ati.dao.email.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.email.ModeloEmailDAO;
import br.gov.pi.ati.modelo.email.ModeloEmail;
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
