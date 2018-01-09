/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.venda;

import com.ebol.modelo.cadastro.Loja;
import com.ebol.modelo.cadastro.PessoaOp;
import com.ebol.modelo.enuns.SituacaoOpLancada;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */

@Entity
@Table(schema = "venda")
public class OpLancada implements Serializable {
    @Id
    @SequenceGenerator(schema="venda", allocationSize = 1, name = "OpLancada", sequenceName = "oplancada_id_seq")
    @GeneratedValue(generator = "OpLancada")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Loja loja_credito;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private PessoaOp pessoaOp;
    
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date lancamento = new Date();
    
    @Temporal(TemporalType.DATE)
    private Date resgate;
    
    private BigDecimal valor_op;
    
    @NotNull
    private SituacaoOpLancada situacao = SituacaoOpLancada.ABERTA;
    
    @NotAudited
    @OneToMany(mappedBy = "opLancada")
    private List<Credito> creditos;
    
    @NotAudited
    @OneToMany(mappedBy = "opLancada")
    private List<Debito> debitos;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final OpLancada other = (OpLancada) obj;
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

    public Loja getLoja_credito() {
        return loja_credito;
    }

    public void setLoja_credito(Loja loja_credito) {
        this.loja_credito = loja_credito;
    }

    public PessoaOp getPessoaOp() {
        return pessoaOp;
    }

    public void setPessoaOp(PessoaOp pessoaOp) {
        this.pessoaOp = pessoaOp;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public Date getResgate() {
        return resgate;
    }

    public void setResgate(Date resgate) {
        this.resgate = resgate;
    }

    public BigDecimal getValor_op() {
        return valor_op;
    }

    public void setValor_op(BigDecimal valor_op) {
        this.valor_op = valor_op;
    }

    public SituacaoOpLancada getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoOpLancada situacao) {
        this.situacao = situacao;
    }

    public List<Credito> getCreditos() {
        return creditos;
    }

    public void setCreditos(List<Credito> creditos) {
        this.creditos = creditos;
    }

    public List<Debito> getDebitos() {
        return debitos;
    }

    public void setDebitos(List<Debito> debitos) {
        this.debitos = debitos;
    }
    
    
}
