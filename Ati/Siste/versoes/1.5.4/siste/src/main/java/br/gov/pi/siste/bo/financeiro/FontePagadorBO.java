package br.gov.pi.siste.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.financeiro.FontePagadorDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.financeiro.FontePagador;

/**
 *
 * @author Juniel
 */
@Stateless
public class FontePagadorBO extends AbstractBusinessObject<FontePagador> {

    @EJB
    private FontePagadorDAO fontePagadorDAO;
    
    @Override
    public FontePagadorDAO getDAO() {
        return fontePagadorDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FontePagador fontePagador) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
