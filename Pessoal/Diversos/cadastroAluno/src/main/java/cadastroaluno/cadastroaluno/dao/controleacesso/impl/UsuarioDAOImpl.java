package cadastroaluno.cadastroaluno.dao.controleacesso.impl;

import cadastroaluno.cadastroaluno.application.BaseDAOImpl;
import cadastroaluno.cadastroaluno.dao.controleacesso.UsuarioDAO;
import cadastroaluno.cadastroaluno.modelo.controleacesso.SituacaoUsuario;
import cadastroaluno.cadastroaluno.modelo.controleacesso.Usuario;
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
