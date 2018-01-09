package br.gov.pi.ati.adapi.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.adapi.dao.cadastro.AnimalDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.adapi.modelo.cadastro.Animal;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class AnimalBO extends AbstractBusinessObject<Animal> {

    @EJB
    private AnimalDAO animalDAO;
    
    @Override
    public AnimalDAO getDAO() {
        return animalDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome");
    }

    @Override
    public void validate(Animal animal) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
