package br.gov.pi.ati.dao.controleacesso;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.modelo.controleacesso.AcessoSistema;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface AcessoSistemaDAO extends BaseDAO<AcessoSistema> {
    
}
