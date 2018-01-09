package br.gov.pi.ati.adapi.dao.cadastro;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.adapi.modelo.cadastro.Animal;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface AnimalDAO extends BaseDAO<Animal> {
    
}
