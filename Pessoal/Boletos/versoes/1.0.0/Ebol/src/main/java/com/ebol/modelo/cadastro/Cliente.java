/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.cadastro;

import com.ebol.modelo.enuns.TipoPessoa;
import com.ebol.modelo.venda.Boleto;
import com.ebol.modelo.venda.Venda;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "cadastro")
public class Cliente implements Serializable {

    @Id
    @SequenceGenerator(schema="cadastro", allocationSize = 1, name = "PessoaOp", sequenceName = "pessoaop_id_seq")
    @GeneratedValue(generator = "PessoaOp")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Convenio convenio;

    @NotNull
    private TipoPessoa fisicOujur = TipoPessoa.PESSOAFISICA;

    @Size(max = 14)
    private String cpfOrCnpj;

    @Size(max = 100)
    @NotBlank
    private String nomeOuFantasia; //Nome/apelido (se pessoa física) ou nome fantasia

    @Size(max = 100)
    @NotBlank
    private String completoOuRsocial; //Nome completo/sobrenome ou razão social

    @Size(max = 15)
    private String inscestOuRg;

    @Temporal(TemporalType.DATE)
    private Date nascimento; //data de nascimento ou fundação (pessoa jurídica)

    @Size(max = 100)
    private String endereco;

    @Size(max = 100)
    private String bairro;

    @Size(max = 10)
    private String cep;

    @Size(max = 100)
    private String telefones;

    @Size(max = 100)
    @Email
    private String email;

    private String obs;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Cidade cidade;

    private boolean ativo = true;

    @NotAudited
    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;
    
    @NotAudited
    @OneToMany(mappedBy = "cliente")
    private List<Boleto> boletos;
       

    @Override
    public String toString() {
        return completoOuRsocial;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public TipoPessoa getFisicOujur() {
        return fisicOujur;
    }

    public void setFisicOujur(TipoPessoa fisicOujur) {
        this.fisicOujur = fisicOujur;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public String getNomeOuFantasia() {
        return nomeOuFantasia;
    }

    public void setNomeOuFantasia(String nomeOuFantasia) {
        this.nomeOuFantasia = nomeOuFantasia;
    }

    public String getCompletoOuRsocial() {
        return completoOuRsocial;
    }

    public void setCompletoOuRsocial(String completoOuRsocial) {
        this.completoOuRsocial = completoOuRsocial;
    }

    public String getInscestOuRg() {
        return inscestOuRg;
    }

    public void setInscestOuRg(String inscestOuRg) {
        this.inscestOuRg = inscestOuRg;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

}
