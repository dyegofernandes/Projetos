package br.gov.pi.ati.salvavidas.dao.email;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.salvavidas.modelo.email.ConfiguracaoEmail;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface ConfiguracaoEmailDAO extends BaseDAO<ConfiguracaoEmail> {
    
}
