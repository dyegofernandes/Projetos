/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.adapi.modelo.cadastro;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class SinalClinico implements Serializable {

    @Id
    @SequenceGenerator(name = "SinalClinico", sequenceName = "sinalClinico_id_seq")
    @GeneratedValue(generator = "SinalClinico")
    private Long id;

    @Size(max = 260)
    @NotBlank
    private String termoTecnico;

    @Size(max = 260)
    @NotBlank
    private String termoPopular;
    
    private boolean ativo = true;

    @Override
    public String toString() {
        return termoTecnico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTermoTecnico() {
        return termoTecnico;
    }

    public void setTermoTecnico(String termoTecnico) {
        this.termoTecnico = termoTecnico;
    }

    public String getTermoPopular() {
        return termoPopular;
    }

    public void setTermoPopular(String termoPopular) {
        this.termoPopular = termoPopular;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final SinalClinico other = (SinalClinico) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
