package br.gov.pi.ati.sisforms.dao.cadastro.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.cadastro.OrgaoCertificadoDAO;
import br.gov.pi.ati.sisforms.modelo.cadastro.OrgaoCertificado;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class OrgaoCertificadoDAOImpl extends BaseDAOImpl<OrgaoCertificado> implements OrgaoCertificadoDAO {

    @Override
    public Class getEntityClass() {
        return OrgaoCertificado.class;
    }

}
