package br.com.aprove.dao.cadastro;

import com.xpert.persistence.dao.BaseDAO;
import br.com.aprove.modelo.cadastro.Cliente;
import javax.ejb.Local;

/**
 *
 * @author juniel
 */
@Local
public interface ClienteDAO extends BaseDAO<Cliente> {
    
}
