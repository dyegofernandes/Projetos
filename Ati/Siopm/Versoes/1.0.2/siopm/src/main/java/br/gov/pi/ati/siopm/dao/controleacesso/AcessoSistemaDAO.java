package br.gov.pi.ati.siopm.dao.controleacesso;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.siopm.modelo.controleacesso.AcessoSistema;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface AcessoSistemaDAO extends BaseDAO<AcessoSistema> {
    
}
