package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.FonteDeRecursoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.FonteDeRecurso;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class FonteDeRecursoBO extends AbstractBusinessObject<FonteDeRecurso> {

    @EJB
    private FonteDeRecursoDAO fonteDeRecursoDAO;
    
    @Override
    public FonteDeRecursoDAO getDAO() {
        return fonteDeRecursoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo").add("nome").add("mnemonico");
    }

    @Override
    public void validate(FonteDeRecurso fonteDeRecurso) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
