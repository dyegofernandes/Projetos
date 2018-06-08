package br.com.facilpagar.dao.dados;

import com.xpert.persistence.dao.BaseDAO;
import br.com.facilpagar.modelo.dados.Contato;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface ContatoDAO extends BaseDAO<Contato> {
    
}
