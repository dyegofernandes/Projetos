/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.venda;

import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.enuns.SituacaoDebito;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */

@Entity
@Table(schema = "venda")
public class Debito implements Serializable {

    @Id
    @SequenceGenerator(schema="venda", allocationSize = 1, name = "Debito", sequenceName = "debito_id_seq")
    @GeneratedValue(generator = "Debito")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Boleto boleto;

    @ManyToOne(fetch = FetchType.LAZY)
    private Convenio convenio;

    @ManyToOne(fetch = FetchType.LAZY)
    private OpLancada opLancada;

    @Size(max = 100)
    private String referenteA;

    private BigDecimal valor;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date data_debito;

    private SituacaoDebito situacao;
    
    @Override
    public String toString() {
        return referenteA;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Debito other = (Debito) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public OpLancada getOpLancada() {
        return opLancada;
    }

    public void setOpLancada(OpLancada opLancada) {
        this.opLancada = opLancada;
    }

    public String getReferenteA() {
        return referenteA;
    }

    public void setReferenteA(String referenteA) {
        this.referenteA = referenteA;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData_debito() {
        return data_debito;
    }

    public void setData_debito(Date data_debito) {
        this.data_debito = data_debito;
    }

    public SituacaoDebito getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoDebito situacao) {
        this.situacao = situacao;
    }
    
    
}
