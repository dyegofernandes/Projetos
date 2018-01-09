package br.gov.pi.salvemaria.dao.controleacesso;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.salvemaria.modelo.controleacesso.AcessoSistema;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface AcessoSistemaDAO extends BaseDAO<AcessoSistema> {
    
}
