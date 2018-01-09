package br.gov.pi.ati.bombeiro.dao.email;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.bombeiro.modelo.email.ConfiguracaoEmail;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface ConfiguracaoEmailDAO extends BaseDAO<ConfiguracaoEmail> {
    
}
