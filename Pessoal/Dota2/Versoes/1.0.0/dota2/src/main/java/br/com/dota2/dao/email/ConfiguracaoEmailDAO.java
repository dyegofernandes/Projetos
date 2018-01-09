package br.com.dota2.dao.email;

import com.xpert.persistence.dao.BaseDAO;
import br.com.dota2.modelo.email.ConfiguracaoEmail;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface ConfiguracaoEmailDAO extends BaseDAO<ConfiguracaoEmail> {
    
}
