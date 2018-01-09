package com.opfacil.dao.controleacesso.impl;

import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.controleacesso.UsuarioDAO;
import com.opfacil.modelo.controleacesso.SituacaoUsuario;
import com.opfacil.modelo.controleacesso.Usuario;
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
