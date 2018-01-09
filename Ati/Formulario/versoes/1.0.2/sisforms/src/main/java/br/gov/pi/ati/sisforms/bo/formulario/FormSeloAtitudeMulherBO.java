package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.FormSeloAtitudeMulherDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.FormSeloAtitudeMulher;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormSeloAtitudeMulherBO extends AbstractBusinessObject<FormSeloAtitudeMulher> {

    @EJB
    private FormSeloAtitudeMulherDAO formSeloAtitudeMulherDAO;
    
    @Override
    public FormSeloAtitudeMulherDAO getDAO() {
        return formSeloAtitudeMulherDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FormSeloAtitudeMulher formSeloAtitudeMulher) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
