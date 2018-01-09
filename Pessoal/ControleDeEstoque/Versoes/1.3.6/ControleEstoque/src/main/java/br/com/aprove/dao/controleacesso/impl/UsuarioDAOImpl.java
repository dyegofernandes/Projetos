package br.com.aprove.dao.controleacesso.impl;

import br.com.aprove.application.BaseDAOImpl;
import br.com.aprove.dao.controleacesso.UsuarioDAO;
import br.com.aprove.modelo.controleacesso.SituacaoUsuario;
import br.com.aprove.modelo.controleacesso.Usuario;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author #Author
 */
@Stateless
public class UsuarioDAOImpl extends BaseDAOImpl<Usuario> implements UsuarioDAO {

    @Override
    public List<Usuario> getUsuariosAtivos() {
        return list("situacaoUsuario", SituacaoUsuario.ATIVO, "nome");
    }
}
