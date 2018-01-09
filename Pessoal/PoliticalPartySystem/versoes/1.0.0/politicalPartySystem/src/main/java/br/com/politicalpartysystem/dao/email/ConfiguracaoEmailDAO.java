package br.com.politicalpartysystem.dao.email;

import com.xpert.persistence.dao.BaseDAO;
import br.com.politicalpartysystem.modelo.email.ConfiguracaoEmail;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface ConfiguracaoEmailDAO extends BaseDAO<ConfiguracaoEmail> {
    
}
