package br.gov.pi.ati.sccd.dao.cadastro;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface ClienteDAO extends BaseDAO<Cliente> {
    
}
