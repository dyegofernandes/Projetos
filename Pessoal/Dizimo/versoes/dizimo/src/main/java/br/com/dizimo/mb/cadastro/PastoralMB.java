package br.com.dizimo.mb.cadastro;

import br.com.dizimo.bo.cadastro.MembroBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.dizimo.bo.cadastro.PastoralBO;
import br.com.dizimo.modelo.cadastro.Membro;
import br.com.dizimo.modelo.cadastro.Pastoral;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PastoralMB extends AbstractBaseBean<Pastoral> implements Serializable {

    @EJB
    private PastoralBO pastoralBO;

    @EJB
    private MembroBO membroBO;

    private Membro membroAdd;
    private List<Membro> membros;

    @Override
    public PastoralBO getBO() {
        return pastoralBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        membros = new ArrayList<Membro>();

        if (getEntity().getId() != null) {
            membros = getDAO().getInitialized(getEntity().getMembros());
            Collections.sort(membros);
        }
    }

    @Override
    public void save() {
        getEntity().setMembros(membros);
        super.save();
    }

    public Membro getMembroAdd() {
        return membroAdd;
    }

    public void setMembroAdd(Membro membroAdd) {
        this.membroAdd = membroAdd;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }

    public void addMembro() {
        if (membroAdd != null) {
            if (membroJaAdicionado(membroAdd)) {
                FacesMessageUtils.error("Membro já foi adicionado!");
            } else {
                membros.add(membroAdd);
                Collections.sort(membros);
                membroAdd = null;
            }
        } else {
            FacesMessageUtils.error("Membro é obrigatório!");
        }
    }

    public void removerMembro(Membro membro) {
        membros.remove(membro);
    }

    private boolean membroJaAdicionado(Membro membro) {
        for (Membro membroTemp : membros) {
            if (membroTemp.equals(membro)) {
                return true;
            }
        }
        return false;
    }

    public List<Membro> autocompleteMembros(String nome) {
        return membroBO.membrosPelaSede(getEntity().getSede(), nome);
    }

}
