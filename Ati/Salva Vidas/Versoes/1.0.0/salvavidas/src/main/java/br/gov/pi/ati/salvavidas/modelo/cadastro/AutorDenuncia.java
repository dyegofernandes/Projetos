/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.salvavidas.modelo.cadastro;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Juniel
 */
@Entity
public class AutorDenuncia extends Pessoa implements Serializable {
    
    private String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        final AutorDenuncia other = (AutorDenuncia) obj;
        if (getId() != other.getId() && (getId() == null || !getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }
}
