package br.gov.pi.ati.sisdh.dao.configuracao.impl;

import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.dao.configuracao.ErroSistemaDAO;
import br.gov.pi.ati.sisdh.modelo.configuracao.ErroSistema;
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
