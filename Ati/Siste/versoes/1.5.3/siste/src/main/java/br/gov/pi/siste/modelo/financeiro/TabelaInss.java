/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.financeiro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class TabelaInss implements Serializable {

    @Id
    @SequenceGenerator(name = "TabelaInss", allocationSize = 1, sequenceName = "seq_tabelaInss")
    @GeneratedValue(generator = "TabelaInss")
    private Long id;
    
    @NotNull
    private Integer anoDeVingencia;
    
    @NotAudited
    @OrderBy("anoDeVingencia")
    @OneToMany(mappedBy = "tabelaInss")
    private List<AliquotaInss> aliquotas;
    
    @NotAudited
    @OrderBy("anoDeVingencia")
    @OneToMany(mappedBy = "inss")
    private List<Movimento> movimentos;

    @Override
    public String toString() {
        return "" + anoDeVingencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnoDeVingencia() {
        return anoDeVingencia;
    }

    public void setAnoDeVingencia(Integer anoDeVingencia) {
        this.anoDeVingencia = anoDeVingencia;
    }

    public List<AliquotaInss> getAliquotas() {
        return aliquotas;
    }

    public void setAliquotas(List<AliquotaInss> aliquotas) {
        this.aliquotas = aliquotas;
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final TabelaInss other = (TabelaInss) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
