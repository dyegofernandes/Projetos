package br.gov.pi.ati.sccd.mb.certificado;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.CertificadoBO;
import br.gov.pi.ati.sccd.bo.certificado.ItemPedidoBO;
import br.gov.pi.ati.sccd.bo.certificado.PedidoBO;
import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
import br.gov.pi.ati.sccd.modelo.certificado.Certificado;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoCliente;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;
import br.gov.pi.ati.sccd.modelo.certificado.Pedido;
import br.gov.pi.ati.sccd.modelo.enums.SituacaoPedido;
import br.gov.pi.ati.sccd.modelo.enums.TipoPessoa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CertificadoMB extends AbstractBaseBean<Certificado> implements Serializable {

    @EJB
    private CertificadoBO certificadoBO;

    @EJB
    private PedidoBO pedidoBO;

    @EJB
    private ItemPedidoBO itemBO;

    private List<Pedido> pedidos;

    private List<ItemPedido> itensPedido;

    @Override
    public CertificadoBO getBO() {
        return certificadoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        pedidos = new ArrayList<Pedido>();
        itensPedido = new ArrayList<ItemPedido>();

        if (getEntity().getCliente() != null) {
            ContratoCliente contratoCliente = getDAO().getInitialized(getEntity().getCliente());

            if (contratoCliente != null) {
                Cliente cliente = getDAO().getInitialized(contratoCliente.getCliente());

                pedidos = pedidoBO.pedidosPeloCliente(cliente);
            }
        }

        if (getEntity().getPedido() != null) {
            Pedido pedido = getDAO().getInitialized(getEntity().getPedido());

            if (pedido != null) {
                itensPedido = pedidoBO.itensPedidoSituacao(pedido, false);
            }

        }
    }

    @Override
    public void postSave() {

        ItemPedido item = getDAO().getInitialized(getEntity().getTitular());
        item.setAtendido(true);
        itemBO.getDAO().saveOrMerge(item, true);

        Pedido pedido = getDAO().getInitialized(getEntity().getPedido());

        List<ItemPedido> itens = getDAO().getInitialized(pedido.getItens());

        int contador = 0;

        for (ItemPedido iten : itens) {
            if (iten.isAtendido()) {
                contador++;
            }
        }

        if (itens.size() == contador) {
            pedido.setSituacao(SituacaoPedido.ATENDIDO);
        } else {
            pedido.setSituacao(SituacaoPedido.PARCIALMENTE_ATENDIDO);
        }

        pedidoBO.getDAO().saveOrMerge(pedido, true);

        super.postSave();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public boolean verificarSeEhPJ() {
        ItemPedido titular = getDAO().getInitialized(getEntity().getTitular());
        if (titular != null) {
            if (titular.getTipoPessoa() == TipoPessoa.JURIDICA) {
                return true;
            }
        }

        return false;
    }

    public void pegarPedidos() {

        pedidos = new ArrayList<Pedido>();
        itensPedido = new ArrayList<ItemPedido>();
        getEntity().setPedido(null);
        getEntity().setTitular(null);

        if (getEntity().getCliente() != null) {
            ContratoCliente contratoCliente = getDAO().getInitialized(getEntity().getCliente());

            if (contratoCliente != null) {
                Cliente cliente = getDAO().getInitialized(contratoCliente.getCliente());

                pedidos = pedidoBO.pedidosPeloCliente(cliente);
            }
        }
    }

    public void pegarTitulares() {
        getEntity().setTitular(null);
        itensPedido = new ArrayList<ItemPedido>();

        if (getEntity().getPedido() != null) {
            Pedido pedido = getDAO().getInitialized(getEntity().getPedido());

            if (pedido != null) {
                itensPedido = pedidoBO.itensPedidoSituacao(pedido, false);
            }
        }

    }

}
