package geradorne.geradorne.dao.controleacesso.impl;

import geradorne.geradorne.application.BaseDAOImpl;
import geradorne.geradorne.dao.controleacesso.UsuarioDAO;
import geradorne.geradorne.modelo.controleacesso.SituacaoUsuario;
import geradorne.geradorne.modelo.controleacesso.Usuario;
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
