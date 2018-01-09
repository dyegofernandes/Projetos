package br.gov.pi.ati.siopm.mb.cadastro;

import br.gov.pi.ati.siopm.bo.cadastro.OpmBO;
import br.gov.pi.ati.siopm.bo.cadastro.TerritorioBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.modelo.cadastro.Endereco;
import br.gov.pi.ati.siopm.modelo.cadastro.Telefone;
import br.gov.pi.ati.siopm.modelo.cadastro.Opm;
import br.gov.pi.ati.siopm.modelo.cadastro.Territorio;
import br.gov.pi.ati.siopm.modelo.controleacesso.Usuario;
import br.gov.pi.ati.siopm.modelo.enums.TipoTelefone;
import br.gov.pi.ati.siopm.modelo.vos.FiltrosVO;
import br.gov.pi.ati.siopm.util.SessaoUtils;
import br.gov.pi.ati.siopm.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.i18n.XpertResourceBundle;
import com.xpert.persistence.exception.DeleteException;
import com.xpert.persistence.query.JoinBuilder;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class OpmMB extends AbstractBaseBean<Opm> implements Serializable {

    @EJB
    private OpmBO opmBO;

    @EJB
    private TerritorioBO territorioBO;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private TipoTelefone tipoTelefone;

    private boolean emCascata;

    private TreeNode opms;

    private Territorio territorioAdd;

    private List<Territorio> territorios;

    private Telefone telefoneAdd;

    private List<Telefone> telefones;

    private Endereco endereco;

    private FiltrosVO filtrosOpm;
    private FiltrosVO filtrosBairro;

    @Override
    public void init() {

        filtrosOpm = new FiltrosVO();
        filtrosBairro = new FiltrosVO();

        filtrosOpm.setUsuario(usuarioAtual);
        telefoneAdd = new Telefone();
        telefones = new ArrayList<Telefone>();
        territorioAdd = new Territorio();
        territorios = new ArrayList<Territorio>();
        endereco = new Endereco();

        if (getEntity().getId() != null) {
            territorios = getBO().getDAO().getInitialized(getEntity().getTerritorios());
            telefones = getBO().getDAO().getInitialized(getEntity().getTelefones());
            endereco = getBO().getDAO().getInitialized(getEntity().getEndereco());
        }

        carregarTree();
    }

    @Override
    public OpmBO getBO() {
        return opmBO;
    }

    @Override
    public String getDataModelOrder() {
        return "opm.nome";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("opm")
                .leftJoinFetch("opm.endereco", "endereco");
    }

    @Override
    public void save() {
        getEntity().setEndereco(endereco);
        getEntity().setTerritorios(territorios);
        getEntity().setTelefones(telefones);
        super.save();
    }

    public FiltrosVO getFiltrosOpm() {
        return filtrosOpm;
    }

    public void setFiltrosOpm(FiltrosVO filtrosOpm) {
        this.filtrosOpm = filtrosOpm;
    }

    public FiltrosVO getFiltrosBairro() {
        return filtrosBairro;
    }

    public void setFiltrosBairro(FiltrosVO filtrosBairro) {
        this.filtrosBairro = filtrosBairro;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public boolean isEmCascata() {
        return emCascata;
    }

    public void setEmCascata(boolean emCascata) {
        this.emCascata = emCascata;
    }

    public TreeNode getOpms() {
        return opms;
    }

    public void setOpms(TreeNode opms) {
        this.opms = opms;
    }

    public Territorio getTerritorioAdd() {
        return territorioAdd;
    }

    public void setTerritorioAdd(Territorio territorioAdd) {
        this.territorioAdd = territorioAdd;
    }

    public List<Territorio> getTerritorios() {
        return territorios;
    }

    public void setTerritorios(List<Territorio> territorios) {
        this.territorios = territorios;
    }

    public Telefone getTelefoneAdd() {
        return telefoneAdd;
    }

    public void setTelefoneAdd(Telefone telefoneAdd) {
        this.telefoneAdd = telefoneAdd;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setarPai(Opm opm) {

        if (opm != null) {
            getEntity().setOrganizacaoPai(opm);
        }
    }

    public void addTerritorio() {
        if (territorioAdd != null) {
            if (territorioJahAdd(territorioAdd)) {
                FacesMessageUtils.error("Território já foi adicionado!");
            } else {
                territorios.add(territorioAdd);
                territorioAdd = new Territorio();
            }
        } else {
            FacesMessageUtils.error("Território é obrigatório!");
        }
    }

    public void removerTerritorio(Territorio territorio) {
        territorios.remove(territorio);
    }

    private boolean territorioJahAdd(Territorio territorio) {
        for (Territorio territorio1 : territorios) {
            if (territorio1.equals(territorio)) {
                return true;
            }
        }
        return false;
    }

    public void addTelefone() {
        if (Utils.isNullOrEmpty(telefoneAdd.getNumero())) {
            FacesMessageUtils.error("Número do Telefone é Obrigatório!");
        } else {
            if (telefoneJahAdd(telefoneAdd.getNumero())) {
                FacesMessageUtils.error("Número do Telefone já foi adicionado!");
            } else {
                telefones.add(telefoneAdd);
                telefoneAdd = new Telefone();
            }
        }
    }

    public void removerTelefone(Telefone telefone) {
        telefones.remove(telefone);
    }

    private boolean telefoneJahAdd(String numero) {
        for (Telefone telefone : telefones) {
            if (telefone.getNumero().equals(numero)) {
                return true;
            }
        }
        return false;
    }

    public void salvarOrdenacao() {
        opmBO.salvarOrdenacao(opms);
        carregarTree();
        FacesMessageUtils.sucess();
    }

    public void ativar() {
        opmBO.ativar(getEntity(), emCascata);
        carregarTree();
        FacesMessageUtils.sucess();
        emCascata = false;
    }

    public void inativar() {
        opmBO.inativar(getEntity(), emCascata);
        carregarTree();
        FacesMessageUtils.sucess();
        emCascata = false;
    }

    public void deleteArvore() {
        try {
            Object id = getId();
            if (getId() != null) {
                getBO().delete(id);
                FacesMessageUtils.sucess();
                id = null;
                //recarregar tree
                carregarTree();
            }
        } catch (DeleteException ex) {
            FacesMessageUtils.error(XpertResourceBundle.get("objectCannotBeDeleted"));
        }
    }

    public void carregarTree() {
        opms = opmBO.getTreeNode();
    }

}
