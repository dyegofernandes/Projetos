package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.DiretrizeDeGovernoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.DiretrizeDeGoverno;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class DiretrizeDeGovernoBO extends AbstractBusinessObject<DiretrizeDeGoverno> {

    @EJB
    private DiretrizeDeGovernoDAO diretrizeDeGovernoDAO;

    @Override
    public DiretrizeDeGovernoDAO getDAO() {
        return diretrizeDeGovernoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo, unidadeOrcamentaria").add("nome, unidadeOrcamentaria");
    }

    @Override
    public void validate(DiretrizeDeGoverno diretrizeDeGoverno) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
