package br.com.weblicita.dao.cadastro;

import com.xpert.persistence.dao.BaseDAO;
import br.com.weblicita.modelo.cadastro.Item;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface ItemLicitacaoDAO extends BaseDAO<Item> {
    
}
