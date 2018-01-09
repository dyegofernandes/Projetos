package br.com.jsoft.centralfinanceira.dao.financeiro;

import com.xpert.persistence.dao.BaseDAO;
import br.com.jsoft.centralfinanceira.modelo.financeiro.Lancamentos;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface LancamentosDAO extends BaseDAO<Lancamentos> {
    
}
