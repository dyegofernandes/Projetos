package br.com.facilpagar.dao.email.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.email.ModeloEmailDAO;
import br.com.facilpagar.modelo.email.ModeloEmail;
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
