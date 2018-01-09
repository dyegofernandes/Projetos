package br.com.politicalpartysystem.dao.cadastro;

import com.xpert.persistence.dao.BaseDAO;
import br.com.politicalpartysystem.modelo.cadastro.PoliticalParty;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface PoliticalPartyDAO extends BaseDAO<PoliticalParty> {
    
}
