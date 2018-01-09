/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.financeiro;

import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/** dbo.BVP
 *
 * @author Juniel
 */
@Entity
@Table(schema = "ag")
public class ContasAPagarVencimentosBaixas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Empresa empresa;

    @NotNull
    private Long codigoVencimento;
    
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataVencimento;
    
    @NotNull
    private Integer sequencialVencimento;
    
    @NotNull
    private Integer sequencial;
    
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date data;
    
    @NotNull
    private BigDecimal valor;
    
    private BigDecimal desconto;
    
    private BigDecimal juros;
    
    private boolean automatica = false;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCancel;
    
    private String obsCancel;
    
    private BigDecimal multa;
    
    private boolean exportaAC = true;
    
    private boolean jaExportado = false;

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

    public Long getCodigoVencimento() {
        return codigoVencimento;
    }

    public void setCodigoVencimento(Long codigoVencimento) {
        this.codigoVencimento = codigoVencimento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Integer getSequencialVencimento() {
        return sequencialVencimento;
    }

    public void setSequencialVencimento(Integer sequencialVencimento) {
        this.sequencialVencimento = sequencialVencimento;
    }

    public Integer getSequencial() {
        return sequencial;
    }

    public void setSequencial(Integer sequencial) {
        this.sequencial = sequencial;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getJuros() {
        return juros;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    public boolean isAutomatica() {
        return automatica;
    }

    public void setAutomatica(boolean automatica) {
        this.automatica = automatica;
    }

    public Date getDataCancel() {
        return dataCancel;
    }

    public void setDataCancel(Date dataCancel) {
        this.dataCancel = dataCancel;
    }

    public String getObsCancel() {
        return obsCancel;
    }

    public void setObsCancel(String obsCancel) {
        this.obsCancel = obsCancel;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public boolean isExportaAC() {
        return exportaAC;
    }

    public void setExportaAC(boolean exportaAC) {
        this.exportaAC = exportaAC;
    }

    public boolean isJaExportado() {
        return jaExportado;
    }

    public void setJaExportado(boolean jaExportado) {
        this.jaExportado = jaExportado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final ContasAPagarVencimentosBaixas other = (ContasAPagarVencimentosBaixas) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
