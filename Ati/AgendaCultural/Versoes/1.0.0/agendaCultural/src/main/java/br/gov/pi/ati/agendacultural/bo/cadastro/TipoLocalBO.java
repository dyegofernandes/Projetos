package br.gov.pi.ati.agendacultural.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.agendacultural.dao.cadastro.TipoLocalDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.agendacultural.modelo.cadastro.TipoLocal;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class TipoLocalBO extends AbstractBusinessObject<TipoLocal> {

    @EJB
    private TipoLocalDAO tipoLocalDAO;

    @Override
    public TipoLocalDAO getDAO() {
        return tipoLocalDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("descricao");
    }

    @Override
    public void validate(TipoLocal tipoLocal) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
