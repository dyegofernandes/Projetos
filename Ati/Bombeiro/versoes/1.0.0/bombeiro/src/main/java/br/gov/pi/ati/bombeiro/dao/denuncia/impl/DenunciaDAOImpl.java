package br.gov.pi.ati.bombeiro.dao.denuncia.impl;

import br.gov.pi.ati.bombeiro.application.BaseDAOImpl;
import br.gov.pi.ati.bombeiro.dao.denuncia.DenunciaDAO;
import br.gov.pi.ati.bombeiro.modelo.denuncia.Denuncia;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class DenunciaDAOImpl extends BaseDAOImpl<Denuncia> implements DenunciaDAO {

    @Override
    public Class getEntityClass() {
        return Denuncia.class;
    }

}
