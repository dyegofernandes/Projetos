package br.gov.pi.ati.ati_guard.dao.controleacesso.impl;

import br.gov.pi.ati.ati_guard.application.BaseDAOImpl;
import br.gov.pi.ati.ati_guard.dao.controleacesso.AcessoSistemaDAO;
import br.gov.pi.ati.ati_guard.modelo.controleacesso.AcessoSistema;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class AcessoSistemaDAOImpl extends BaseDAOImpl<AcessoSistema> implements AcessoSistemaDAO {

    @Override
    public Class getEntityClass() {
        return AcessoSistema.class;
    }
    
    
}
