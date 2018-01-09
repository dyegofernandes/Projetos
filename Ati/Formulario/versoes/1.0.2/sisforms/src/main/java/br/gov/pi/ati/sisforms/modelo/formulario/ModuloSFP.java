/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Juniel
 */
@Entity
public class ModuloSFP implements Serializable {

    @Id
    @SequenceGenerator(name = "ModuloSFP", allocationSize = 1, sequenceName = "seq_moduloSFP")
    @GeneratedValue(generator = "ModuloSFP")
    private Long id;

    private boolean inclusao = false;

    private boolean alteracao = false;

    private boolean consulta = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isInclusao() {
        return inclusao;
    }

    public void setInclusao(boolean inclusao) {
        this.inclusao = inclusao;
    }

    public boolean isAlteracao() {
        return alteracao;
    }

    public void setAlteracao(boolean alteracao) {
        this.alteracao = alteracao;
    }

    public boolean isConsulta() {
        return consulta;
    }

    public void setConsulta(boolean consulta) {
        this.consulta = consulta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ModuloSFP other = (ModuloSFP) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
