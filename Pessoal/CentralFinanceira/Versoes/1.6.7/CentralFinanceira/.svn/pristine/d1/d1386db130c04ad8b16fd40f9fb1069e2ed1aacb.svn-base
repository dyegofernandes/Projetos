/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.financeiro;

import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Cliente;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ContaFinanceira;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Fornecedor;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoReceitaDespesa;
import br.com.jsoft.centralfinanceira.modelo.enums.NaturezaDespesa;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoDespesaEnum;
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
 * dbo.CRD
 *
 * @author Juniel
 */
@Entity
@Table(schema = "ag")
public class ReceitaDespesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Empresa empresa;

    @Size(max = 80)
    @NotBlank
    private String nome;

    @NotNull
    private TipoDespesaEnum tipo;

    private NaturezaDespesa natureza;

    @Size(max = 15)
    private String contaContabil;

    @ManyToOne(fetch = FetchType.LAZY)
    private GrupoReceitaDespesa grupo;

    @ManyToOne(fetch = FetchType.LAZY)
    private ContaFinanceira contaFinanceira;

    @ManyToOne(fetch = FetchType.LAZY)
    private ReceitaDespesa receitaDespesaMae;

    private boolean investimento = false;

    private boolean retemIss = true;

    private boolean retemInss = true;

    private boolean retemIrrf = true;

    private boolean retemIcms = false;

    private boolean retemPisConfinsCsll = true;

    private String obs;

    private String contaContabilEstoque;

    private boolean gerarSpr = false;

    private boolean inativo = false;

    @NotAudited
    @OneToMany(mappedBy = "receitaDespesa")
    private List<Fornecedor> fornecedores;

    @NotAudited
    @OneToMany(mappedBy = "receitaDespesa")
    private List<Cliente> clientes;

    @NotAudited
    @OneToMany(mappedBy = "receitaDespesaMae")
    private List<ReceitaDespesa> receitasDespesas;

    @NotAudited
    @OneToMany(mappedBy = "receitaDespesa")
    private List<ContasAPagar> contasAPaga;
    
    @NotAudited
    @OneToMany(mappedBy = "receitaDespesa")
    private List<Lancamentos> lancamentos;

    @Override
    public String toString() {
        return nome;
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

    public TipoDespesaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoDespesaEnum tipo) {
        this.tipo = tipo;
    }

    public NaturezaDespesa getNatureza() {
        return natureza;
    }

    public void setNatureza(NaturezaDespesa natureza) {
        this.natureza = natureza;
    }

    public String getContaContabil() {
        return contaContabil;
    }

    public void setContaContabil(String contaContabil) {
        this.contaContabil = contaContabil;
    }

    public GrupoReceitaDespesa getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoReceitaDespesa grupo) {
        this.grupo = grupo;
    }

    public ContaFinanceira getContaFinanceira() {
        return contaFinanceira;
    }

    public void setContaFinanceira(ContaFinanceira contaFinanceira) {
        this.contaFinanceira = contaFinanceira;
    }

    public ReceitaDespesa getReceitaDespesaMae() {
        return receitaDespesaMae;
    }

    public void setReceitaDespesaMae(ReceitaDespesa receitaDespesaMae) {
        this.receitaDespesaMae = receitaDespesaMae;
    }

    public boolean isInvestimento() {
        return investimento;
    }

    public void setInvestimento(boolean investimento) {
        this.investimento = investimento;
    }

    public boolean isRetemIss() {
        return retemIss;
    }

    public void setRetemIss(boolean retemIss) {
        this.retemIss = retemIss;
    }

    public boolean isRetemInss() {
        return retemInss;
    }

    public void setRetemInss(boolean retemInss) {
        this.retemInss = retemInss;
    }

    public boolean isRetemIrrf() {
        return retemIrrf;
    }

    public void setRetemIrrf(boolean retemIrrf) {
        this.retemIrrf = retemIrrf;
    }

    public boolean isRetemIcms() {
        return retemIcms;
    }

    public void setRetemIcms(boolean retemIcms) {
        this.retemIcms = retemIcms;
    }

    public boolean isRetemPisConfinsCsll() {
        return retemPisConfinsCsll;
    }

    public void setRetemPisConfinsCsll(boolean retemPisConfinsCsll) {
        this.retemPisConfinsCsll = retemPisConfinsCsll;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getContaContabilEstoque() {
        return contaContabilEstoque;
    }

    public void setContaContabilEstoque(String contaContabilEstoque) {
        this.contaContabilEstoque = contaContabilEstoque;
    }

    public boolean isGerarSpr() {
        return gerarSpr;
    }

    public void setGerarSpr(boolean gerarSpr) {
        this.gerarSpr = gerarSpr;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
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
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ReceitaDespesa other = (ReceitaDespesa) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
