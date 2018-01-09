package br.gov.pi.siste.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.cadastro.FormacaoProfissionalDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.cadastro.FormacaoProfissional;

/**
 *
 * @author Juniel
 */
@Stateless
public class FormacaoProfissionalBO extends AbstractBusinessObject<FormacaoProfissional> {

    @EJB
    private FormacaoProfissionalDAO formacaoProfissionalDAO;
    
    @Override
    public FormacaoProfissionalDAO getDAO() {
        return formacaoProfissionalDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo", "nome");
    }

    @Override
    public void validate(FormacaoProfissional formacaoProfissional) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
