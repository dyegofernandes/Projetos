package br.gov.pi.salvemaria.dao.denuncia.impl;

import br.gov.pi.salvemaria.application.BaseDAOImpl;
import br.gov.pi.salvemaria.dao.denuncia.DenunciaDAO;
import br.gov.pi.salvemaria.modelo.denuncia.Denuncia;
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
