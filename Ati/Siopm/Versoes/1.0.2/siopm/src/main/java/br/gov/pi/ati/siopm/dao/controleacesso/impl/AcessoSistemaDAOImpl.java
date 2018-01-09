package br.gov.pi.ati.siopm.dao.controleacesso.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.controleacesso.AcessoSistemaDAO;
import br.gov.pi.ati.siopm.modelo.controleacesso.AcessoSistema;
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
