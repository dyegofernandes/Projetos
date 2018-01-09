package br.gov.pi.siste.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.financeiro.SalarioMinimoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.financeiro.SalarioMinimo;

/**
 *
 * @author Juniel
 */
@Stateless
public class SalarioMinimoBO extends AbstractBusinessObject<SalarioMinimo> {

    @EJB
    private SalarioMinimoDAO salarioMinimoDAO;
    
    @Override
    public SalarioMinimoDAO getDAO() {
        return salarioMinimoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("anoDeVingencia");
    }

    @Override
    public void validate(SalarioMinimo salarioMinimo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
