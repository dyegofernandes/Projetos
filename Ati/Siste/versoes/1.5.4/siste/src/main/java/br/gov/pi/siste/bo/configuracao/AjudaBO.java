package br.gov.pi.siste.bo.configuracao;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.configuracao.AjudaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.configuracao.Ajuda;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class AjudaBO extends AbstractBusinessObject<Ajuda> {

    @EJB
    private AjudaDAO ajudaDAO;

    @Override
    public AjudaDAO getDAO() {
        return ajudaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields()
                .add("titulo");
    }

    @Override
    public void validate(Ajuda ajuda) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
