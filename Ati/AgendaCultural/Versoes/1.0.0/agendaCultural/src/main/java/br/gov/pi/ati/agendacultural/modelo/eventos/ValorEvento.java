/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.modelo.eventos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Juniel
 */
@Entity
public class ValorEvento implements Serializable {
    
    @Id
    @SequenceGenerator(name = "ValorEvento", sequenceName = "valorEvento_id_seq")
    @GeneratedValue(generator = "ValorEvento")
    private Long id;
    
    private String descricao;
    
    private BigDecimal valor;
    
    private boolean meia = true;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public BigDecimal getValor() {
        return valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    public boolean isMeia() {
        return meia;
    }
    
    public void setMeia(boolean meia) {
        this.meia = meia;
    }
    
    public BigDecimal getMeiaEntrada() {
        BigDecimal valorTemp = BigDecimal.ZERO;
        
        if (valor != null && meia) {
            valorTemp = valor.divide(new BigDecimal(2), RoundingMode.UP);
        }
        
        return valorTemp;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ValorEvento other = (ValorEvento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
