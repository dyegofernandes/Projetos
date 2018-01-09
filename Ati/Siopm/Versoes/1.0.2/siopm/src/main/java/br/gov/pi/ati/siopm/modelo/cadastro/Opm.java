/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Juniel
 */
@Entity
public class Opm extends Organizacao implements Serializable {

    @NotAudited
    @OneToMany(mappedBy = "opm")
    private List<Patrulha> patrulhas;

    @Override
    public List<Telefone> getTelefones() {
        return super.getTelefones();
    }

    @Override
    public void setTelefones(List<Telefone> telefones) {
        super.setTelefones(telefones);
    }

    public List<Patrulha> getPatrulhas() {
        return patrulhas;
    }

    public void setPatrulhas(List<Patrulha> patrulhas) {
        this.patrulhas = patrulhas;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Opm other = (Opm) obj;
        if (getId() != other.getId() && (getId() == null || !getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

}
