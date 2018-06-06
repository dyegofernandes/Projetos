package br.gov.pi.ati.sisdh.dao.controleacesso;

import br.gov.pi.ati.sisdh.modelo.controleacesso.Perfil;
import br.gov.pi.ati.sisdh.modelo.controleacesso.Usuario;
import com.xpert.persistence.dao.BaseDAO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ayslan
 */
@Local
public interface PerfilDAO extends BaseDAO<Perfil> {

    /**
     * retorn os perfis do usuario
     *
     * @param usuario
     * @return
     */
    public List<Perfil> getPerfis(Usuario usuario);
}
