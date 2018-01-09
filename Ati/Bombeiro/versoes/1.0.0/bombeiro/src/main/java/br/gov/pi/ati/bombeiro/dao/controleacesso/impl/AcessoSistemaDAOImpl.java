package br.gov.pi.ati.bombeiro.dao.controleacesso.impl;

import br.gov.pi.ati.bombeiro.application.BaseDAOImpl;
import br.gov.pi.ati.bombeiro.dao.controleacesso.AcessoSistemaDAO;
import br.gov.pi.ati.bombeiro.modelo.controleacesso.AcessoSistema;
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
