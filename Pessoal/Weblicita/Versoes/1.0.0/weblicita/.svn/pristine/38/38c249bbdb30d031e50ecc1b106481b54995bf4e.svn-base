package br.com.weblicita.mb.licitacao;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.licitacao.IntencaoDeRegistroDePrecoBO;
import br.com.weblicita.modelo.licitacao.IntencaoDeRegistroDePreco;
import br.com.weblicita.modelo.licitacao.ItemLicitacao;
import br.com.weblicita.modelo.licitacao.PedidoLicitacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class IntencaoDeRegistroDePrecoMB extends AbstractBaseBean<IntencaoDeRegistroDePreco> implements Serializable {

    @EJB
    private IntencaoDeRegistroDePrecoBO intencaoDeRegistroDePrecoBO;

    private List<ItemLicitacao> itens;

    private PedidoLicitacao objeto = null;

    @Override
    public IntencaoDeRegistroDePrecoBO getBO() {
        return intencaoDeRegistroDePrecoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        itens = new ArrayList<ItemLicitacao>();

        if (getEntity().getId() != null) {
            itens = getDAO().getInitialized(getEntity().getItens());
        }
    }

    @Override
    public void save() {
        getEntity().setItens(itens);
        super.save();
    }

    public List<ItemLicitacao> getItens() {
        return itens;
    }

    public void setItens(List<ItemLicitacao> itens) {
        this.itens = itens;
    }

    public void carregaDadosObjeto() {
        objeto = null;
        itens = new ArrayList<ItemLicitacao>();
        if (getEntity().getObjetoDeInteresse() != null) {
            objeto = getDAO().getInitialized(getEntity().getObjetoDeInteresse());

            List<ItemLicitacao> itensTemp = getDAO().getInitialized(objeto.getItens());
            for (ItemLicitacao temp : itensTemp) {
                ItemLicitacao itemAdd = new ItemLicitacao();
                itemAdd.setItem(temp.getItem());
                itemAdd.setQuantidade(temp.getQuantidade());
                itemAdd.setUnidade(temp.getUnidade());

                itens.add(itemAdd);
            }
        }
    }

    public String getDescricaoObjeto() {
        if (objeto != null) {
            return objeto.getObjeto();
        }

        return null;
    }

}
