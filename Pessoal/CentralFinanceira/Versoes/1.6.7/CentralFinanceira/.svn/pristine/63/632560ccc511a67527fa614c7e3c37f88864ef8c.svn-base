/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.cadastroBasicos;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "regente")
public class ComissaoBBGrupoLoja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private GrupoLoja grupoLoja;

    @ManyToOne(fetch = FetchType.LAZY)
    private Conveniobb conveniobb;

    private BigDecimal unitario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GrupoLoja getGrupoLoja() {
        return grupoLoja;
    }

    public void setGrupoLoja(GrupoLoja grupoLoja) {
        this.grupoLoja = grupoLoja;
    }

    public Conveniobb getConveniobb() {
        return conveniobb;
    }

    public void setConveniobb(Conveniobb conveniobb) {
        this.conveniobb = conveniobb;
    }

    public BigDecimal getUnitario() {
        return unitario;
    }

    public void setUnitario(BigDecimal unitario) {
        this.unitario = unitario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final ComissaoBBGrupoLoja other = (ComissaoBBGrupoLoja) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
