/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.financeiro;

import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ContaFinanceira;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Estabelecimento;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.HistoricoPadrao;
import br.com.jsoft.centralfinanceira.modelo.enums.NaturezaDespesa;
import br.com.jsoft.centralfinanceira.modelo.enums.OrigemLancamento;
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

/**
 * dbo.LAN
 * @author Juniel
 */
@Entity
@Table(schema = "ag")
public class Lancamentos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Empresa empresa;
    
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date data;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Estabelecimento estabelecimento;
    
    @NotNull
    private Integer sequencial;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private ContaFinanceira contaFinanceira;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private CentroResultados centroResultado;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private ReceitaDespesa receitaDespesa;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private HistoricoPadrao historicoPadrao;
    
    @NotNull
    private BigDecimal valor;
    
    private NaturezaDespesa natureza;
    
    @NotNull
    private OrigemLancamento origem;
    
    private String historico;
    
    private boolean exportarAC = true;
    
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Integer getSequencial() {
        return sequencial;
    }

    public void setSequencial(Integer sequencial) {
        this.sequencial = sequencial;
    }

    public ContaFinanceira getContaFinanceira() {
        return contaFinanceira;
    }

    public void setContaFinanceira(ContaFinanceira contaFinanceira) {
        this.contaFinanceira = contaFinanceira;
    }

    public CentroResultados getCentroResultado() {
        return centroResultado;
    }

    public void setCentroResultado(CentroResultados centroResultado) {
        this.centroResultado = centroResultado;
    }

    public ReceitaDespesa getReceitaDespesa() {
        return receitaDespesa;
    }

    public void setReceitaDespesa(ReceitaDespesa receitaDespesa) {
        this.receitaDespesa = receitaDespesa;
    }

    public HistoricoPadrao getHistoricoPadrao() {
        return historicoPadrao;
    }

    public void setHistoricoPadrao(HistoricoPadrao historicoPadrao) {
        this.historicoPadrao = historicoPadrao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public NaturezaDespesa getNatureza() {
        return natureza;
    }

    public void setNatureza(NaturezaDespesa natureza) {
        this.natureza = natureza;
    }

    public OrigemLancamento getOrigem() {
        return origem;
    }

    public void setOrigem(OrigemLancamento origem) {
        this.origem = origem;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public boolean isExportarAC() {
        return exportarAC;
    }

    public void setExportarAC(boolean exportarAC) {
        this.exportarAC = exportarAC;
    }

    public boolean isJaExportado() {
        return jaExportado;
    }

    public void setJaExportado(boolean jaExportado) {
        this.jaExportado = jaExportado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Lancamentos other = (Lancamentos) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
