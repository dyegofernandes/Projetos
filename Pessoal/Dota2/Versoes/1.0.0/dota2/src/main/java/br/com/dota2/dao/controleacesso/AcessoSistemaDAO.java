package br.com.dota2.dao.controleacesso;

import com.xpert.persistence.dao.BaseDAO;
import br.com.dota2.modelo.controleacesso.AcessoSistema;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface AcessoSistemaDAO extends BaseDAO<AcessoSistema> {
    
}
