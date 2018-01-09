package br.gov.pi.ati.agendacultural.dao.controleacesso.impl;

import br.gov.pi.ati.agendacultural.application.BaseDAOImpl;
import br.gov.pi.ati.agendacultural.dao.controleacesso.AcessoSistemaDAO;
import br.gov.pi.ati.agendacultural.modelo.controleacesso.AcessoSistema;
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
