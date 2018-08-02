package br.gov.pi.ati.sisdh.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisdh.dao.cadastro.TerritorioCidadeDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisdh.modelo.cadastro.TerritorioCidade;

/**
 *
 * @author ads01
 */
@Stateless
public class TerritorioCidadeBO extends AbstractBusinessObject<TerritorioCidade> {

    @EJB
    private TerritorioCidadeDAO territorioCidadeDAO;
    
    @Override
    public TerritorioCidadeDAO getDAO() {
        return territorioCidadeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(TerritorioCidade territorioCidade) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
