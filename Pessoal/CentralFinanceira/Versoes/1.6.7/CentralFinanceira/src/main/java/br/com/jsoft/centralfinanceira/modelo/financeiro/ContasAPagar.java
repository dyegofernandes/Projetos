/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.financeiro;

import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ContaFinanceira;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Estabelecimento;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Fornecedor;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.HistoricoPadrao;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.TipoDocumento;
import com.xpert.audit.NotAudited;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * dbo.CPG
 *
 * @author Juniel
 */
@Entity
@Table(schema = "ag")
public class ContasAPagar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Estabelecimento estabelecimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Fornecedor fornecedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private TipoDocumento tipoDeDocumento;
    
    private String documento;

    @ManyToOne(fetch = FetchType.LAZY)
    private CentroResultados centroResultado;

    @ManyToOne(fetch = FetchType.LAZY)
    private ReceitaDespesa receitaDespesa;

    @ManyToOne(fetch = FetchType.LAZY)
    private ContaFinanceira contaFinanceira;

    private String obs;

    @ManyToOne(fetch = FetchType.LAZY)
    private HistoricoPadrao historicoPadrao;

    private BigDecimal issBase;

    private BigDecimal issValor;

    private BigDecimal irrfBase;

    private BigDecimal irrfCpf;

    private BigDecimal irrfCnpj;

    private BigDecimal icmsBase;

    private BigDecimal icmsValor;

    private BigDecimal pisBase;

    private BigDecimal pisValor;

    private BigDecimal inssBase;

    private BigDecimal inssCpf;

    private BigDecimal inssCnpj;

    private BigDecimal inssEmp;

    private BigDecimal valor;

    private BigDecimal valorBruto;

    private boolean exportaAC = true;

    @Size(max = 6)
    private String anoMesComp;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date entrada = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date emissao = new Date();

    @NotAudited
    @OneToMany(mappedBy = "contasAPagar")
    private List<ContasAPagarVencimentos> contasAPagarVencimentos;
    
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

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public TipoDocumento getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(TipoDocumento tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
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

    public ContaFinanceira getContaFinanceira() {
        return contaFinanceira;
    }

    public void setContaFinanceira(ContaFinanceira contaFinanceira) {
        this.contaFinanceira = contaFinanceira;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public HistoricoPadrao getHistoricoPadrao() {
        return historicoPadrao;
    }

    public void setHistoricoPadrao(HistoricoPadrao historicoPadrao) {
        this.historicoPadrao = historicoPadrao;
    }

    public BigDecimal getIssBase() {
        return issBase;
    }

    public void setIssBase(BigDecimal issBase) {
        this.issBase = issBase;
    }

    public BigDecimal getIssValor() {
        return issValor;
    }

    public void setIssValor(BigDecimal issValor) {
        this.issValor = issValor;
    }

    public BigDecimal getIrrfBase() {
        return irrfBase;
    }

    public void setIrrfBase(BigDecimal irrfBase) {
        this.irrfBase = irrfBase;
    }

    public BigDecimal getIrrfCpf() {
        return irrfCpf;
    }

    public void setIrrfCpf(BigDecimal irrfCpf) {
        this.irrfCpf = irrfCpf;
    }

    public BigDecimal getIrrfCnpj() {
        return irrfCnpj;
    }

    public void setIrrfCnpj(BigDecimal irrfCnpj) {
        this.irrfCnpj = irrfCnpj;
    }

    public BigDecimal getIcmsBase() {
        return icmsBase;
    }

    public void setIcmsBase(BigDecimal icmsBase) {
        this.icmsBase = icmsBase;
    }

    public BigDecimal getIcmsValor() {
        return icmsValor;
    }

    public void setIcmsValor(BigDecimal icmsValor) {
        this.icmsValor = icmsValor;
    }

    public BigDecimal getPisBase() {
        return pisBase;
    }

    public void setPisBase(BigDecimal pisBase) {
        this.pisBase = pisBase;
    }

    public BigDecimal getPisValor() {
        return pisValor;
    }

    public void setPisValor(BigDecimal pisValor) {
        this.pisValor = pisValor;
    }

    public BigDecimal getInssBase() {
        return inssBase;
    }

    public void setInssBase(BigDecimal inssBase) {
        this.inssBase = inssBase;
    }

    public BigDecimal getInssCpf() {
        return inssCpf;
    }

    public void setInssCpf(BigDecimal inssCpf) {
        this.inssCpf = inssCpf;
    }

    public BigDecimal getInssCnpj() {
        return inssCnpj;
    }

    public void setInssCnpj(BigDecimal inssCnpj) {
        this.inssCnpj = inssCnpj;
    }

    public BigDecimal getInssEmp() {
        return inssEmp;
    }

    public void setInssEmp(BigDecimal inssEmp) {
        this.inssEmp = inssEmp;
    }

    public boolean isExportaAC() {
        return exportaAC;
    }

    public void setExportaAC(boolean exportaAC) {
        this.exportaAC = exportaAC;
    }

    public String getAnoMesComp() {
        return anoMesComp;
    }

    public void setAnoMesComp(String anoMesComp) {
        this.anoMesComp = anoMesComp;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<ContasAPagarVencimentos> getContasAPagarVencimentos() {
        return contasAPagarVencimentos;
    }

    public void setContasAPagarVencimentos(List<ContasAPagarVencimentos> contasAPagarVencimentos) {
        this.contasAPagarVencimentos = contasAPagarVencimentos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ContasAPagar other = (ContasAPagar) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
