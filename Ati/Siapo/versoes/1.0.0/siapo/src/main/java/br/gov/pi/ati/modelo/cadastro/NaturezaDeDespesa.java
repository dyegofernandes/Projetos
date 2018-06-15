/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro;

import br.gov.pi.ati.modelo.orcamento.Dotacao;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class NaturezaDeDespesa implements Serializable {

    @Id
    @SequenceGenerator(name = "NaturezaDeDespesa", sequenceName = "naturezaDeDespesa_seq_id")
    @GeneratedValue(generator = "NaturezaDeDespesa")
    private Long id;

    @NotBlank
    @Size(max = 260)
    private String codigo;

    @Size(max = 260)
    @NotBlank
    private String nome;

    private BigDecimal dotacaoInicial = BigDecimal.ZERO;

    private BigDecimal dotacaoAtualizada = BigDecimal.ZERO;

    private BigDecimal despesasEmpenhadas = BigDecimal.ZERO;

    private BigDecimal despesasLiquidadas = BigDecimal.ZERO;

    private BigDecimal despesasPagas = BigDecimal.ZERO;

    private BigDecimal saldoDisponivel = BigDecimal.ZERO;

    private boolean ativo = true;

    @OneToMany(mappedBy = "naturezaDaDespesa")
    @NotAudited
    private List<Dotacao> dotacoes;

    @Override
    public String toString() {
        return codigo.concat(" - ").concat(nome);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Dotacao> getDotacoes() {
        return dotacoes;
    }

    public void setDotacoes(List<Dotacao> dotacoes) {
        this.dotacoes = dotacoes;
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

    @Override
    public int hashCode() {
        int hash = 5;
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
        final NaturezaDeDespesa other = (NaturezaDeDespesa) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
