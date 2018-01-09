package br.gov.pi.ati.bombeiro.dao.controleacesso;

import br.gov.pi.ati.bombeiro.modelo.controleacesso.Usuario;
import com.xpert.persistence.dao.BaseDAO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ayslan
 */
@Local
public interface UsuarioDAO extends BaseDAO<Usuario> {

    /**
     * retorn os usuarios ativos (situacaoUsuario = SituacaoUsuario.ATIVO)
     *
     * @return
     */
    public List<Usuario> getUsuariosAtivos();

}
