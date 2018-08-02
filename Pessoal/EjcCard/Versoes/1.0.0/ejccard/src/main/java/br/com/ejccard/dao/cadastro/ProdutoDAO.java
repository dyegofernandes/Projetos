package br.com.ejccard.dao.cadastro;

import com.xpert.persistence.dao.BaseDAO;
import br.com.ejccard.modelo.cadastro.Produto;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface ProdutoDAO extends BaseDAO<Produto> {
    
}
