package br.gov.pi.ati.passelivre.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.passelivre.dao.cadastro.TesteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.passelivre.modelo.cadastro.Teste;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class TesteBO extends AbstractBusinessObject<Teste> {

    @EJB
    private TesteDAO testeDAO;
    
    @Override
    public TesteDAO getDAO() {
        return testeDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Teste teste) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
