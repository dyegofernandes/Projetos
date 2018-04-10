/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pagcontascarne.modelo.dados;

import br.com.pagcontascarne.modelo.enums.SituacaoDeposito;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "dados")
public class Deposito implements Serializable {

    @Id
    @SequenceGenerator(schema = "dados", allocationSize = 1, name = "Deposito", sequenceName = "dados.seq_deposito_id")
    @GeneratedValue(generator = "Deposito")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Franquia franquia;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Convenio convenio;

    @Temporal(TemporalType.DATE)
    private Date dt_deposito;

    @NotNull
    private BigDecimal vl_deposito; //total_arrecadado-total_tarifa

    @NotNull
    private BigDecimal total_tarifa = BigDecimal.ZERO;

    @NotNull
    private BigDecimal total_arrecadado;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Banco banco;

    @Size(max = 10)
    @NotBlank
    private String agencia;

    @Size(max = 10)
    @NotBlank
    private String conta_corrente;

    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private SituacaoDeposito situacao = SituacaoDeposito.NAO_DEPOSITADO;
    
    @NotNull
    private BigDecimal vl_custo_oper = BigDecimal.ZERO;

    @NotAudited
    @OneToMany(mappedBy = "deposito")
    private List<Boleto> boletos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Date getDt_deposito() {
        return dt_deposito;
    }

    public void setDt_deposito(Date dt_deposito) {
        this.dt_deposito = dt_deposito;
    }

    public BigDecimal getVl_deposito() {
        return vl_deposito;
    }

    public void setVl_deposito(BigDecimal vl_deposito) {
        this.vl_deposito = vl_deposito;
    }

    public BigDecimal getTotal_tarifa() {
        return total_tarifa;
    }

    public void setTotal_tarifa(BigDecimal total_tarifa) {
        this.total_tarifa = total_tarifa;
    }

    public BigDecimal getTotal_arrecadado() {
        return total_arrecadado;
    }

    public void setTotal_arrecadado(BigDecimal total_arrecadado) {
        this.total_arrecadado = total_arrecadado;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta_corrente() {
        return conta_corrente;
    }

    public void setConta_corrente(String conta_corrente) {
        this.conta_corrente = conta_corrente;
    }

    public SituacaoDeposito getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoDeposito situacao) {
        this.situacao = situacao;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public Franquia getFranquia() {
        return franquia;
    }

    public void setFranquia(Franquia franquia) {
        this.franquia = franquia;
    }

    public BigDecimal getVl_custo_oper() {
        return vl_custo_oper;
    }

    public void setVl_custo_oper(BigDecimal vl_custo_oper) {
        this.vl_custo_oper = vl_custo_oper;
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
        final Deposito other = (Deposito) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
