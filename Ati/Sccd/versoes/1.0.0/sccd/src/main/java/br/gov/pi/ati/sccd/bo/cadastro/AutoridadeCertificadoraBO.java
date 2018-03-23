package br.gov.pi.ati.sccd.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.cadastro.AutoridadeCertificadoraDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.cadastro.AutoridadeCertificadora;

/**
 *
 * @author Juniel
 */
@Stateless
public class AutoridadeCertificadoraBO extends AbstractBusinessObject<AutoridadeCertificadora> {

    @EJB
    private AutoridadeCertificadoraDAO autoridadeCertificadoraDAO;
    
    @Override
    public AutoridadeCertificadoraDAO getDAO() {
        return autoridadeCertificadoraDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(AutoridadeCertificadora autoridadeCertificadora) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
