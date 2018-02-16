package br.com.weblicita.mb.licitacao;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.licitacao.HomolagacaoAtaAdjucaoBO;
import br.com.weblicita.bo.licitacao.PedidoLicitacaoBO;
import br.com.weblicita.modelo.cadastro.Fornecedor;
import br.com.weblicita.modelo.controleacesso.Usuario;
import br.com.weblicita.modelo.licitacao.HomolagacaoAtaAdjucao;
import br.com.weblicita.modelo.licitacao.PedidoLicitacao;
import br.com.weblicita.util.SessaoUtils;
import br.com.weblicita.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.xmlbeans.impl.inst2xsd.VenetianBlindStrategy;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class HomolagacaoAtaAdjucaoMB extends AbstractBaseBean<HomolagacaoAtaAdjucao> implements Serializable {

    @EJB
    private HomolagacaoAtaAdjucaoBO homolagacaoAtaAdjucaoBO;

    @EJB
    private PedidoLicitacaoBO pedidoBO;

    Usuario usuarioAtual = SessaoUtils.getUser();

    private Fornecedor vencedor;

    private List<Fornecedor> vencedores;

    private String processoAdministrativo = "";

    private boolean renderizarFormulario = false;

    @Override
    public HomolagacaoAtaAdjucaoBO getBO() {
        return homolagacaoAtaAdjucaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void buscar() {

        if (!Utils.isNullOrEmpty(processoAdministrativo)) {
            vencedor = new Fornecedor();
            vencedores = new ArrayList<Fornecedor>();
            PedidoLicitacao pedido = pedidoBO.pedidoPeloProcessoAdministrativo(processoAdministrativo);

            if (pedido != null) {
                renderizarFormulario = true;
                HomolagacaoAtaAdjucao hajTemp = getBO().homogacaoPeloPedidoLicitacao(pedido);
                if (hajTemp != null) {
                    setEntity(hajTemp);
                    vencedores = getDAO().getInitialized(hajTemp.getVencedores());
                } else {
                    setEntity(new HomolagacaoAtaAdjucao());
                    getEntity().setPedidoLicitacao(pedido);
                }
            } else {
                renderizarFormulario = false;
                FacesMessageUtils.error("Processo Administrativo não localizado!");
            }

        } else {
            renderizarFormulario = false;
            FacesMessageUtils.error("Informe o número/nome processo Administrativo!");
        }

    }

    public void gerarHomologacao() {
        if (getEntity().getId() != null) {
            getEntity().setUltimaGeracao(new Date());
            getEntity().setUsuario(usuarioAtual);
            getDAO().saveOrMerge(getEntity(), true);
        } else {
            FacesMessageUtils.error("Não pode ser gerado!");
        }
    }

    public void gerarAto() {
        if (getEntity().getId() != null) {
            getEntity().setUltimaGeracao(new Date());
            getEntity().setUsuario(usuarioAtual);
            getDAO().saveOrMerge(getEntity(), true);
        } else {
            FacesMessageUtils.error("Não pode ser gerado!");
        }
    }

    public void gerarAdjucacao() {
        if (getEntity().getId() != null) {
            getEntity().setUltimaGeracao(new Date());
            getEntity().setUsuario(usuarioAtual);
            getDAO().saveOrMerge(getEntity(), true);
        } else {
            FacesMessageUtils.error("Não pode ser gerado!");
        }
    }

    public void addVencendor() {
        if (vencedor != null) {
            if (vencedorJahAdicionado(vencedor)) {
                FacesMessageUtils.error("Vencedor já adicionado!");
            } else {
                vencedores.add(vencedor);
                vencedor = new Fornecedor();
            }
        } else {
            FacesMessageUtils.error("Vencedor é obrigatório!");
        }
    }

    private boolean vencedorJahAdicionado(Fornecedor vencedor) {
        for (Fornecedor vencedore : vencedores) {
            if (vencedore.equals(vencedor)) {
                return true;
            }
        }
        return false;
    }

    public void removerVencedor(Fornecedor vencedor) {
        vencedores.remove(vencedor);
    }

    public Fornecedor getVencedor() {
        return vencedor;
    }

    public void setVencedor(Fornecedor vencedor) {
        this.vencedor = vencedor;
    }

    public List<Fornecedor> getVencedores() {
        return vencedores;
    }

    public void setVencedores(List<Fornecedor> vencedores) {
        this.vencedores = vencedores;
    }

    public String getProcessoAdministrativo() {
        return processoAdministrativo;
    }

    public void setProcessoAdministrativo(String processoAdministrativo) {
        this.processoAdministrativo = processoAdministrativo;
    }

    public boolean isRenderizarFormulario() {
        return renderizarFormulario;
    }

    public void setRenderizarFormulario(boolean renderizarFormulario) {
        this.renderizarFormulario = renderizarFormulario;
    }

}
