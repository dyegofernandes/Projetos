package com.opfacil.dao.email.impl;

import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.email.ModeloEmailDAO;
import com.opfacil.modelo.email.ModeloEmail;
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
