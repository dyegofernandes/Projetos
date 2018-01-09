package br.gov.pi.ati.agendacultural.dao.email.impl;

import br.gov.pi.ati.agendacultural.application.BaseDAOImpl;
import br.gov.pi.ati.agendacultural.dao.email.ModeloEmailDAO;
import br.gov.pi.ati.agendacultural.modelo.email.ModeloEmail;
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
