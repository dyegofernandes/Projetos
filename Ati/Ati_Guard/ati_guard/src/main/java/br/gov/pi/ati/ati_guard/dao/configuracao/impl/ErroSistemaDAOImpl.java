package br.gov.pi.ati.ati_guard.dao.configuracao.impl;

import br.gov.pi.ati.ati_guard.application.BaseDAOImpl;
import br.gov.pi.ati.ati_guard.dao.configuracao.ErroSistemaDAO;
import br.gov.pi.ati.ati_guard.modelo.configuracao.ErroSistema;
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
