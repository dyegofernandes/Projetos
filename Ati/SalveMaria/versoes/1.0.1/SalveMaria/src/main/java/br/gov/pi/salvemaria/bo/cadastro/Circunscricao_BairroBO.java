package br.gov.pi.salvemaria.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.cadastro.Circunscricao_BairroDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao_Bairro;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class Circunscricao_BairroBO extends AbstractBusinessObject<Circunscricao_Bairro> {

    @EJB
    private Circunscricao_BairroDAO circunscricao_BairroDAO;
    
    @Override
    public Circunscricao_BairroDAO getDAO() {
        return circunscricao_BairroDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome", "cidade") ;
    }

    @Override
    public void validate(Circunscricao_Bairro circunscricao_Bairro) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
