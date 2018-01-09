package br.gov.pi.salvemaria.dao.email;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.salvemaria.modelo.email.ConfiguracaoEmail;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface ConfiguracaoEmailDAO extends BaseDAO<ConfiguracaoEmail> {
    
}
