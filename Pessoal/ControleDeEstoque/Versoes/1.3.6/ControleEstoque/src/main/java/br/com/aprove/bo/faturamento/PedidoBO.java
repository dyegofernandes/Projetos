package br.com.aprove.bo.faturamento;

import br.com.aprove.dao.cadastro.ProdutoDAO;
import br.com.aprove.dao.faturamento.EstoqueDAO;
import br.com.aprove.dao.faturamento.ItemPedidoDAO;
import com.xpert.core.crud.AbstractBusinessObject;
import br.com.aprove.dao.faturamento.PedidoDAO;
import br.com.aprove.modelo.cadastro.Cidade;
import br.com.aprove.modelo.cadastro.Estado;
import br.com.aprove.modelo.cadastro.Loja_Filial;
import br.com.aprove.modelo.cadastro.Produto;
import br.com.aprove.modelo.cadastro.enums.TipoPedido;
import br.com.aprove.modelo.cadastro.enums.UnidadeDeMedida;
import br.com.aprove.modelo.controleacesso.Usuario;
import br.com.aprove.modelo.faturamento.Estoque;
import br.com.aprove.modelo.faturamento.ItemPedido;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.aprove.modelo.faturamento.Pedido;
import br.com.aprove.vo.FiltroVO;
import br.com.aprove.vo.SolicitacaoPedidoVO;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.persistence.exception.DeleteException;
import com.xpert.persistence.query.Restrictions;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;

/**
 *
 * @author juniel
 */
@Stateless
public class PedidoBO extends AbstractBusinessObject<Pedido> {

    @EJB
    private PedidoDAO pedidoDAO;

    @EJB
    private ItemPedidoDAO itemDAO;

    @EJB
    private ItemPedidoBO itemBO;

    @EJB
    private EstoqueDAO estoqueDAO;

    @EJB
    private ProdutoDAO produtoDAO;

    @Override
    public PedidoDAO getDAO() {
        return pedidoDAO;
    }

    @Override
    public boolean isAudit() {
        return true;
    }

    public void gerarPedidoPdf(Pedido item) {
        List<ItemPedido> itemPedidos;
        SolicitacaoPedidoVO solicitacaoPedido;
        List<SolicitacaoPedidoVO> listaVO = new ArrayList<SolicitacaoPedidoVO>();

        itemPedidos = itemBO.itensPorPedido(item);
        Loja_Filial empresa = pedidoDAO.getInitialized(item.getLoja());
        Cidade cidade = pedidoDAO.getInitialized(empresa.getCidadeEndereco());
        Estado estado = pedidoDAO.getInitialized(cidade.getEstado());

        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String caminhoLogo;
        caminhoLogo = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/logo.png");
        HashMap params = new HashMap();
        params.put("cidadeCEP", cidade.getNome() + "-" + estado.getSigla() + ", " + dt.format(new Date()));
        params.put("caminhoImagem", caminhoLogo);
        params.put("rodaPe", empresa.getRazaoSocial() + ", " + empresa.getCnpj() + "\n" + empresa.getEndereco() + ", " + empresa.getNumero()
                + ", " + cidade.getNome() + "-" + estado.getSigla());
        params.put("valorTotal", item.getValorDaNota().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        params.put("valorDesconto", item.getPorcentagemDesconto() != null ? item.getPorcentagemDesconto().setScale(2, BigDecimal.ROUND_HALF_UP).toString() : BigDecimal.ZERO);

        int i = 1;
        for (ItemPedido itemVO : itemPedidos) {
            solicitacaoPedido = new SolicitacaoPedidoVO(i, itemVO);
            listaVO.add(solicitacaoPedido);
        }

        FacesJasper.createJasperReport(listaVO, params,
                "/WEB-INF/report/relatorios/pedidoCompra.jasper", "Solicitação_Pedido_Compra.pdf");

    }

    @Override
    public void delete(Object id) throws DeleteException {
        Pedido pedido = pedidoDAO.find(id);
        for (ItemPedido item : itemBO.itensPorPedido(pedido)) {
            itemDAO.delete(item.getId());
        }
        super.delete(id);

    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Pedido object) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Pedido> listarPedido(FiltroVO filtros){
        List<Pedido> pedidos = null;
        Usuario usuario = getDAO().getInitialized(filtros.getUsuario());
        Restrictions restrictions = new Restrictions();
        
        if (!usuario.isSuperUsuario()) {
            Loja_Filial empresa;
            if (usuario.getFilial() != null) {
                empresa = getDAO().getInitialized(usuario.getFilial());
                filtros.getLojas().add(empresa);
            } else {
                empresa = getDAO().getInitialized(usuario.getMatriz());
                filtros.getLojas().add(empresa);
            }
            restrictions.in("empresa", filtros.getLojas());
        } else {
            Loja_Filial empresa;
            if (filtros.getLoja() != null) {
                empresa = getDAO().getInitialized(filtros.getLoja());
                filtros.getLojas().add(empresa);
            } else {
                if (filtros.getMatriz() != null) {
                    empresa = getDAO().getInitialized(filtros.getMatriz());
                    filtros.getLojas().add(empresa);
                }
            }
        }
        
        return pedidos;
    }

}
