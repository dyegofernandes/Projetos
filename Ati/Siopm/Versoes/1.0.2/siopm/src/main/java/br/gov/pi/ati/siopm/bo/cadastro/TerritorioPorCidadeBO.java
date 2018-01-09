package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.TerritorioPorCidadeDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.TerritorioPorCidade;

/**
 *
 * @author Juniel
 */
@Stateless
public class TerritorioPorCidadeBO extends AbstractBusinessObject<TerritorioPorCidade> {

    @EJB
    private TerritorioPorCidadeDAO territorioPorCidadeDAO;
    
    @Override
    public TerritorioPorCidadeDAO getDAO() {
        return territorioPorCidadeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(TerritorioPorCidade territorioPorCidade) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
