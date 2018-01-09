package br.gov.pi.ati.siopm.dao.ocorrencia;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.siopm.modelo.ocorrencia.Ocorrencia;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface OcorrenciaDAO extends BaseDAO<Ocorrencia> {
    
}
