package geradorne.geradorne.dao.configuracao.impl;

import geradorne.geradorne.application.BaseDAOImpl;
import geradorne.geradorne.dao.configuracao.ErroSistemaDAO;
import geradorne.geradorne.modelo.configuracao.ErroSistema;
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
