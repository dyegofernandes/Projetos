package br.gov.pi.salvemaria.dao.configuracao.impl;

import br.gov.pi.salvemaria.application.BaseDAOImpl;
import br.gov.pi.salvemaria.dao.configuracao.ErroSistemaDAO;
import br.gov.pi.salvemaria.modelo.configuracao.ErroSistema;
import javax.ejb.Stateless;

/**
 *
 * @author Ayslan
 */
@Stateless
public class ErroSistemaDAOImpl extends BaseDAOImpl<ErroSistema> implements ErroSistemaDAO {

    @Override
    public Class getEntityClass() {
        return ErroSistema.class;
    }
    
    
    
}
