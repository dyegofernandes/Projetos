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
public class ModuloInfoFolha implements Serializable {

    @Id
    @SequenceGenerator(name = "ModuloInfoFolha", allocationSize = 1, sequenceName = "seq_moduloInfoFolha")
    @GeneratedValue(generator = "ModuloInfoFolha")
    private Long id;
    
    private boolean contracheque = false;
    
    private boolean fichaFinanceira = false;
    
    private boolean gfip = false;

    private boolean relatorio = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isContracheque() {
        return contracheque;
    }

    public void setContracheque(boolean contracheque) {
        this.contracheque = contracheque;
    }

    public boolean isFichaFinanceira() {
        return fichaFinanceira;
    }

    public void setFichaFinanceira(boolean fichaFinanceira) {
        this.fichaFinanceira = fichaFinanceira;
    }

    public boolean isGfip() {
        return gfip;
    }

    public void setGfip(boolean gfip) {
        this.gfip = gfip;
    }

    public boolean isRelatorio() {
        return relatorio;
    }

    public void setRelatorio(boolean relatorio) {
        this.relatorio = relatorio;
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
        final ModuloInfoFolha other = (ModuloInfoFolha) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
