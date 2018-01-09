package br.gov.pi.siste.dao.controleacesso.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.controleacesso.UsuarioUnidadeDAO;
import br.gov.pi.siste.modelo.controleacesso.UsuarioUnidade;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class UsuarioUnidadeDAOImpl extends BaseDAOImpl<UsuarioUnidade> implements UsuarioUnidadeDAO {

    @Override
    public Class getEntityClass() {
        return UsuarioUnidade.class;
    }

}
