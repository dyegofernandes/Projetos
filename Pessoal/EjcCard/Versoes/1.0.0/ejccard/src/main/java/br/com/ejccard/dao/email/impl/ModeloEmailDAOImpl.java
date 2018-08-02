package br.com.ejccard.dao.email.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.email.ModeloEmailDAO;
import br.com.ejccard.modelo.email.ModeloEmail;
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
