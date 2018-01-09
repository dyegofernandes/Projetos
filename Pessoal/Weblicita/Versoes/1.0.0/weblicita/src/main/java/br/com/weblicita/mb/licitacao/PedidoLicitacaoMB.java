package br.com.weblicita.mb.licitacao;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.licitacao.PedidoLicitacaoBO;
import br.com.weblicita.modelo.cadastro.Item;
import br.com.weblicita.modelo.licitacao.PedidoLicitacao;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PedidoLicitacaoMB extends AbstractBaseBean<PedidoLicitacao> implements Serializable {

    @EJB
    private PedidoLicitacaoBO pedidoLicitacaoBO;

    private Item itemAdd;

    private List<Item> itens;

    @Override
    public PedidoLicitacaoBO getBO() {
        return pedidoLicitacaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        itemAdd = new Item();
        itens = new ArrayList<Item>();

        if (getEntity().getId() != null) {
            itens = getBO().getDAO().getInitialized(getEntity().getItens());
        }
    }

    @Override
    public void save() {
        getEntity().setItens(itens);
        super.save(); //To change body of generated methods, choose Tools | Templates.
    }

    public void addItem() {
        if (itemAdd != null) {
            if (verificarItemJahAdicionado(itemAdd)) {
                FacesMessageUtils.error("Item já foi adicionado!");
            } else {
                itens.add(itemAdd);
                itemAdd = new Item();
            }
        } else {
            FacesMessageUtils.error("Item é obrigatório!");
        }
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public boolean verificarItemJahAdicionado(Item itemAdicionado) {
        for (Item item : itens) {
            if (item.equals(itemAdicionado)) {
                return true;
            }
        }

        return false;
    }
}
