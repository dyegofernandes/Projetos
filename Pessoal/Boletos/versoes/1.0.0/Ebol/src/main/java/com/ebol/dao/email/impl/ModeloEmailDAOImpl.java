package com.ebol.dao.email.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.email.ModeloEmailDAO;
import com.ebol.modelo.email.ModeloEmail;
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
