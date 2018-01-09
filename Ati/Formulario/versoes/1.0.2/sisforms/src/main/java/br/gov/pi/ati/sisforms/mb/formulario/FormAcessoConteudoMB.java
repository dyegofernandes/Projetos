package br.gov.pi.ati.sisforms.mb.formulario;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.FormAcessoConteudoBO;
import br.gov.pi.ati.sisforms.bo.formulario.ItemFormAcessoConteudoBO;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.formulario.FormAcessoConteudo;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemFormAcessoConteudo;
import br.gov.pi.ati.sisforms.modelo.vos.FiltrosVO;
import br.gov.pi.ati.sisforms.util.SessaoUtils;
import br.gov.pi.ati.sisforms.util.Utils;
import com.xpert.faces.utils.FacesJasper;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
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
public class FormAcessoConteudoMB extends AbstractBaseBean<FormAcessoConteudo> implements Serializable {

    @EJB
    private FormAcessoConteudoBO formAcessoConteudoBO;

    @EJB
    private ItemFormAcessoConteudoBO itemBO;

    private List<FormAcessoConteudo> acessos = new ArrayList<FormAcessoConteudo>();

    private List<ItemFormAcessoConteudo> itens;
    private List<ItemFormAcessoConteudo> itensDeletados;

    private String siteAserLiberado = "";

    private String descricaoLiberacao = "";

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private FiltrosVO filtros = new FiltrosVO();

    @Override
    public void init() {

        if (!usuarioAtual.isSuperUsuario()) {
            filtros.setUsuario(usuarioAtual);
        }
        buscar();
        itens = new ArrayList<ItemFormAcessoConteudo>();
        itensDeletados = new ArrayList<ItemFormAcessoConteudo>();
        if (getEntity().getId() == null) {
            getEntity().setUsuario(usuarioAtual);
        } else {
            carregarItens(getEntity());
        }
    }

    @Override
    public void save() {
        if (itens.size() > 0) {
            super.save();
            for (ItemFormAcessoConteudo iten : itens) {
                itemBO.getDAO().saveOrMerge(iten, true);
            }
            for (ItemFormAcessoConteudo iten : itensDeletados) {
                try {
                    itemBO.getDAO().remove(iten, true);
                } catch (DeleteException ex) {
                    Logger.getLogger(FormAcessoConteudoMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            FacesMessageUtils.error("Site (s) é (são) obrigatório (s)!");
        }

    }

    @Override
    public FormAcessoConteudoBO getBO() {
        return formAcessoConteudoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void gerarPdf(FormAcessoConteudo form) {
        HashMap params = new HashMap();
        String imgLogoPI = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/logo.png");
        String imgLogoAti = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/ati_novo.png");
        String subReport_dir = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/WEB-INF/report/formulario/");

        params.put("LOGO_PI", imgLogoPI);
        params.put("LOGO_ATI", imgLogoAti);
        params.put("ORGAO", formAcessoConteudoBO.getDAO().getInitialized(form.getOrgao()).getNome());
        params.put("DATA_EMISSAO", Utils.convertDateToString(form.getDataCriacao(), 1));
        carregarItens(form);
        params.put("NOME_COMPLETO", form.getNomeCompleto());
        params.put("MATRICULA", form.getMatriculaEstado());
        params.put("CARGO", form.getCargo());
        params.put("TELFONE", form.getTelefone());
        params.put("EMAIL", form.getEmailCoorporativo());
        params.put("SITES", itens);
        params.put("SUBREPORT_DIR", subReport_dir);

        FacesJasper.createJasperReport(null, params,
                "/WEB-INF/report/formulario/formularioAcessoConteudo.jasper", "Formulario de Acesso Conteudo" + ".pdf");

    }

    public void carregarItens(FormAcessoConteudo entity) {
        itens = itemBO.getDAO().list("formAcessoConteudo", entity, "siteAserLiberado");
    }

    public void addItem() {
        if (siteAserLiberado.equals("")) {
            FacesMessageUtils.error("Site a ser liberador é Obrigatório!");
        } else {
            if (descricaoLiberacao.equals("")) {
                FacesMessageUtils.error("Descrição do Motivo da Liberação!");
            } else {
                ItemFormAcessoConteudo item = new ItemFormAcessoConteudo();
                item.setDescricaoLiberacao(descricaoLiberacao);
                item.setSiteAserLiberado(siteAserLiberado);
                item.setFormAcessoConteudo(getEntity());
                itens.add(item);
                descricaoLiberacao = "";
                siteAserLiberado = "";
            }
        }
    }

    public void removerItem(ItemFormAcessoConteudo entity) {
        if (entity.getId() != null) {
            itensDeletados.add(entity);
        }

        itens.remove(entity);
    }

    public String getSiteAserLiberado() {
        return siteAserLiberado;
    }

    public void setSiteAserLiberado(String siteAserLiberado) {
        this.siteAserLiberado = siteAserLiberado;
    }

    public String getDescricaoLiberacao() {
        return descricaoLiberacao;
    }

    public void setDescricaoLiberacao(String descricaoLiberacao) {
        this.descricaoLiberacao = descricaoLiberacao;
    }

    public List<ItemFormAcessoConteudo> getItens() {
        return itens;
    }

    public void setItens(List<ItemFormAcessoConteudo> itens) {
        this.itens = itens;
    }

    public List<FormAcessoConteudo> getAcessos() {
        return acessos;
    }

    public void setAcessos(List<FormAcessoConteudo> acessos) {
        this.acessos = acessos;
    }

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }

    public void buscar() {
        acessos = getBO().listar(filtros);
    }

}
