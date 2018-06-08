package br.com.facilpagar.dao.dados;

import com.xpert.persistence.dao.BaseDAO;
import br.com.facilpagar.modelo.dados.Cliente;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface ClienteDAO extends BaseDAO<Cliente> {
    
}
