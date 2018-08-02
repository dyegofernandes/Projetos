package br.com.ejccard.dao.controleacesso;

import com.xpert.persistence.dao.BaseDAO;
import br.com.ejccard.modelo.controleacesso.AcessoSistema;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface AcessoSistemaDAO extends BaseDAO<AcessoSistema> {
    
}
