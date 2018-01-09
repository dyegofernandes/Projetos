package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.ItemFormCriacaoEmailDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemFormCriacaoEmail;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemFormCriacaoEmailBO extends AbstractBusinessObject<ItemFormCriacaoEmail> {

    @EJB
    private ItemFormCriacaoEmailDAO itemFormCriacaoEmailDAO;
    
    @Override
    public ItemFormCriacaoEmailDAO getDAO() {
        return itemFormCriacaoEmailDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ItemFormCriacaoEmail itemFormCriacaoEmail) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
