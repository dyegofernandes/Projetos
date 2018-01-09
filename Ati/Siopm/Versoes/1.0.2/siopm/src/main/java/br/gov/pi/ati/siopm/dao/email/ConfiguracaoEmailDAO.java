package br.gov.pi.ati.siopm.dao.email;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.siopm.modelo.email.ConfiguracaoEmail;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface ConfiguracaoEmailDAO extends BaseDAO<ConfiguracaoEmail> {
    
}
