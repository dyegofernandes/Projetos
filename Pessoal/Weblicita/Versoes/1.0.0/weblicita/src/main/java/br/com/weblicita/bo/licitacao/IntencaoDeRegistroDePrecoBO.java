package br.com.weblicita.bo.licitacao;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.licitacao.IntencaoDeRegistroDePrecoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.licitacao.IntencaoDeRegistroDePreco;
import br.com.weblicita.modelo.licitacao.ItemLicitacao;

/**
 *
 * @author Juniel
 */
@Stateless
public class IntencaoDeRegistroDePrecoBO extends AbstractBusinessObject<IntencaoDeRegistroDePreco> {

    @EJB
    private IntencaoDeRegistroDePrecoDAO intencaoDeRegistroDePrecoDAO;

    @Override
    public IntencaoDeRegistroDePrecoDAO getDAO() {
        return intencaoDeRegistroDePrecoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(IntencaoDeRegistroDePreco intencaoDeRegistroDePreco) throws BusinessException {
        List<ItemLicitacao> itens = getDAO().getInitialized(intencaoDeRegistroDePreco.getItens());
        if (itens == null) {
            throw new BusinessException("Um ou mais itens são obrigatórios!");
        } else {
            if (itens.size() < 1) {
                throw new BusinessException("Um ou mais itens são obrigatórios!");
            } else {
                for (ItemLicitacao iten : itens) {
                    if (iten.getItem() == null) {
                        throw new BusinessException("Item é obrigatório!");
                    }

                    if (iten.getUnidade() == null) {
                        throw new BusinessException("Unidade do item é obrigatória!");
                    }

                    if (iten.getQuantidade() == null) {
                        throw new BusinessException("Quantidade do item é obrigatória!");
                    }
                }
            }
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
