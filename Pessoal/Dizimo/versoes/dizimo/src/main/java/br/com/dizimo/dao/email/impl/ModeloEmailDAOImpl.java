package br.com.dizimo.dao.email.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.email.ModeloEmailDAO;
import br.com.dizimo.modelo.email.ModeloEmail;
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
