package br.com.pagcontascarne.dao.dados;

import com.xpert.persistence.dao.BaseDAO;
import br.com.pagcontascarne.modelo.dados.Cliente;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface ClienteDAO extends BaseDAO<Cliente> {
    
}
