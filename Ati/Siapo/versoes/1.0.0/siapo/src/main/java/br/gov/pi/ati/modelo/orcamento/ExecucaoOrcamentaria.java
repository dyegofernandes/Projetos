/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.orcamento;

import br.gov.pi.ati.modelo.cadastro.AcaoOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.FonteDeRecurso;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeDespesa;
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
public class ExecucaoOrcamentaria implements Serializable {
    
    @Id
    @SequenceGenerator(name = "ExecucaoOrcamentaria", sequenceName = "execucaoorcamentaria_seq_id")
    @GeneratedValue(generator = "ExecucaoOrcamentaria")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private AcaoOrcamentaria acaoOrcamentaria;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private FonteDeRecurso fonteDeRecurso;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private NaturezaDeDespesa naturezaDaDespesa;
    
    private BigDecimal dotacaoInicial = BigDecimal.ZERO;
    
    private BigDecimal dotacaoAtualizada = BigDecimal.ZERO;
    
    private BigDecimal despesasEmpenhadas = BigDecimal.ZERO;
    
    private BigDecimal despesasLiquidadas = BigDecimal.ZERO;
    
    private BigDecimal despesasPagas = BigDecimal.ZERO;
    
    private BigDecimal saldoDisponivel = BigDecimal.ZERO;
    
    private BigDecimal totalComprometidoSiapo = BigDecimal.ZERO;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public AcaoOrcamentaria getAcaoOrcamentaria() {
        return acaoOrcamentaria;
    }
    
    public void setAcaoOrcamentaria(AcaoOrcamentaria acaoOrcamentaria) {
        this.acaoOrcamentaria = acaoOrcamentaria;
    }
    
    public FonteDeRecurso getFonteDeRecurso() {
        return fonteDeRecurso;
    }
    
    public void setFonteDeRecurso(FonteDeRecurso fonteDeRecurso) {
        this.fonteDeRecurso = fonteDeRecurso;
    }
    
    public NaturezaDeDespesa getNaturezaDaDespesa() {
        return naturezaDaDespesa;
    }
    
    public void setNaturezaDaDespesa(NaturezaDeDespesa naturezaDaDespesa) {
        this.naturezaDaDespesa = naturezaDaDespesa;
    }
    
    public BigDecimal getDotacaoInicial() {
        return dotacaoInicial;
    }
    
    public void setDotacaoInicial(BigDecimal dotacaoInicial) {
        this.dotacaoInicial = dotacaoInicial;
    }
    
    public BigDecimal getDotacaoAtualizada() {
        return dotacaoAtualizada;
    }
    
    public void setDotacaoAtualizada(BigDecimal dotacaoAtualizada) {
        this.dotacaoAtualizada = dotacaoAtualizada;
    }
    
    public BigDecimal getDespesasEmpenhadas() {
        return despesasEmpenhadas;
    }
    
    public void setDespesasEmpenhadas(BigDecimal despesasEmpenhadas) {
        this.despesasEmpenhadas = despesasEmpenhadas;
    }
    
    public BigDecimal getDespesasLiquidadas() {
        return despesasLiquidadas;
    }
    
    public void setDespesasLiquidadas(BigDecimal despesasLiquidadas) {
        this.despesasLiquidadas = despesasLiquidadas;
    }
    
    public BigDecimal getDespesasPagas() {
        return despesasPagas;
    }
    
    public void setDespesasPagas(BigDecimal despesasPagas) {
        this.despesasPagas = despesasPagas;
    }
    
    public BigDecimal getSaldoDisponivel() {
        return saldoDisponivel;
    }
    
    public void setSaldoDisponivel(BigDecimal saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }
    
    public BigDecimal getAlteracaoNaLoa() {
        BigDecimal valor = BigDecimal.ZERO;
        
        if (dotacaoAtualizada != null) {
            valor = valor.add(dotacaoAtualizada);
        }
        
        if (dotacaoInicial != null) {
            valor = valor.subtract(dotacaoInicial);
        }
        
        return valor;
    }
    
    public BigDecimal getTotalComprometidoSiapo() {
        return totalComprometidoSiapo;
    }
    
    public void setTotalComprometidoSiapo(BigDecimal totalComprometidoSiapo) {
        this.totalComprometidoSiapo = totalComprometidoSiapo;
    }
    
    public BigDecimal getSaldoDisponivelMenosComprometido() {
        BigDecimal valor = BigDecimal.ZERO;
        
        if (saldoDisponivel != null) {
            valor = valor.add(saldoDisponivel);
        }
        
        if (totalComprometidoSiapo != null) {
            valor = valor.subtract(totalComprometidoSiapo);
        }
        
        return valor;
    }
    
    public BigDecimal getSaldoOrcamentaria() {//E = A +ou - B - C - D: 
        BigDecimal valor = BigDecimal.ZERO;

        //(A)
        if (dotacaoInicial != null) {
            valor = valor.add(dotacaoInicial);
        }

        //(B)
        if (getAlteracaoNaLoa() != null) {
            valor = valor.add(getAlteracaoNaLoa());
        }
        //(C)
        if (despesasEmpenhadas != null) {
            valor = valor.subtract(despesasEmpenhadas);
        }

        //(D)
        if (totalComprometidoSiapo != null) {
            valor = valor.subtract(totalComprometidoSiapo);
        }
        
        return valor;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final ExecucaoOrcamentaria other = (ExecucaoOrcamentaria) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
