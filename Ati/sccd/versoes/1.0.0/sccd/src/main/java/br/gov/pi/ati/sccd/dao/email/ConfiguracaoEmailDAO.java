package br.gov.pi.ati.sccd.dao.email;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.sccd.modelo.email.ConfiguracaoEmail;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface ConfiguracaoEmailDAO extends BaseDAO<ConfiguracaoEmail> {
    
}
