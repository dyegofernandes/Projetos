package br.com.dizimo.dao.financeiro;

import com.xpert.persistence.dao.BaseDAO;
import br.com.dizimo.modelo.financeiro.Dizimo;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface DizimoDAO extends BaseDAO<Dizimo> {
    
}
