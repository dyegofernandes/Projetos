/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.cadastroBasicos;

import br.com.jsoft.centralfinanceira.modelo.enums.TipoComissao;
import br.com.jsoft.centralfinanceira.modelo.enums.TipoDePessoa;
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
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * dbo.VRP
 *
 * @author Juniel
 */
@Entity
@Table(schema = "cadastro")
public class Representante implements Serializable {

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

    @Size(max = 14)
    private String cnpjCpf;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private TabelaDeComissao tabelaDeComissao;

    @NotNull
    private TipoComissao tipoComissao;

    @Size(max = 9)
    private String cep;

    @Size(max = 60)
    private String logradouro;

    @Size(max = 10)
    private String numero;

    @Size(max = 20)
    private String complemento;

    @Size(max = 14)
    private String bairro;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade municipio;

    @Size(max = 20)
    private String fone;

    @Size(max = 20)
    private String fax;

    @Size(max = 20)
    private String celular;

    @Size(max = 30)
    private String contato;

    @Size(max = 80)
    private String obs;

    @Email
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private Fornecedor fornecedor;

    private boolean vencimento = false;

    private boolean retemIRRF = false;

    @Size(max = 100)
    private String referencia;

    @NotAudited
    @OneToMany(mappedBy = "representante")
    private List<Cliente> clientes;

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

    public TabelaDeComissao getTabelaDeComissao() {
        return tabelaDeComissao;
    }

    public void setTabelaDeComissao(TabelaDeComissao tabelaDeComissao) {
        this.tabelaDeComissao = tabelaDeComissao;
    }

    public TipoComissao getTipoComissao() {
        return tipoComissao;
    }

    public void setTipoComissao(TipoComissao tipoComissao) {
        this.tipoComissao = tipoComissao;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public boolean isVencimento() {
        return vencimento;
    }

    public void setVencimento(boolean vencimento) {
        this.vencimento = vencimento;
    }

    public boolean isRetemIRRF() {
        return retemIRRF;
    }

    public void setRetemIRRF(boolean retemIRRF) {
        this.retemIRRF = retemIRRF;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Representante other = (Representante) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
