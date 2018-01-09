package br.com.aprove.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.aprove.dao.cadastro.ProdutoDAO;
import br.com.aprove.dao.faturamento.EstoqueDAO;
import br.com.aprove.modelo.cadastro.Loja_Filial;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.aprove.modelo.cadastro.Produto;
import br.com.aprove.modelo.controleacesso.Usuario;
import br.com.aprove.vo.FiltroVO;
import com.xpert.core.validation.UniqueFields;
import com.xpert.persistence.query.Restrictions;
import java.util.ArrayList;

/**
 *
 * @author juniel
 */
@Stateless
public class ProdutoBO extends AbstractBusinessObject<Produto> {

    @EJB
    private ProdutoDAO produtoDAO;

    @EJB
    private EstoqueDAO estoqueDAO;

    @Override
    public ProdutoDAO getDAO() {
        return produtoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa", "descricao", "unidadeDeVenda", "unidadeDeFracao", "qtdFracoes");
    }

    @Override
    public void validate(Produto produto) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

  //  @Override
    //   public void save(Produto produto) throws BusinessException {
//        boolean novo = produto.getId() == null;
//        Estoque estoque = new Estoque();
//        estoque.setEmpresa(produto.getEmpresa());
//        estoque.setProduto(produto);
//        estoque.setAtivo(true);
//        estoque.setQtdMinima(BigDecimal.ZERO);
//        estoque.setQuantidade(BigDecimal.ZERO);
//
//        if (produto.isProdutoFracionado()) {
//            estoque.setUnidadeDeVenda(produto.getUnidadeDeFracao());
//        } else {
//            estoque.setUnidadeDeVenda(produto.getUnidadeDeVenda());
//        }
//
//        validate(produto);
//        if (produto.getCodigoDeBarra() != null && produto.getCodigoDeBarra().isEmpty() && !produto.getCodigoDeBarra().equals("")) {
//            validateUniqueFields(produto);
//        }
//        if (!EntityUtils.isPersisted(produto)) {
//            getDAO().save(produto, isAudit());
//            if (novo) {
//                estoqueDAO.saveOrMerge(estoque);
//            }
//        } else {
//            getDAO().merge(produto, isAudit());
//            if (novo) {
//                estoqueDAO.saveOrMerge(estoque);
//            }
//        }
//    }
    public List<Produto> listarProdutos(FiltroVO filtros) {
        List<Produto> produtos = null;
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

        if (filtros.getLojas().size() > 0) {
            restrictions.in("empresa", filtros.getLojas());
        }

        if (filtros.getDescricao() != null && !filtros.getDescricao().equals("")) {
            restrictions.like("produto.descricao", filtros.getDescricao());
        }

        //id ou codigo do produto
        if (filtros.getCodigo1() != null) {
            restrictions.add("produto.id", filtros.getCodigo1());
        }

        //codigo de barras
        if (filtros.getCodigo2() != null && !filtros.getCodigo2().equals("")) {
            restrictions.add("produto.codigoDeBarra", filtros.getCodigo2());
        }

        if (filtros.getFabricante() != null && !filtros.getFabricante().equals("")) {
            restrictions.like("produto.fabricante.razaoSocial", filtros.getFabricante());
        }

        if (filtros.getMarca() != null && !filtros.getMarca().equals("")) {
            restrictions.like("produto.marca", filtros.getMarca());
        }

        if (filtros.getAtivo() == null) {
            List<Boolean> lista = new ArrayList<Boolean>();
            lista.add(Boolean.TRUE);
            lista.add(Boolean.FALSE);
            restrictions.in("produto.ativo", lista);
        } else {
            restrictions.add("produto.ativo", filtros.getAtivo());
        }

        produtos = getDAO().getQueryBuilder().select("produto").from(Produto.class, "produto").leftJoinFetch("produto.empresa", "empresa")
                .leftJoinFetch("produto.fabricante", "fabricante").leftJoinFetch("produto.secao", "secao").leftJoinFetch("produto.grupo", "grupo")
                .add(restrictions).orderBy("empresa, produto.descricao").getResultList();
        return produtos;
    }

}
