package br.gov.pi.ati.sisforms.mb.formulario;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.FormCriacaoEmailBO;
import br.gov.pi.ati.sisforms.bo.formulario.ItemFormCriacaoEmailBO;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.formulario.FormCriacaoEmail;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemFormCriacaoEmail;
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
public class FormCriacaoEmailMB extends AbstractBaseBean<FormCriacaoEmail> implements Serializable {

    @EJB
    private FormCriacaoEmailBO formCriacaoEmailBO;

    @EJB
    private ItemFormCriacaoEmailBO itemBO;
    
    private List<FormCriacaoEmail> lista = new ArrayList<FormCriacaoEmail>();

    private List<ItemFormCriacaoEmail> itens = new ArrayList<ItemFormCriacaoEmail>();

    private List<ItemFormCriacaoEmail> itensDeletados = new ArrayList<ItemFormCriacaoEmail>();

    private String nomeCompleto = "";

    private String cpf = "";

    private String rg = "";

    private String endereco = "";

    private String telefone = "";

    private String emailPessoal = "";

    private String matriculaEstado = "";

    private String cargo = "";

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private FiltrosVO filtros = new FiltrosVO();

    @Override
    public void init() {

        if (!usuarioAtual.isSuperUsuario()) {
            filtros.setUsuario(usuarioAtual);
        }

        buscar();

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
            for (ItemFormCriacaoEmail iten : itens) {
                itemBO.getDAO().saveOrMerge(iten, true);
            }
            for (ItemFormCriacaoEmail iten : itensDeletados) {
                try {
                    itemBO.getDAO().remove(iten, true);
                } catch (DeleteException ex) {
                    Logger.getLogger(FormCriacaoEmailMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            FacesMessageUtils.error("Itens de Emails obrigatório!");
        }
    }

    @Override
    public FormCriacaoEmailBO getBO() {
        return formCriacaoEmailBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void gerarPdf(FormCriacaoEmail form) {
        HashMap params = new HashMap();
        String imgLogoPI = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/logo.png");
        String imgLogoAti = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images/ati_novo.png");

        params.put("LOGO_PI", imgLogoPI);
        params.put("LOGO_ATI", imgLogoAti);
        params.put("ORGAO", formCriacaoEmailBO.getDAO().getInitialized(form.getOrgao()).getNome());
        params.put("DATA_EMISSAO", Utils.convertDateToString(form.getDataCriacao(), "dd/MM/yyyy"));
        carregarItens(form);

        FacesJasper.createJasperReport(itens, params,
                "/WEB-INF/report/formulario/formularioCriacaoEmail.jasper", "Formulario de Criacao de Email" + ".pdf");

    }

    public void addItem() {
        if (nomeCompleto.equals("")) {
            FacesMessageUtils.error("Nome completo é obrigatório!");
        } else {
            if (cpf.equals("")) {
                FacesMessageUtils.error("CPF é obrigatório!");
            } else {
                if (telefone.equals("")) {
                    FacesMessageUtils.error("Telefone é obrigatório!");
                } else {
                    if (emailPessoal.equals("")) {
                        FacesMessageUtils.error("Email é Obrigatório!");
                    } else {
                        ItemFormCriacaoEmail item = new ItemFormCriacaoEmail();
                        item.setCargo(cargo);
                        item.setCpf(cpf);
                        item.setEmailPessoal(emailPessoal);
                        item.setEndereco(endereco);
                        item.setFormCriacaoEmail(getEntity());
                        item.setMatriculaEstado(matriculaEstado);
                        item.setNomeCompleto(nomeCompleto);
                        item.setRg(rg);
                        item.setTelefone(telefone);
                        itens.add(item);
                        item = new ItemFormCriacaoEmail();
                        cargo = "";
                        cpf = "";
                        emailPessoal = "";
                        endereco = "";
                        matriculaEstado = "";
                        nomeCompleto = "";
                        rg = "";
                        telefone = "";
                    }
                }
            }
        }

    }

    public void removerItem(ItemFormCriacaoEmail item) {
        if (item.getId() != null) {
            itensDeletados.add(item);
        }

        itens.remove(item);
    }

    public FormCriacaoEmailBO getFormCriacaoEmailBO() {
        return formCriacaoEmailBO;
    }

    public void setFormCriacaoEmailBO(FormCriacaoEmailBO formCriacaoEmailBO) {
        this.formCriacaoEmailBO = formCriacaoEmailBO;
    }

    public List<ItemFormCriacaoEmail> getItens() {
        return itens;
    }

    public void setItens(List<ItemFormCriacaoEmail> itens) {
        this.itens = itens;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmailPessoal() {
        return emailPessoal;
    }

    public void setEmailPessoal(String emailPessoal) {
        this.emailPessoal = emailPessoal;
    }

    public String getMatriculaEstado() {
        return matriculaEstado;
    }

    public void setMatriculaEstado(String matriculaEstado) {
        this.matriculaEstado = matriculaEstado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void carregarItens(FormCriacaoEmail entity) {
        itens = itemBO.getDAO().list("formCriacaoEmail", entity, "nomeCompleto");
    }

    public List<FormCriacaoEmail> getLista() {
        return lista;
    }

    public void setLista(List<FormCriacaoEmail> lista) {
        this.lista = lista;
    }

    public FiltrosVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosVO filtros) {
        this.filtros = filtros;
    }
    
    public void buscar() {
        lista = getBO().listar(filtros);
    }

}
