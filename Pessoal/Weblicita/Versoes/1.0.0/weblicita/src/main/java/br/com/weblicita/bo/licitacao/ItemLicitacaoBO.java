package br.com.weblicita.bo.licitacao;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.licitacao.ItemLicitacaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.licitacao.ItemLicitacao;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemLicitacaoBO extends AbstractBusinessObject<ItemLicitacao> {

    @EJB
    private ItemLicitacaoDAO itemLicitacaoDAO;
    
    @Override
    public ItemLicitacaoDAO getDAO() {
        return itemLicitacaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ItemLicitacao itemLicitacao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
