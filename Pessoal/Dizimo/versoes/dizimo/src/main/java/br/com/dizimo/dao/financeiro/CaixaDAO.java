package br.com.dizimo.dao.financeiro;

import com.xpert.persistence.dao.BaseDAO;
import br.com.dizimo.modelo.financeiro.Caixa;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface CaixaDAO extends BaseDAO<Caixa> {
    
}
