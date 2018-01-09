/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Juniel
 */
@Entity
public class PoliciaRodoviariaFederal extends Organizacao implements Serializable {

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
        final PoliciaRodoviariaFederal other = (PoliciaRodoviariaFederal) obj;
        if (getId() != other.getId() && (getId() == null || !getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

}
