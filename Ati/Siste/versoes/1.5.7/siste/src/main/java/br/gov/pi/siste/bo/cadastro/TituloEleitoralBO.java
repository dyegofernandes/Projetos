package br.gov.pi.siste.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.cadastro.TituloEleitoralDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.cadastro.TituloEleitoral;

/**
 *
 * @author Juniel
 */
@Stateless
public class TituloEleitoralBO extends AbstractBusinessObject<TituloEleitoral> {

    @EJB
    private TituloEleitoralDAO tituloEleitoralDAO;
    
    @Override
    public TituloEleitoralDAO getDAO() {
        return tituloEleitoralDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(TituloEleitoral tituloEleitoral) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
