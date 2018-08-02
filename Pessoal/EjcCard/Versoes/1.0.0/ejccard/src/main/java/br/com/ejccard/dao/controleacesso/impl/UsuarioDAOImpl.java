package br.com.ejccard.dao.controleacesso.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.controleacesso.UsuarioDAO;
import br.com.ejccard.modelo.controleacesso.SituacaoUsuario;
import br.com.ejccard.modelo.controleacesso.Usuario;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Ayslan
 */
@Stateless
public class UsuarioDAOImpl extends BaseDAOImpl<Usuario> implements UsuarioDAO {

    @Override
    public Class getEntityClass() {
        return Usuario.class;
    }

    @Override
    public List<Usuario> getUsuariosAtivos() {
        return list("situacaoUsuario", SituacaoUsuario.ATIVO, "nome");
    }
    
    
}
