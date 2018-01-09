package br.gov.pi.ati.adapi.dao.configuracao.impl;

import br.gov.pi.ati.adapi.application.BaseDAOImpl;
import br.gov.pi.ati.adapi.dao.configuracao.ErroSistemaDAO;
import br.gov.pi.ati.adapi.modelo.configuracao.ErroSistema;
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
