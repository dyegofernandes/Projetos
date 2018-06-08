package br.com.facilpagar.dao.dados;

import com.xpert.persistence.dao.BaseDAO;
import br.com.facilpagar.modelo.dados.Produto;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface ProdutoDAO extends BaseDAO<Produto> {
    
}
