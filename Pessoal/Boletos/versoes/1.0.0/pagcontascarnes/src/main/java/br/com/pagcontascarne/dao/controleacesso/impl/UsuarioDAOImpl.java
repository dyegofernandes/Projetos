package br.com.pagcontascarne.dao.controleacesso.impl;

import br.com.pagcontascarne.application.BaseDAOImpl;
import br.com.pagcontascarne.dao.controleacesso.UsuarioDAO;
import br.com.pagcontascarne.modelo.controleacesso.SituacaoUsuario;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
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
