package br.gov.pi.ati.sisdh.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisdh.dao.cadastro.TerritorioBairroDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisdh.modelo.cadastro.TerritorioBairro;

/**
 *
 * @author ads01
 */
@Stateless
public class TerritorioBairroBO extends AbstractBusinessObject<TerritorioBairro> {

    @EJB
    private TerritorioBairroDAO territorioBairroDAO;
    
    @Override
    public TerritorioBairroDAO getDAO() {
        return territorioBairroDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(TerritorioBairro territorioBairro) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
