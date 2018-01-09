package br.gov.pi.ati.siopm.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.BombeiroBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Bombeiro;
import br.gov.pi.ati.siopm.modelo.cadastro.Endereco;
import br.gov.pi.ati.siopm.modelo.cadastro.Telefone;
import br.gov.pi.ati.siopm.modelo.cadastro.Territorio;
import br.gov.pi.ati.siopm.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BombeiroMB extends AbstractBaseBean<Bombeiro> implements Serializable {

    @EJB
    private BombeiroBO bombeiroBO;

    private Territorio territorioAdd;

    private List<Territorio> territorios;

    private Telefone telefoneAdd;

    private List<Telefone> telefones;

    private Endereco endereco;

    @Override
    public void init() {
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
    }
    
    @Override
    public void save() {
        getEntity().setEndereco(endereco);
        getEntity().setTerritorios(territorios);
        getEntity().setTelefones(telefones);
        super.save();
    }

    @Override
    public BombeiroBO getBO() {
        return bombeiroBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
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
}
