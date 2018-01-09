package br.gov.pi.ati.bombeiro.dao.denuncia;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.bombeiro.modelo.denuncia.Denuncia;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface DenunciaDAO extends BaseDAO<Denuncia> {
    
}
