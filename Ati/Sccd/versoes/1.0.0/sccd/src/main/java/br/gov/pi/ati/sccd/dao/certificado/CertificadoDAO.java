package br.gov.pi.ati.sccd.dao.certificado;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.sccd.modelo.certificado.Certificado;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface CertificadoDAO extends BaseDAO<Certificado> {
    
}
