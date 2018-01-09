/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.cadastroBasicos;

import br.com.jsoft.centralfinanceira.modelo.enums.RegimeCONFINS;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoDePessoa;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagar;
import br.com.jsoft.centralfinanceira.modelo.financeiro.Lancamentos;
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
 *
 * @author Juniel
 */
@Entity
@Table(schema = "cadastro")
public class Estabelecimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Empresa empresa;

    @NotNull
    private TipoDePessoa tipo = TipoDePessoa.JURIDICA;

    @Size(max = 80)
    @NotBlank
    private String nome;

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

    @Size(max = 20)
    private String bairro;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade municipio;

    @Size(max = 20)
    private String fone;

    @Size(max = 20)
    private String fax;

    @Size(max = 20)
    private String celular;

    private BigDecimal iss;

    @Size(max = 10)
    private String mNemonico;

    @Size(max = 20)
    private String im;

    @Size(max = 20)
    private String ie;

    private boolean retemIrrf = false;

    private boolean optanteSimples = false;

    private RegimeCONFINS regimeCONFINS;

    private boolean regimeEspecial = false;

    private boolean regimeEspecialICMSSubst = false;

    private boolean incentivoFiscal = false;

    @NotAudited
    @OneToMany(mappedBy = "estabelecimento")
    private List<ContasAPagar> contasAPaga;
    
    @NotAudited
    @OneToMany(mappedBy = "estabelecimento")
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

    public BigDecimal getIss() {
        return iss;
    }

    public void setIss(BigDecimal iss) {
        this.iss = iss;
    }

    public String getmNemonico() {
        return mNemonico;
    }

    public void setmNemonico(String mNemonico) {
        this.mNemonico = mNemonico;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public boolean isRetemIrrf() {
        return retemIrrf;
    }

    public void setRetemIrrf(boolean retemIrrf) {
        this.retemIrrf = retemIrrf;
    }

    public boolean isOptanteSimples() {
        return optanteSimples;
    }

    public void setOptanteSimples(boolean optanteSimples) {
        this.optanteSimples = optanteSimples;
    }

    public RegimeCONFINS getRegimeCONFINS() {
        return regimeCONFINS;
    }

    public void setRegimeCONFINS(RegimeCONFINS regimeCONFINS) {
        this.regimeCONFINS = regimeCONFINS;
    }

    public boolean isRegimeEspecial() {
        return regimeEspecial;
    }

    public void setRegimeEspecial(boolean regimeEspecial) {
        this.regimeEspecial = regimeEspecial;
    }

    public boolean isRegimeEspecialICMSSubst() {
        return regimeEspecialICMSSubst;
    }

    public void setRegimeEspecialICMSSubst(boolean regimeEspecialICMSSubst) {
        this.regimeEspecialICMSSubst = regimeEspecialICMSSubst;
    }

    public boolean isIncentivoFiscal() {
        return incentivoFiscal;
    }

    public void setIncentivoFiscal(boolean incentivoFiscal) {
        this.incentivoFiscal = incentivoFiscal;
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
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Estabelecimento other = (Estabelecimento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}