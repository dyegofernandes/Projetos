package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.ItemFormAcessoConteudoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemFormAcessoConteudo;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemFormAcessoConteudoBO extends AbstractBusinessObject<ItemFormAcessoConteudo> {

    @EJB
    private ItemFormAcessoConteudoDAO itemFormAcessoConteudoDAO;
    
    @Override
    public ItemFormAcessoConteudoDAO getDAO() {
        return itemFormAcessoConteudoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ItemFormAcessoConteudo itemFormAcessoConteudo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
