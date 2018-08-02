package br.com.ejccard.dao.financeiro;

import com.xpert.persistence.dao.BaseDAO;
import br.com.ejccard.modelo.financeiro.EjcCard;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface EjcCardDAO extends BaseDAO<EjcCard> {
    
}
