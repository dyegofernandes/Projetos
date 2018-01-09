package br.gov.pi.salvemaria.dao.denuncia.impl;

import br.gov.pi.salvemaria.application.BaseDAOImpl;
import br.gov.pi.salvemaria.dao.denuncia.ArquivoDAO;
import br.gov.pi.salvemaria.modelo.denuncia.Arquivo;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ArquivoDAOImpl extends BaseDAOImpl<Arquivo> implements ArquivoDAO {

    @Override
    public Class getEntityClass() {
        return Arquivo.class;
    }

}
