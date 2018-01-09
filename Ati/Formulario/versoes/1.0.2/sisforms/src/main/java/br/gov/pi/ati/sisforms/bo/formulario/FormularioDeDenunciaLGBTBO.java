package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.FormularioDeDenunciaLGBTDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.FormularioDeDenunciaLGBT;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormularioDeDenunciaLGBTBO extends AbstractBusinessObject<FormularioDeDenunciaLGBT> {

    @EJB
    private FormularioDeDenunciaLGBTDAO formularioDeDenunciaLGBTDAO;
    
    @Override
    public FormularioDeDenunciaLGBTDAO getDAO() {
        return formularioDeDenunciaLGBTDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FormularioDeDenunciaLGBT formularioDeDenunciaLGBT) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
