/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.modelo.pagamento;

import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.cadastro.MotivoPagamento;
import com.opfacil.modelo.controleacesso.Usuario;
import com.xpert.audit.NotAudited;
import com.xpert.utils.DateUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import sun.text.resources.FormatData;

/**
 *
 * @author Juniel
 */
@Entity
public class Lote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa empresa;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private MotivoPagamento motivoPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @NotNull
    private Integer qtdias;

    @NotNull
    private BigDecimal vlrDia;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPagamento;

    @NotAudited
    @OrderBy("id")
    @OneToMany(mappedBy = "lote")
    private List<Pagamento> pagamentos;

    public BigDecimal getVlrTotal() {
        if (qtdias != null && vlrDia != null) {
            return vlrDia.multiply(BigDecimal.valueOf(qtdias.doubleValue()));
        }
        return BigDecimal.ZERO;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public MotivoPagamento getMotivoPagamento() {
        return motivoPagamento;
    }

    public void setMotivoPagamento(MotivoPagamento motivoPagamento) {
        this.motivoPagamento = motivoPagamento;
    }

    public Integer getQtdias() {
        return qtdias;
    }

    public void setQtdias(Integer qtdias) {
        this.qtdias = qtdias;
    }

    public BigDecimal getVlrDia() {
        return vlrDia;
    }

    public void setVlrDia(BigDecimal vlrDia) {
        this.vlrDia = vlrDia;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Lote "+ id + " -  Data: " + DateUtils.dateToString(dtPagamento, "dd/MM/yyyy");
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
        final Lote other = (Lote) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
