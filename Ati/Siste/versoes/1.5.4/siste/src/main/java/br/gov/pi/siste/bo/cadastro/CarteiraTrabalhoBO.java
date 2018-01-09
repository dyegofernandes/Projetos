package br.gov.pi.siste.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.cadastro.CarteiraTrabalhoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import com.xpert.core.validation.UniqueFields;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.cadastro.CarteiraTrabalho;

/**
 *
 * @author Juniel
 */
@Stateless
public class CarteiraTrabalhoBO extends AbstractBusinessObject<CarteiraTrabalho> {

    @EJB
    private CarteiraTrabalhoDAO carteiraTrabalhoDAO;
    
    @Override
    public CarteiraTrabalhoDAO getDAO() {
        return carteiraTrabalhoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("numero").add("pisPasepNit");
    }

    @Override
    public void validate(CarteiraTrabalho carteiraTrabalho) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
