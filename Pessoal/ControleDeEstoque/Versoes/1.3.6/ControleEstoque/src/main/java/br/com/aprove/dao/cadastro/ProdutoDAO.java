package br.com.aprove.dao.cadastro;

import com.xpert.persistence.dao.BaseDAO;
import br.com.aprove.modelo.cadastro.Produto;
import javax.ejb.Local;

/**
 *
 * @author juniel
 */
@Local
public interface ProdutoDAO extends BaseDAO<Produto> {
    
}
