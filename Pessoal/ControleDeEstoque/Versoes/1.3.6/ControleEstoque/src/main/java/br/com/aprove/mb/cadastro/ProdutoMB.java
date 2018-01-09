package br.com.aprove.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.cadastro.ProdutoBO;
import br.com.aprove.modelo.cadastro.Produto;
import br.com.aprove.modelo.controleacesso.Usuario;
import br.com.aprove.util.SessaoUtils;
import br.com.aprove.vo.FiltroVO;
import com.xpert.faces.utils.FacesUtils;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class ProdutoMB extends AbstractBaseBean<Produto> implements Serializable {

    @EJB
    private ProdutoBO produtoBO;

    private FiltroVO filtros;

    private List<Produto> produtos;

    private Usuario usuarioAtual;

    @Override
    public ProdutoBO getBO() {
        return produtoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "descricao";
    }

    @Override
    public void init() {
        filtros = new FiltroVO();

        usuarioAtual = SessaoUtils.getUser();

        setarEmpresa(usuarioAtual);

        filtros.setUsuario(usuarioAtual);

        produtos = produtoBO.listarProdutos(filtros);
    }

    private void setarEmpresa(Usuario usuario) {
        if (!usuario.isSuperUsuario()) {
            if (usuario.getFilial() != null) {
                getEntity().setEmpresa(usuario.getFilial());
            } else {
                getEntity().setEmpresa(usuario.getMatriz());
            }

        }
    }

    public void buscar() {
        produtos = produtoBO.listarProdutos(filtros);
    }

    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/produto/listProduto.jsf");
        } else {
            setEntity(new Produto());
        }
        filtros = new FiltroVO();
    }

    public FiltroVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltroVO filtros) {
        this.filtros = filtros;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
