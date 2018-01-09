package br.com.dota2.dao.controleacesso.impl;

import br.com.dota2.application.BaseDAOImpl;
import br.com.dota2.dao.controleacesso.UsuarioDAO;
import br.com.dota2.modelo.controleacesso.SituacaoUsuario;
import br.com.dota2.modelo.controleacesso.Usuario;
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
