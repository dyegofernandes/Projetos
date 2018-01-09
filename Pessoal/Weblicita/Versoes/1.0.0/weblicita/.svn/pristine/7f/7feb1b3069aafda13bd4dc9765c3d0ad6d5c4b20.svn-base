package br.com.weblicita.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.cadastro.RubricaOrcamentariaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.cadastro.RubricaOrcamentaria;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class RubricaOrcamentariaBO extends AbstractBusinessObject<RubricaOrcamentaria> {

    @EJB
    private RubricaOrcamentariaDAO rubricaOrcamentariaDAO;
    
    @Override
    public RubricaOrcamentariaDAO getDAO() {
        return rubricaOrcamentariaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields()
                .add("legenda");
    }

    @Override
    public void validate(RubricaOrcamentaria rubricaOrcamentaria) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
