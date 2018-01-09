package br.gov.pi.ati.salvavidas.dao.denuncia.impl;

import br.gov.pi.ati.salvavidas.application.BaseDAOImpl;
import br.gov.pi.ati.salvavidas.dao.denuncia.DenunciaDAO;
import br.gov.pi.ati.salvavidas.modelo.denuncia.Denuncia;
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
