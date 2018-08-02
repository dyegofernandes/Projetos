package br.com.ejccard.dao.email;

import com.xpert.persistence.dao.BaseDAO;
import br.com.ejccard.modelo.email.ConfiguracaoEmail;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface ConfiguracaoEmailDAO extends BaseDAO<ConfiguracaoEmail> {
    
}
