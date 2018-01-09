package br.gov.pi.ati.salvavidas.dao.controleacesso;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.salvavidas.modelo.controleacesso.HistoricoSituacaoUsuario;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface HistoricoSituacaoUsuarioDAO extends BaseDAO<HistoricoSituacaoUsuario> {
    
}
