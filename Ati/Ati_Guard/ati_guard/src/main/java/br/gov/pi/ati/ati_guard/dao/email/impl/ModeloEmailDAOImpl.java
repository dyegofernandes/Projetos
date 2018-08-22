package br.gov.pi.ati.ati_guard.dao.email.impl;

import br.gov.pi.ati.ati_guard.application.BaseDAOImpl;
import br.gov.pi.ati.ati_guard.dao.email.ModeloEmailDAO;
import br.gov.pi.ati.ati_guard.modelo.email.ModeloEmail;
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
