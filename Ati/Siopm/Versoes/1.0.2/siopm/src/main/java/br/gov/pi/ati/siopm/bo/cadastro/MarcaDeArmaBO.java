package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.MarcaDeArmaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.MarcaDeArma;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class MarcaDeArmaBO extends AbstractBusinessObject<MarcaDeArma> {

    @EJB
    private MarcaDeArmaDAO marcaDeArmaDAO;
    
    @Override
    public MarcaDeArmaDAO getDAO() {
        return marcaDeArmaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields()
                .add("nome");
    }

    @Override
    public void validate(MarcaDeArma marcaDeArma) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
