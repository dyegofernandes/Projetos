package br.gov.pi.ati.cfcpm.dao.cadastro.impl;

import br.gov.pi.ati.cfcpm.application.BaseDAOImpl;
import br.gov.pi.ati.cfcpm.dao.cadastro.FormularioInscricaoSAVDAO;
import br.gov.pi.ati.cfcpm.modelo.cadastro.FormularioInscricaoSAV;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormularioInscricaoSAVDAOImpl extends BaseDAOImpl<FormularioInscricaoSAV> implements FormularioInscricaoSAVDAO {

    @Override
    public Class getEntityClass() {
        return FormularioInscricaoSAV.class;
    }

}
