/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.cadastroBasicos;

import br.com.jsoft.centralfinanceira.modelo.enums.FinalidadeDoc;
import br.com.jsoft.centralfinanceira.modelo.enums.FinalidadeTed;
import br.com.jsoft.centralfinanceira.modelo.enums.Leiaute;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoContaBanco;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoDePessoa;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagar;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagarVencimentos;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ReceitaDespesa;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
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
 * dbo.FRN
 *
 * @author Juniel
 */
@Entity
@Table(schema = "cadastro")
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Empresa empresa;

    @NotNull
    private TipoDePessoa tipo = TipoDePessoa.JURIDICA;

    @Size(max = 40)
    @NotBlank
    private String nome;

    @Size(max = 40)
    private String nomeFantasia;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private GrupoFornecedor grupoFornecedor;

    @ManyToOne(fetch = FetchType.LAZY)
    private ReceitaDespesa receitaDespesa;

    @Size(max = 14)
    private String cnpjCpf;

    @Size(max = 9)
    private String cep;

    @Size(max = 60)
    private String logradouro;

    @Size(max = 10)
    private String numero;

    @Size(max = 20)
    private String complemento;

    @Size(max = 30)
    private String bairro;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade municipio;

    @Size(max = 20)
    private String fone;

    @Size(max = 20)
    private String fax;

    @Size(max = 20)
    private String celular;

    @Size(max = 60)
    private String site;

    @Size(max = 30)
    private String contato;

    @Size(max = 255)
    private String obs;

    @Size(max = 15)
    private String contaContabil;

    @ManyToOne(fetch = FetchType.LAZY)
    private Banco banco;

    @Size(max = 10)
    private String agencia;

    @Size(max = 2)
    private String dvAgencia;

    @Size(max = 10)
    private String contaCorrente;

    @Size(max = 2)
    private String dvContaCorrente;

    private TipoContaBanco tipoDeConta = TipoContaBanco.CC;

    @Size(max = 20)
    private String im;

    @Size(max = 20)
    private String ie;

    @Size(max = 20)
    private String rg;

    @Size(max = 100)
    private String referencia;

    private BigDecimal descPrevisto;

    private boolean enviarEmail = false;

    private boolean exterior = false;

    private boolean icms = false;

    private boolean servicoPublico = false;

    private FinalidadeTed finalidadeTed;

    @NotNull
    private FinalidadeDoc finalidadeDoc;

    @NotNull
    private Leiaute leiaute;

    @Size(max = 255)
    private String email;

    private boolean calcInssEmp = false;

    private BigDecimal aliqInss;

    @NotAudited
    @OneToMany(mappedBy = "fornecedor")
    private List<Representante> representantes;

    @NotAudited
    @OneToMany(mappedBy = "fornecedor")
    private List<Transportadora> transportadoras;

    @NotAudited
    @OneToMany(mappedBy = "fornecedor")
    private List<ContasAPagar> contasAPaga;

    @NotAudited
    @OneToMany(mappedBy = "fornecedor")
    private List<ContasAPagarVencimentos> contasAPagarVencimentos;

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

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public TipoDePessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoDePessoa tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public ReceitaDespesa getReceitaDespesa() {
        return receitaDespesa;
    }

    public void setReceitaDespesa(ReceitaDespesa receitaDespesa) {
        this.receitaDespesa = receitaDespesa;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Cidade municipio) {
        this.municipio = municipio;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getContaContabil() {
        return contaContabil;
    }

    public void setContaContabil(String contaContabil) {
        this.contaContabil = contaContabil;
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

    public String getDvAgencia() {
        return dvAgencia;
    }

    public void setDvAgencia(String dvAgencia) {
        this.dvAgencia = dvAgencia;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public String getDvContaCorrente() {
        return dvContaCorrente;
    }

    public void setDvContaCorrente(String dvContaCorrente) {
        this.dvContaCorrente = dvContaCorrente;
    }

    public TipoContaBanco getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(TipoContaBanco tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public BigDecimal getDescPrevisto() {
        return descPrevisto;
    }

    public void setDescPrevisto(BigDecimal descPrevisto) {
        this.descPrevisto = descPrevisto;
    }

    public boolean isEnviarEmail() {
        return enviarEmail;
    }

    public void setEnviarEmail(boolean enviarEmail) {
        this.enviarEmail = enviarEmail;
    }

    public boolean isExterior() {
        return exterior;
    }

    public void setExterior(boolean exterior) {
        this.exterior = exterior;
    }

    public boolean isIcms() {
        return icms;
    }

    public void setIcms(boolean icms) {
        this.icms = icms;
    }

    public boolean isServicoPublico() {
        return servicoPublico;
    }

    public void setServicoPublico(boolean servicoPublico) {
        this.servicoPublico = servicoPublico;
    }

    public FinalidadeTed getFinalidadeTed() {
        return finalidadeTed;
    }

    public void setFinalidadeTed(FinalidadeTed finalidadeTed) {
        this.finalidadeTed = finalidadeTed;
    }

    public FinalidadeDoc getFinalidadeDoc() {
        return finalidadeDoc;
    }

    public void setFinalidadeDoc(FinalidadeDoc finalidadeDoc) {
        this.finalidadeDoc = finalidadeDoc;
    }

    public Leiaute getLeiaute() {
        return leiaute;
    }

    public void setLeiaute(Leiaute leiaute) {
        this.leiaute = leiaute;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCalcInssEmp() {
        return calcInssEmp;
    }

    public void setCalcInssEmp(boolean calcInssEmp) {
        this.calcInssEmp = calcInssEmp;
    }

    public BigDecimal getAliqInss() {
        return aliqInss;
    }

    public void setAliqInss(BigDecimal aliqInss) {
        this.aliqInss = aliqInss;
    }

    public List<Representante> getRepresentantes() {
        return representantes;
    }

    public void setRepresentantes(List<Representante> representantes) {
        this.representantes = representantes;
    }

    public List<Transportadora> getTransportadoras() {
        return transportadoras;
    }

    public void setTransportadoras(List<Transportadora> transportadoras) {
        this.transportadoras = transportadoras;
    }

    public List<ContasAPagar> getContasAPaga() {
        return contasAPaga;
    }

    public void setContasAPaga(List<ContasAPagar> contasAPaga) {
        this.contasAPaga = contasAPaga;
    }

    public GrupoFornecedor getGrupoFornecedor() {
        return grupoFornecedor;
    }

    public void setGrupoFornecedor(GrupoFornecedor grupoFornecedor) {
        this.grupoFornecedor = grupoFornecedor;
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
        final Fornecedor other = (Fornecedor) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}