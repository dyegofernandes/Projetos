package br.gov.pi.ati.sccd.bo.certificado;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.certificado.CertificadoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.certificado.Certificado;

/**
 *
 * @author Juniel
 */
@Stateless
public class CertificadoBO extends AbstractBusinessObject<Certificado> {

    @EJB
    private CertificadoDAO certificadoDAO;
    
    @Override
    public CertificadoDAO getDAO() {
        return certificadoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Certificado certificado) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
    
    public Integer sequencial(Integer caixa){
        return (Integer) getDAO().getQueryBuilder().select("certificado.sequencial").from(Certificado.class, "certificado").add("certificado.caixa", caixa).max("certificado.sequencial");
    }

}
