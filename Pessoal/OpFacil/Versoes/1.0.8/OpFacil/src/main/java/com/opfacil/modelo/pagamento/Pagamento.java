/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.modelo.pagamento;

import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.cadastro.Funcionario;
import com.opfacil.modelo.cadastro.MotivoPagamento;
import com.opfacil.modelo.controleacesso.Usuario;
import com.opfacil.modelo.enums.SituacaoOp;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 20)
    private String op;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private MotivoPagamento motivoPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lote lote;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPagamento;

    private BigDecimal valorPagto;

    private SituacaoOp situacao = SituacaoOp.NAOGERADA;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MotivoPagamento getMotivoPagamento() {
        return motivoPagamento;
    }

    public void setMotivoPagamento(MotivoPagamento motivoPagamento) {
        this.motivoPagamento = motivoPagamento;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public BigDecimal getValorPagto() {
        return valorPagto;
    }

    public void setValorPagto(BigDecimal valorPagto) {
        this.valorPagto = valorPagto;
    }

    public SituacaoOp getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoOp situacao) {
        this.situacao = situacao;
    }

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
        final Pagamento other = (Pagamento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
