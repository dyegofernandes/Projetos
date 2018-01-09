package com.ebol.mb.cadastro;

import com.ebol.bo.cadastro.FamiliarBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.cadastro.SocioBO;
import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.cadastro.Familiar;
import com.ebol.modelo.cadastro.Socio;
import com.ebol.util.SessaoUtils;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class SocioMB extends AbstractBaseBean<Socio> implements Serializable {

    @EJB
    private SocioBO socioBO;

    @EJB
    private FamiliarBO familiarBO;

    private List<Socio> socios;

    private Familiar familiarAdd;

    private List<Familiar> familiares;

    private List<Familiar> familiaresDeletados;
    
    private Convenio convenio;

    public Familiar getFamiliarAdd() {
        return familiarAdd;
    }

    public void setFamiliarAdd(Familiar familiarAdd) {
        this.familiarAdd = familiarAdd;
    }

    public List<Familiar> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(List<Familiar> familiares) {
        this.familiares = familiares;
    }

    public List<Familiar> getFamiliaresDeletados() {
        return familiaresDeletados;
    }

    public void setFamiliaresDeletados(List<Familiar> familiaresDeletados) {
        this.familiaresDeletados = familiaresDeletados;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    @Override
    public void init() {
        socios = new ArrayList<Socio>();
        familiarAdd = new Familiar();
        familiaresDeletados = new ArrayList<Familiar>();
        familiares = new ArrayList<Familiar>();
        if (getEntity().getId() != null) {
            familiares = familiarBO.getDAO().list("socio_id", getEntity().getId(), "nome DESC");
        }
        
        convenio = socioBO.getDAO().getInitialized(SessaoUtils.getUser().getConvenio());
        
        getEntity().setConvenio(convenio);

        if (SessaoUtils.getUser().isSuperUsuario()) {
            socios = socioBO.getDAO().listAll();
        } else {
            socios = socioBO.getDAO().list("convenio", convenio);
        }
    }

    @Override
    public void save() {
        super.save();

        for (Familiar familiare : familiares) {
            familiarBO.getDAO().saveOrMerge(familiare, true);
        }

        for (Familiar familiare : familiaresDeletados) {
            try {
                familiarBO.remove(familiare);
            } catch (DeleteException ex) {
                Logger.getLogger(SocioMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public SocioBO getBO() {
        return socioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public void addFamiliar() {
        if (familiarAdd.getNome().equals("") || familiarAdd.getNome() == null) {
            FacesMessageUtils.error("Nome é obrigatório!");
        } else {
            if (verificarNome(familiarAdd.getNome())) {
                FacesMessageUtils.error("Já foi adicionado um Familiar com esse nome!");
            } else {
                familiarAdd.setSocio(getEntity());
                familiares.add(familiarAdd);
                familiarAdd = new Familiar();
            }
        }

    }

    public void removerFamiliar(Familiar familiarDel) {
        if (familiarDel.getId() != null) {
            familiaresDeletados.add(familiarDel);
        }
        familiares.remove(familiarDel);
    }

    private boolean verificarNome(String nome) {
        for (Familiar familiare : familiares) {
            if (nome.toUpperCase().equals(familiare.getNome().toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
