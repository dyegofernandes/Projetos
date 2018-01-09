package br.gov.pi.ati.cfcpm.dao.cadastro.impl;

import br.gov.pi.ati.cfcpm.application.BaseDAOImpl;
import br.gov.pi.ati.cfcpm.dao.cadastro.FormularioDeInscricaoDAO;
import br.gov.pi.ati.cfcpm.modelo.cadastro.FormularioDeInscricao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormularioDeInscricaoDAOImpl extends BaseDAOImpl<FormularioDeInscricao> implements FormularioDeInscricaoDAO {

    @Override
    public Class getEntityClass() {
        return FormularioDeInscricao.class;
    }

}
