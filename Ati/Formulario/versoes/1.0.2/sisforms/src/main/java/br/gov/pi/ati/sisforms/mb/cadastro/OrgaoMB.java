package br.gov.pi.ati.sisforms.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.cadastro.OrgaoBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.i18n.XpertResourceBundle;
import com.xpert.persistence.exception.DeleteException;
import com.xpert.persistence.query.Restriction;
import java.util.List;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class OrgaoMB extends AbstractBaseBean<Orgao> implements Serializable {

    @EJB
    private OrgaoBO orgaoBO;
    private boolean emCascata;
    private TreeNode orgaos;

    @Override
    public OrgaoBO getBO() {
        return orgaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }

    @Override
    public void init() {
        carregarTree();
    }
    
    @Override
    public List<Restriction> getDataModelRestrictions() {
        return null;
    }

    public void salvarOrdenacao() {
        orgaoBO.salvarOrdenacao(orgaos);
        carregarTree();
        FacesMessageUtils.sucess();
    }

    public void ativar() {
        orgaoBO.ativar(getEntity(), emCascata);
        carregarTree();
        FacesMessageUtils.sucess();
        emCascata = false;
    }

    public void inativar() {
        orgaoBO.inativar(getEntity(), emCascata);
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
        orgaos = orgaoBO.getTreeNode();
    }

    public boolean isEmCascata() {
        return emCascata;
    }

    public void setEmCascata(boolean emCascata) {
        this.emCascata = emCascata;
    }

    public TreeNode getOrgaos() {
        return orgaos;
    }

    public void setOrgaos(TreeNode orgaos) {
        this.orgaos = orgaos;
    }

}
