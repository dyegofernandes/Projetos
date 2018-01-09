package br.com.politicalpartysystem.dao.cadastro;

import com.xpert.persistence.dao.BaseDAO;
import br.com.politicalpartysystem.modelo.cadastro.Person;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface PersonDAO extends BaseDAO<Person> {
    
}
