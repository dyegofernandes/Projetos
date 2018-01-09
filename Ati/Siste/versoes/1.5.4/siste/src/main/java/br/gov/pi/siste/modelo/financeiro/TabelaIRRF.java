/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.financeiro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class TabelaIRRF implements Serializable {

    @Id
    @SequenceGenerator(name = "TabelaIRRF", allocationSize = 1, sequenceName = "seq_tabelaIRRF")
    @GeneratedValue(generator = "TabelaIRRF")
    private Long id;
    
    @NotNull
    private Integer anoDeVingencia;
    
    @NotNull
    private BigDecimal deducaoPorDependentes = BigDecimal.ZERO;
    
    @NotAudited
    @OrderBy("anoDeVingencia")
    @OneToMany(mappedBy = "tabelaIRRF")
    private List<AliquotaIRRF> aliquotas;

    @NotAudited
    @OrderBy("anoDeVingencia")
    @OneToMany(mappedBy = "ir")
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

    public List<AliquotaIRRF> getAliquotas() {
        return aliquotas;
    }

    public void setAliquotas(List<AliquotaIRRF> aliquotas) {
        this.aliquotas = aliquotas;
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }

    public BigDecimal getDeducaoPorDependentes() {
        return deducaoPorDependentes;
    }

    public void setDeducaoPorDependentes(BigDecimal deducaoPorDependentes) {
        this.deducaoPorDependentes = deducaoPorDependentes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final TabelaIRRF other = (TabelaIRRF) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
