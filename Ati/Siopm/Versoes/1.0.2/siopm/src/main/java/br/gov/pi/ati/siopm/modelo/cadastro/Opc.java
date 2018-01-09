/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author Juniel
 */
@Entity
public class Opc extends Organizacao implements Serializable {

//    @NotAudited
//    @OneToMany(mappedBy = "delegacia")
//    private List<Ocorrencia> ocorrencias;
    @Override
    public List<Telefone> getTelefones() {
        return super.getTelefones();
    }

    @Override
    public void setTelefones(List<Telefone> telefones) {
        super.setTelefones(telefones); //To change body of generated methods, choose Tools | Templates.
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
        final Opc other = (Opc) obj;
        if (getId() != other.getId() && (getId() == null || !getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

}
