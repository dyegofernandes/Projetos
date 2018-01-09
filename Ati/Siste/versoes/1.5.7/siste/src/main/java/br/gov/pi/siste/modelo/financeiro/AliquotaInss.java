/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.financeiro;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class AliquotaInss implements Serializable {

    @Id
    @SequenceGenerator(name = "AliquotaInss", allocationSize = 1, sequenceName = "seq_aliquotaInss")
    @GeneratedValue(generator = "AliquotaInss")
    private Long id;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private TabelaInss tabelaInss;
    
    private BigDecimal salarioInicial;
    
    private BigDecimal salarioFinal;
    
    private BigDecimal valor;
    
    private BigDecimal valorFixo = BigDecimal.ZERO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TabelaInss getTabelaInss() {
        return tabelaInss;
    }

    public void setTabelaInss(TabelaInss tabelaInss) {
        this.tabelaInss = tabelaInss;
    }

    public BigDecimal getSalarioInicial() {
        return salarioInicial;
    }

    public void setSalarioInicial(BigDecimal salarioInicial) {
        this.salarioInicial = salarioInicial;
    }

    public BigDecimal getSalarioFinal() {
        return salarioFinal;
    }

    public void setSalarioFinal(BigDecimal salarioFinal) {
        this.salarioFinal = salarioFinal;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorFixo() {
        return valorFixo;
    }

    public void setValorFixo(BigDecimal valorFixo) {
        this.valorFixo = valorFixo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final AliquotaInss other = (AliquotaInss) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
