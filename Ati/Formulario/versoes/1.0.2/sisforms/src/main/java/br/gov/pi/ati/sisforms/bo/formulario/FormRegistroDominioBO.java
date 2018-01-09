package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.FormRegistroDominioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.FormRegistroDominio;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormRegistroDominioBO extends AbstractBusinessObject<FormRegistroDominio> {

    @EJB
    private FormRegistroDominioDAO formRegistroDominioDAO;
    
    @Override
    public FormRegistroDominioDAO getDAO() {
        return formRegistroDominioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FormRegistroDominio formRegistroDominio) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
