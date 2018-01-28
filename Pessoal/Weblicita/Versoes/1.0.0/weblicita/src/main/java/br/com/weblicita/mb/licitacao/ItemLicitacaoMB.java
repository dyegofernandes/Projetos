package br.com.weblicita.mb.licitacao;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.licitacao.ItemLicitacaoBO;
import br.com.weblicita.modelo.licitacao.ItemLicitacao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ItemLicitacaoMB extends AbstractBaseBean<ItemLicitacao> implements Serializable {

    @EJB
    private ItemLicitacaoBO itemLicitacaoBO;

    @Override
    public ItemLicitacaoBO getBO() {
        return itemLicitacaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
