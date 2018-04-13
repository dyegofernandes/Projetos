package br.gov.pi.ati.sccd.mb.certificado;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.PedidoBO;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;
import br.gov.pi.ati.sccd.modelo.certificado.Pedido;
import br.gov.pi.ati.sccd.modelo.enums.TipoPessoa;
import br.gov.pi.ati.sccd.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.query.JoinBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PedidoMB extends AbstractBaseBean<Pedido> implements Serializable {

    @EJB
    private PedidoBO pedidoBO;

    private List<ItemPedido> itens;

    private ItemPedido itemAdd;

    @Override
    public PedidoBO getBO() {
        return pedidoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "cliente.nome, pedido.dataSolicitacao";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("pedido")
                .leftJoinFetch("pedido.cliente", "cliente");
    }

    @Override
    public void init() {
        itemAdd = new ItemPedido();

        itens = new ArrayList<ItemPedido>();

        if (getEntity().getId() != null) {
            itens = getDAO().getInitialized(getEntity().getItens());
        }
    }

    @Override
    public void save() {
        getEntity().setItens(itens);
        super.save();
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public ItemPedido getItemAdd() {
        return itemAdd;
    }

    public void setItemAdd(ItemPedido itemAdd) {
        this.itemAdd = itemAdd;
    }

    public void adicionar() {
        if (itemAdd.getTipoPessoa() != null) {
            if (!Utils.isNullOrEmpty(itemAdd.getCpfCnpjTitular())) {
                if (!Utils.isNullOrEmpty(itemAdd.getNomeTitular())) {
                    if (itemAdd.getTipoCertificado() != null) {
                        if (!itemJahAdicionado(itemAdd)) {
                            itens.add(itemAdd);
                            itemAdd = new ItemPedido();
                        } else {
                            if (itemAdd.getTipoPessoa() == TipoPessoa.FISICA) {
                                FacesMessageUtils.error("Titular com esse CPF já foi adicionado na lista!");
                            } else {
                                FacesMessageUtils.error("Titular com esse CNPJ já foi adicionado na lista!");
                            }
                        }
                    } else {
                        FacesMessageUtils.error("Tipo de Certificado é Obrigatório!");
                    }
                } else {
                    FacesMessageUtils.error("Nome do Titular é Obrigatório!");
                }
            } else {
                if (itemAdd.getTipoPessoa() == TipoPessoa.FISICA) {
                    FacesMessageUtils.error("CPF é Obrigatório!");
                } else {
                    FacesMessageUtils.error("CNPJ é Obrigatório!");
                }
            }
        } else {
            FacesMessageUtils.error("Tipo de Pessoa é Obrigatório!");
        }
    }

    public void remover(ItemPedido item) {
        if (item.isAtendido()) {
            FacesMessageUtils.error("Item com a situação atendido não pode ser removido!");
        } else {
            itens.remove(item);
        }
    }

    private boolean itemJahAdicionado(ItemPedido item) {
        for (ItemPedido iten : itens) {
            if (iten.equals(item)) {
                return true;
            }
        }
        return false;
    }

}
