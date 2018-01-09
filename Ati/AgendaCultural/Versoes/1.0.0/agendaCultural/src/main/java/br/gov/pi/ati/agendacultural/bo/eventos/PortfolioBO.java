package br.gov.pi.ati.agendacultural.bo.eventos;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.agendacultural.dao.eventos.PortfolioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.agendacultural.modelo.eventos.Portfolio;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class PortfolioBO extends AbstractBusinessObject<Portfolio> {

    @EJB
    private PortfolioDAO portfolioDAO;
    
    @Override
    public PortfolioDAO getDAO() {
        return portfolioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("localPortfolio");
    }

    @Override
    public void validate(Portfolio portfolio) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
