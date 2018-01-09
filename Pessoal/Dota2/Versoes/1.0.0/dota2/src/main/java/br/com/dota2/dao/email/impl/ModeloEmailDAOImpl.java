package br.com.dota2.dao.email.impl;

import br.com.dota2.application.BaseDAOImpl;
import br.com.dota2.dao.email.ModeloEmailDAO;
import br.com.dota2.modelo.email.ModeloEmail;
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
