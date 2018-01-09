package br.com.aprove.dao.faturamento;

import com.xpert.persistence.dao.BaseDAO;
import br.com.aprove.modelo.faturamento.Estoque;
import javax.ejb.Local;

/**
 *
 * @author juniel
 */
@Local
public interface EstoqueDAO extends BaseDAO<Estoque> {
    
}
