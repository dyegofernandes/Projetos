package br.gov.pi.ati.sisdh.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisdh.dao.cadastro.IdentidadeDeGeneroDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisdh.modelo.cadastro.IdentidadeDeGenero;

/**
 *
 * @author Juniel
 */
@Stateless
public class IdentidadeDeGeneroBO extends AbstractBusinessObject<IdentidadeDeGenero> {

    @EJB
    private IdentidadeDeGeneroDAO identidadeDeGeneroDAO;
    
    @Override
    public IdentidadeDeGeneroDAO getDAO() {
        return identidadeDeGeneroDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(IdentidadeDeGenero identidadeDeGenero) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
