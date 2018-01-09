package cadastroaluno.cadastroaluno.dao.email.impl;

import cadastroaluno.cadastroaluno.application.BaseDAOImpl;
import cadastroaluno.cadastroaluno.dao.email.ModeloEmailDAO;
import cadastroaluno.cadastroaluno.modelo.email.ModeloEmail;
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
