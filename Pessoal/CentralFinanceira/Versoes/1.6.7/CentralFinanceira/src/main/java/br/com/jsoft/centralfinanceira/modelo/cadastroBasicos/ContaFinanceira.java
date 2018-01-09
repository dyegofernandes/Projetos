/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.cadastroBasicos;

import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagar;
import br.com.jsoft.centralfinanceira.modelo.financeiro.Lancamentos;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ReceitaDespesa;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 * dbo.CON
 *
 * @author Juniel
 */
@Entity
@Table(schema = "ag")
public class ContaFinanceira implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Empresa empresa;

    @Size(max = 40)
    @NotBlank
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private GrupoContaFinanceira grupo;

    @Size(max = 10)
    private String agencia;

    @Size(max = 10)
    private String cc;

    private Integer idImpressaoCheque;

    @Size(max = 15)
    private String contaContabil;

    private String obs;

    @ManyToOne(fetch = FetchType.LAZY)
    private Banco banco;

    @NotAudited
    @OneToMany(mappedBy = "contaFinanceira")
    private List<AgenteCobrador> agentes;

    @NotAudited
    @OneToMany(mappedBy = "contaFinanceira")
    private List<ReceitaDespesa> receitasDespesas;

    @NotAudited
    @OneToMany(mappedBy = "contaFinanceira")
    private List<ContasAPagar> contasAPaga;

    @NotAudited
    @OneToMany(mappedBy = "contaFinanceira")
    private List<Lancamentos> lancamentos;

    @Override
    public String toString() {
        return nome.concat(" - Ag.: ").concat(agencia != null ? agencia : "").concat(", Conta: ").concat(cc != null ? cc : "");
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GrupoContaFinanceira getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoContaFinanceira grupo) {
        this.grupo = grupo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Integer getIdImpressaoCheque() {
        return idImpressaoCheque;
    }

    public void setIdImpressaoCheque(Integer idImpressaoCheque) {
        this.idImpressaoCheque = idImpressaoCheque;
    }

    public String getContaContabil() {
        return contaContabil;
    }

    public void setContaContabil(String contaContabil) {
        this.contaContabil = contaContabil;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public List<AgenteCobrador> getAgentes() {
        return agentes;
    }

    public void setAgentes(List<AgenteCobrador> agentes) {
        this.agentes = agentes;
    }

    public List<ReceitaDespesa> getReceitasDespesas() {
        return receitasDespesas;
    }

    public void setReceitasDespesas(List<ReceitaDespesa> receitasDespesas) {
        this.receitasDespesas = receitasDespesas;
    }

    public List<ContasAPagar> getContasAPaga() {
        return contasAPaga;
    }

    public void setContasAPaga(List<ContasAPagar> contasAPaga) {
        this.contasAPaga = contasAPaga;
    }

    public List<Lancamentos> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamentos> lancamentos) {
        this.lancamentos = lancamentos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ContaFinanceira other = (ContaFinanceira) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
