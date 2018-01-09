package com.ebol.dao.controleacesso.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.controleacesso.UsuarioDAO;
import com.ebol.modelo.controleacesso.SituacaoUsuario;
import com.ebol.modelo.controleacesso.Usuario;
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
