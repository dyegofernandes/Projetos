package br.gov.pi.ati.dao.controleacesso.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.controleacesso.AcessoSistemaDAO;
import br.gov.pi.ati.modelo.controleacesso.AcessoSistema;
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
