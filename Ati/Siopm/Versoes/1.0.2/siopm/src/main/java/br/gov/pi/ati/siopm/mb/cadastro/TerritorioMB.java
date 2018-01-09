package br.gov.pi.ati.siopm.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.TerritorioBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Poligono;
import br.gov.pi.ati.siopm.modelo.cadastro.Territorio;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.i18n.XpertResourceBundle;
import com.xpert.persistence.exception.DeleteException;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class TerritorioMB extends AbstractBaseBean<Territorio> implements Serializable {

    @EJB
    private TerritorioBO territorioBO;

    private Poligono poligonoAdd;

    private List<Poligono> poligonos;

    private boolean emCascata;

    private TreeNode territorios;

    @Override
    public TerritorioBO getBO() {
        return territorioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }

    @Override
    public void save() {
        getEntity().setPoligonos(poligonos);
        super.save();
    }

    @Override
    public void init() {
        poligonoAdd = new Poligono();
        poligonos = new ArrayList<Poligono>();
        if (getEntity().getId() != null) {
            poligonos = getBO().getDAO().getInitialized(getEntity().getPoligonos());
        }
    }

    public void setarPai(Territorio territorioPai) {
        if (territorioPai != null) {
            getEntity().setTerritorioPai(territorioPai);
        }
    }

    public void salvarOrdenacao() {
        getBO().salvarOrdenacao(territorios);
        carregarTree();
        FacesMessageUtils.sucess();
    }

    public void inativar() {
        getBO().inativar(getEntity(), emCascata);
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
        territorios = getBO().getTreeNode();
    }

    public boolean isEmCascata() {
        return emCascata;
    }

    public void setEmCascata(boolean emCascata) {
        this.emCascata = emCascata;
    }

    public TreeNode getTerritorios() {
        return territorios;
    }

    public void setTerritorios(TreeNode territorios) {
        this.territorios = territorios;
    }

    public List<Poligono> getPoligonos() {
        return poligonos;
    }

    public void setPoligonos(List<Poligono> poligonos) {
        this.poligonos = poligonos;
    }

    public void addPoligono() {
        if (poligonoAdd != null) {
            if (poligonoJahAdd(poligonoAdd)) {
                FacesMessageUtils.error("Polígono já foi adicionado!!");
            } else {
                poligonos.add(poligonoAdd);
                poligonoAdd = new Poligono();
            }

        } else {
            FacesMessageUtils.error("Polígono é obrigatório!!");
        }
    }

    public void removerPoligono(Poligono poligono) {
        poligonos.remove(poligono);
    }

    private boolean poligonoJahAdd(Poligono poligono) {

        for (Poligono poligono1 : poligonos) {
            if (poligono.equals(poligono1)) {
                return true;
            }
        }
        return false;
    }

    public Poligono getPoligonoAdd() {
        return poligonoAdd;
    }

    public void setPoligonoAdd(Poligono poligonoAdd) {
        this.poligonoAdd = poligonoAdd;
    }
    
    
}
