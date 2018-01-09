package geradorne.geradorne.dao.email.impl;

import geradorne.geradorne.application.BaseDAOImpl;
import geradorne.geradorne.dao.email.ModeloEmailDAO;
import geradorne.geradorne.modelo.email.ModeloEmail;
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
