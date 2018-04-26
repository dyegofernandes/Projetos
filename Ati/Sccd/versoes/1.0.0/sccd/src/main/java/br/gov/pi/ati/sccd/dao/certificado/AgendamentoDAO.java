package br.gov.pi.ati.sccd.dao.certificado;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.sccd.modelo.certificado.Agendamento;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface AgendamentoDAO extends BaseDAO<Agendamento> {
    
}
