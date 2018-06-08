package br.com.facilpagar.dao.controleacesso;

import com.xpert.persistence.dao.BaseDAO;
import br.com.facilpagar.modelo.controleacesso.AcessoSistema;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface AcessoSistemaDAO extends BaseDAO<AcessoSistema> {
    
}
