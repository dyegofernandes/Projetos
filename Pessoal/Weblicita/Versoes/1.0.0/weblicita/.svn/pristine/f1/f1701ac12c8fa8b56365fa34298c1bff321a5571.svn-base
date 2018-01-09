package br.com.weblicita.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.cadastro.GerenteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.cadastro.Gerente;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class GerenteBO extends AbstractBusinessObject<Gerente> {
    
    @EJB
    private GerenteDAO gerenteDAO;
    
    @Override
    public GerenteDAO getDAO() {
        return gerenteDAO;
    }
    
    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cpf").add("rg");
    }
    
    @Override
    public void validate(Gerente gerente) throws BusinessException {
    }
    
    @Override
    public boolean isAudit() {
        return true;
    }
    
}
