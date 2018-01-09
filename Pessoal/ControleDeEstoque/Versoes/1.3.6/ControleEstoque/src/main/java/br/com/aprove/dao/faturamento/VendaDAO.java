package br.com.aprove.dao.faturamento;

import com.xpert.persistence.dao.BaseDAO;
import br.com.aprove.modelo.faturamento.Venda;
import javax.ejb.Local;

/**
 *
 * @author juniel
 */
@Local
public interface VendaDAO extends BaseDAO<Venda> {
    
}
