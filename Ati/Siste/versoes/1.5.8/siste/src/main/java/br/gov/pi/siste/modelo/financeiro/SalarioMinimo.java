/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.financeiro;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class SalarioMinimo implements Serializable {

    @Id
    @SequenceGenerator(name = "SalarioMinimo", allocationSize = 1, sequenceName = "seq_salarioMinimo")
    @GeneratedValue(generator = "SalarioMinimo")
    private Long id;
    
    @NotNull
    private Integer anoDeVingencia;
    
    @NotNull
    private BigDecimal valor;

    @Override
    public String toString() {
        return "" + anoDeVingencia; //To change body of generated methods, choose Tools | Templates.
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final SalarioMinimo other = (SalarioMinimo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
