package br.com.politicalpartysystem.dao.controleacesso;

import com.xpert.persistence.dao.BaseDAO;
import br.com.politicalpartysystem.modelo.controleacesso.HistoricoSituacaoUsuario;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface HistoricoSituacaoUsuarioDAO extends BaseDAO<HistoricoSituacaoUsuario> {
    
}
