package br.gov.pi.ati.sccd.bo.certificado;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.certificado.PedidoDAO;
import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.certificado.Pedido;
import br.gov.pi.ati.sccd.util.Utils;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;

/**
 *
 * @author Juniel
 */
@Stateless
public class PedidoBO extends AbstractBusinessObject<Pedido> {

    @EJB
    private PedidoDAO pedidoDAO;

    @Override
    public PedidoDAO getDAO() {
        return pedidoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
//        return new UniqueFields().add("protocolo");
    }

    @Override
    public void validate(Pedido pedido) throws BusinessException {
        List<ItemPedido> itens = getDAO().getInitialized(pedido.getItens());

        if (itens.size() < 1) {
            throw new BusinessException("Um ou mais Itens são obrigatórios!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public List<Pedido> pedidosPeloCliente(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        return getDAO().getQueryBuilder().from(Pedido.class, "pedido").leftJoinFetch("pedido.cliente", "cliente").add("cliente", cliente)
                .orderBy("cliente.nome").getResultList();
    }

    public List<ItemPedido> itensPedidoSituacao(Pedido pedido, Boolean situacao) {

        if (pedido == null) {
            return null;
        }

        List<ItemPedido> itensDoPedido = getDAO().getInitialized(pedido.getItens());

        List<ItemPedido> itens = new ArrayList<ItemPedido>();

        for (ItemPedido item : itensDoPedido) {

            if (situacao == null) {
                itens.add(item);
            } else {
                if (item.isAtendido() == situacao) {
                    itens.add(item);
                }
            }

        }
        return (List<ItemPedido>) itens;
    }

    public Pedido pedidoPeloCNPJouCpfEPedido(String pedidoID, String cnpjCpf) {
        Restrictions restrictions = new Restrictions();

        if (Utils.isNullOrEmpty(cnpjCpf) || Utils.isNullOrEmpty(pedidoID)) {
            return null;
        } else {
            restrictions.add("pedido.id", new Long(pedidoID));
            restrictions.add("item.cpfCnpjTitular", cnpjCpf);
        }

        return (Pedido) getDAO().getQueryBuilder().select("pedido").from(Pedido.class, "pedido").leftJoinFetch("pedido.itens", "item").add(restrictions).getSingleResult();

    }

    public Pedido pedidoPeloProtocolo(String protocolo) {
        Restrictions restrictions = new Restrictions();

        if (Utils.isNullOrEmpty(protocolo)) {
            return null;
        } else {
            restrictions.add("REPLACE(REPLACE(pedido.protocolo,'/',''),'.','')", protocolo);
        }

        return (Pedido) getDAO().getQueryBuilder().select("pedido").from(Pedido.class, "pedido").add(restrictions).getSingleResult();

    }

    public List<Pedido> pedidoPeloProtocoloECliente(Cliente cliente, String protocolo) {
        Restrictions restrictions = new Restrictions();

        if (cliente == null) {
            return null;
        }

        restrictions.add("cliente", cliente);

        if (!Utils.isNullOrEmpty(protocolo)) {
            restrictions.like("REPLACE(REPLACE(pedido.protocolo,'/',''),'.','')", protocolo);
        }

        return getDAO().getQueryBuilder().select("pedido").from(Pedido.class, "pedido")
                .leftJoinFetch("pedido.cliente", "cliente").add(restrictions).getResultList();

    }

}
