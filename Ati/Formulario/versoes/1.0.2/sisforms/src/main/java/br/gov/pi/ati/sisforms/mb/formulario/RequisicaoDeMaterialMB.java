package br.gov.pi.ati.sisforms.mb.formulario;

import br.gov.pi.ati.sisforms.bo.formulario.ItemDaRequisicaoDeMaterialBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.RequisicaoDeMaterialBO;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemDaRequisicaoDeMaterial;
import br.gov.pi.ati.sisforms.modelo.formulario.RequisicaoDeMaterial;
import br.gov.pi.ati.sisforms.util.SessaoUtils;
import br.gov.pi.ati.sisforms.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class RequisicaoDeMaterialMB extends AbstractBaseBean<RequisicaoDeMaterial> implements Serializable {

    @EJB
    private RequisicaoDeMaterialBO requisicaoDeMaterialBO;

    @EJB
    private ItemDaRequisicaoDeMaterialBO itemBO;

    private String discriminacao = null;

    private BigDecimal quantidade = null;

    private BigDecimal valor = null;

    private List<ItemDaRequisicaoDeMaterial> itens;

    private List<ItemDaRequisicaoDeMaterial> itensDeletados;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    public String getDiscriminacao() {
        return discriminacao;
    }

    public void setDiscriminacao(String discriminacao) {
        this.discriminacao = discriminacao;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public RequisicaoDeMaterialBO getBO() {
        return requisicaoDeMaterialBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void save() {
        if (itens.size() > 0) {
            super.save();
            for (ItemDaRequisicaoDeMaterial iten : itens) {
                itemBO.getDAO().saveOrMerge(iten, true);
            }
            for (ItemDaRequisicaoDeMaterial iten : itensDeletados) {
                try {
                    itemBO.getDAO().remove(iten, true);
                } catch (DeleteException ex) {
                    Logger.getLogger(RequisicaoDeMaterialMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            FacesMessageUtils.error("Na requisição é necessário ao menos um item!");
        }
    }

    @Override
    public void delete() {
        List<ItemDaRequisicaoDeMaterial> itensDel = itemBO.getDAO().list("requisicaoDeMaterial.id", getId());
        for (ItemDaRequisicaoDeMaterial itensDel1 : itensDel) {
            try {
                itemBO.getDAO().remove(itensDel1);
            } catch (DeleteException ex) {
                Logger.getLogger(RequisicaoDeMaterialMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        super.delete();
    }

    @Override
    public void init() {

        if (getEntity().getId() == null) {
            getEntity().setUsuario(usuarioAtual);
        }

        itensDeletados = new ArrayList<ItemDaRequisicaoDeMaterial>();

        itens = new ArrayList<ItemDaRequisicaoDeMaterial>();

        listarItens();
    }

    public List<ItemDaRequisicaoDeMaterial> getItens() {
        return itens;
    }

    public void addItem() {
        if (discriminacao != null) {
            if (quantidade != null) {
                ItemDaRequisicaoDeMaterial item = new ItemDaRequisicaoDeMaterial();
                item.setDiscriminacao(discriminacao);
                item.setQuantidade(quantidade);
                item.setValor(valor);
                item.setRequisicaoDeMaterial(getEntity());
                itens.add(item);
                discriminacao = null;
                quantidade = null;
                valor = null;
            } else {
                FacesMessageUtils.error("Quantidade é Obrigatória!");
            }

        } else {
            FacesMessageUtils.error("Discriminação é Obrigatória!");
        }

    }

    public void removerItem(ItemDaRequisicaoDeMaterial item) {
        if (item.getId() != null) {
            itensDeletados.add(item);
        }

        itens.remove(item);
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (ItemDaRequisicaoDeMaterial iten : itens) {
            if (iten.getTotalPorItem() != null) {
                total = total.add(iten.getTotalPorItem());
            }
        }

        return total;
    }

    public void listarItens() {
        if (getEntity().getId() != null) {
            itens = itemBO.listarItensPorRequisicao(getEntity());
        }
    }

    public void gerarPdf(RequisicaoDeMaterial requisicao) {
        HashMap params = new HashMap();
        List<ItemDaRequisicaoDeMaterial> itensTemp = new ArrayList<ItemDaRequisicaoDeMaterial>();
        itensTemp = itemBO.listarItensPorRequisicao(requisicao);

        String imgLogoAti = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/ati_novo.png");

        params.put("CAMINHO_LOGO", imgLogoAti);
        params.put("GERENCIA", requisicao.getGerencia());
        params.put("COORDENADORIA", requisicao.getCoordenadoria());
        params.put("DATA_EMISSAO", Utils.convertDateToString(requisicao.getDataDaEmissao(), "dd/MM/yyyy"));
        params.put("REQUISITADO_POR", requisicao.getRequisitadoPor());
        params.put("AUTORIZADO_POR", requisicao.getAutorizadoPor());
        params.put("VISTO", requisicao.getVisto());
        params.put("ATENDIDO", requisicao.getAtendido() != null ? "ATENDIDO EM " + Utils.convertDateToString(requisicao.getAtendido(), "dd/MM/yyyy")
                : "ATENDIDO EM ___/___/_____");

        FacesJasper.createJasperReport(itensTemp, params,
                "/WEB-INF/report/formulario/requisicaoDeMaterial.jasper", "RequisicaoDeMaterial" + ".pdf");
    }
}
