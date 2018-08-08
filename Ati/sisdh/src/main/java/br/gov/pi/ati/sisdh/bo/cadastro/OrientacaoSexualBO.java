package br.gov.pi.ati.sisdh.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisdh.dao.cadastro.OrientacaoSexualDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisdh.modelo.cadastro.OrientacaoSexual;

/**
 *
 * @author Juniel
 */
@Stateless
public class OrientacaoSexualBO extends AbstractBusinessObject<OrientacaoSexual> {

    @EJB
    private OrientacaoSexualDAO orientacaoSexualDAO;
    
    @Override
    public OrientacaoSexualDAO getDAO() {
        return orientacaoSexualDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(OrientacaoSexual orientacaoSexual) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
