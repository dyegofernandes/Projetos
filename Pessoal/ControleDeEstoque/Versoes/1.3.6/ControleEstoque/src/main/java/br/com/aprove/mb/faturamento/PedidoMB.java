package br.com.aprove.mb.faturamento;

import br.com.aprove.bo.cadastro.ProdutoBO;
import br.com.aprove.bo.faturamento.EstoqueBO;
import br.com.aprove.bo.faturamento.ItemPedidoBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.faturamento.PedidoBO;
import br.com.aprove.dao.cadastro.ProdutoDAO;
import br.com.aprove.dao.faturamento.EstoqueDAO;
import br.com.aprove.dao.faturamento.ItemPedidoDAO;
import br.com.aprove.dao.faturamento.PedidoDAO;
import br.com.aprove.modelo.cadastro.Produto;
import br.com.aprove.modelo.cadastro.enums.UnidadeDeMedida;
import br.com.aprove.modelo.controleacesso.Usuario;
import br.com.aprove.modelo.faturamento.Estoque;
import br.com.aprove.modelo.faturamento.ItemPedido;
import br.com.aprove.modelo.faturamento.Pedido;
import br.com.aprove.util.SessaoUtils;
import br.com.aprove.util.Utils;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.faces.utils.FacesUtils;
import com.xpert.persistence.exception.DeleteException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class PedidoMB extends AbstractBaseBean<Pedido> implements Serializable {

    @EJB
    private PedidoBO pedidoBO;

    @EJB
    private PedidoDAO pedidoDAO;

    @EJB
    private EstoqueBO estoqueBO;

    @EJB
    private ItemPedidoBO itemPedidoBO;

    @EJB
    private ProdutoBO produtoBO;

    private ItemPedido itemPedido;

    public Utils util = new Utils();

    private Usuario usuarioAtual;

    private Produto produtoTela;

    private boolean renderCampo = false;

    public List<ItemPedido> itensPedido;

    public List<ItemPedido> itensPedidoRemovidos = new ArrayList<ItemPedido>();

    private List<UnidadeDeMedida> listUnidade;

    private BigDecimal totalMercadoria = BigDecimal.ZERO;

    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/faturamento/pedido/listPedido.jsf");
        } else {
            setEntity(new Pedido());
        }
    }

    public void setRenderCampo(boolean renderCampo) {
        this.renderCampo = renderCampo;
    }

    @Override
    public PedidoBO getBO() {
        return pedidoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        itemPedido = new ItemPedido();
        usuarioAtual = SessaoUtils.getUser();
        setarEmpresa(usuarioAtual);
        if (getEntity().getId() != null) {
            itensPedido = getBO().getDAO().getInitialized(getEntity().getItensPedido());
        } else {
            itensPedido = new ArrayList<ItemPedido>();
        }

    }

    public void getUnidadePedido() {
        if (produtoTela != null) {
            listUnidade = util.unidadesProduto(produtoTela);
        } else {
            listUnidade = new ArrayList<UnidadeDeMedida>();
        }
    }

    public void addItemLista() {
//        ItemPedido item = new ItemPedido();

        if (produtoTela != null) {
            if (verificaItemExistente(produtoTela)) {
                FacesMessageUtils.error("O produto " + produtoTela.getDescricao() + " já foi adicionado! Escolha outro produto!");
            } else {

                if (itemPedido.getUnidadeDeVenda() == null) {
                    FacesMessageUtils.error("Unidade de Venda é obrigatória!");
                }

                if (itemPedido.getMarca() != null) {
                    if (itemPedido.getMarca().equals("")) {
                        FacesMessageUtils.error("Marca é obrigatória!");
                    }
                } else {
                    FacesMessageUtils.error("Marca é obrigatória!");
                }

                if (itemPedido.getQtd() != null) {
                    if (itemPedido.getQtd().compareTo(BigDecimal.ZERO) == 0) {
                        FacesMessageUtils.error("Quantidade deve ser maior que Zero!");
                    }
                } else {
                    FacesMessageUtils.error("Quantidade é obrigatória!");
                }

                if (itemPedido.getPorcentagemDesconto() == null) {
                    itemPedido.setPorcentagemDesconto(BigDecimal.ZERO);
                }

                if (itemPedido.getValorUnitario() != null) {
                    if (itemPedido.getValorUnitario().compareTo(BigDecimal.ZERO) == 0) {
                        FacesMessageUtils.error("O Valor deve ser maior que Zero!");
                    }
                } else {
                    FacesMessageUtils.error("Valor Unitário é obrigatório!");
                }

                itemPedido.setProduto(produtoTela);

                totalMercadoria = totalMercadoria.add(itemPedido.getValorTotal());

                itensPedido.add(itemPedido); // add item na lista

                itemPedido = new ItemPedido();
            }

        } else {
            FacesMessageUtils.error("Produto é obrigatório!");
        }

    }

    public void removerItemLista(ItemPedido item) throws DeleteException {
        if (item.getId() != null) {
            itensPedidoRemovidos.add(item);
        } else {
            itensPedidoRemovidos.remove(item);
        }

        totalMercadoria = totalMercadoria.subtract(item.getValorTotal());

    }

    private boolean verificaItemExistente(Produto produto) {
        for (ItemPedido item : itensPedido) {
            Produto produtoItem = pedidoBO.getDAO().getInitialized(item.getProduto());
            if (produtoItem.equals(produto)) {
                return true;
            }
        }
        return false;
    }

    public Produto getProdutoTela() {
        return produtoTela;
    }

    public void setProdutoTela(Produto produtoTela) {
        this.produtoTela = produtoTela;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public BigDecimal getValorTotalProdutos() {
        BigDecimal valor = BigDecimal.ZERO;

        for (ItemPedido item : itensPedido) {
            if (item.getValorUnitario() != null && item.getQtd() != null) {
                valor = valor.add(item.getValorTotal());
            }
        }

        return valor;
    }

    public BigDecimal getValorDaNota() {
        BigDecimal valor = BigDecimal.ZERO;
        if (getEntity().getPorcentagemDesconto() != null) {
            valor = valor.subtract(util.calcularPorcentagem(getEntity().getPorcentagemDesconto(), getValorTotalProdutos()));
        }
        if (getEntity().getValorDoFrete() != null) {
            valor = valor.add(getEntity().getValorDoFrete());
        }

        return valor.add(getValorTotalProdutos());
    }

    public BigDecimal getTotalDescontoItens() {
        BigDecimal valor = BigDecimal.ZERO;
        for (ItemPedido item : itensPedido) {
            if (item.getPorcentagemDesconto() != null && item.getValorTotal() != null) {
                valor = valor.add(util.calcularPorcentagem(item.getPorcentagemDesconto(), item.getValorTotal()));
            }
        }
        return valor;
    }

    @Override
    public void save() {
        super.save();
    }

    public void confirmarPedido(Pedido pedido) throws BusinessException {

        itensPedido = itemPedidoBO.itensPorPedido(pedido);

        for (ItemPedido item : itensPedido) {
            Estoque estoque = new Estoque();
            estoque.setCodigo(item.getCodigo());
            estoque.setDataFabricacao(item.getDataFabricacao());
            estoque.setDataValidade(item.getDataValidade());
            estoque.setEmpresa(getEntity().getLoja());
            estoque.setFornecedor(getEntity().getFornecedor());
            estoque.setMarca(item.getMarca());
            estoque.setProduto(item.getProduto());
            estoque.setQtdMinima(BigDecimal.ZERO);
            estoque.setUnidade(util.unidadeEstoque(pedidoBO.getDAO().getInitialized(item.getProduto()).getUnidadeDeVenda()));
            estoque.setQuantidade(util.calculaQtdParaEstoque(item.getProduto(), item.getQtd()));

            estoqueBO.getDAO().saveOrMerge(estoque);
        }

        pedido.setConfirmado(true);
        pedidoDAO.saveOrMerge(pedido);

        FacesMessageUtils.info("Pedido confirmada com sucesso!");

    }

    public boolean verificarCampoFracao() {
        return (itemPedido.getUnidadeDeVenda() == UnidadeDeMedida.KG || itemPedido.getUnidadeDeVenda() == UnidadeDeMedida.L
                || itemPedido.getUnidadeDeVenda() == UnidadeDeMedida.T || itemPedido.getUnidadeDeVenda() == UnidadeDeMedida.M2
                || itemPedido.getUnidadeDeVenda() == UnidadeDeMedida.M3);
    }

    public List<UnidadeDeMedida> getListUnidade() {
        return listUnidade;
    }

    public void setListUnidade(List<UnidadeDeMedida> listUnidade) {
        this.listUnidade = listUnidade;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public List<ItemPedido> getItensPedidoRemovidos() {
        return itensPedidoRemovidos;
    }

    public void setItensPedidoRemovidos(List<ItemPedido> itensPedidoRemovidos) {
        this.itensPedidoRemovidos = itensPedidoRemovidos;
    }

    private void setarEmpresa(Usuario usuario) {
        if (!usuario.isSuperUsuario()) {
            if (usuario.getFilial() != null) {
                getEntity().setLoja(usuario.getFilial());
            } else {
                getEntity().setLoja(usuario.getMatriz());
            }

        }
    }

}
