package br.com.facilpagar.dao.dados;

import com.xpert.persistence.dao.BaseDAO;
import br.com.facilpagar.modelo.dados.Boleto;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface BoletoDAO extends BaseDAO<Boleto> {
    
}
