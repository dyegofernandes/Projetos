package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.RequisicaoDeMaterialDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.RequisicaoDeMaterial;

/**
 *
 * @author Juniel
 */
@Stateless
public class RequisicaoDeMaterialBO extends AbstractBusinessObject<RequisicaoDeMaterial> {

    @EJB
    private RequisicaoDeMaterialDAO requisicaoDeMaterialDAO;
    
    @Override
    public RequisicaoDeMaterialDAO getDAO() {
        return requisicaoDeMaterialDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(RequisicaoDeMaterial requisicaoDeMaterial) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
