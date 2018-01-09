package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.AcaoEstrategicaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class AcaoEstrategicaBO extends AbstractBusinessObject<AcaoEstrategica> {

    @EJB
    private AcaoEstrategicaDAO acaoEstrategicaDAO;

    @Override
    public AcaoEstrategicaDAO getDAO() {
        return acaoEstrategicaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("orgao", "nome");
    }

    @Override
    public void validate(AcaoEstrategica acaoEstrategica) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
