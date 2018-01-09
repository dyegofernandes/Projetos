package br.gov.pi.ati.salvavidas.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.salvavidas.dao.cadastro.FonteRecursoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.salvavidas.modelo.cadastro.FonteRecurso;

/**
 *
 * @author Juniel
 */
@Stateless
public class FonteRecursoBO extends AbstractBusinessObject<FonteRecurso> {

    @EJB
    private FonteRecursoDAO fonteRecursoDAO;
    
    @Override
    public FonteRecursoDAO getDAO() {
        return fonteRecursoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FonteRecurso fonteRecurso) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
