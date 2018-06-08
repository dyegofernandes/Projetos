package br.com.facilpagar.dao.controleacesso.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.controleacesso.UsuarioDAO;
import br.com.facilpagar.modelo.controleacesso.SituacaoUsuario;
import br.com.facilpagar.modelo.controleacesso.Usuario;
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
