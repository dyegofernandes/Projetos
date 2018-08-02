/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facilpagar.modelo.dados;

import br.com.facilpagar.modelo.enums.TipoPessoa;
import br.com.facilpagar.util.Utils;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(schema = "dados")
public class Cliente implements Serializable {

    @Id
    @SequenceGenerator(schema = "dados", allocationSize = 1, name = "Cliente", sequenceName = "dados.seq_cliente_id")
    @GeneratedValue(generator = "Cliente")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Convenio convenio;

    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipo_pessoa = TipoPessoa.PJ;

    @Size(max = 14)
    private String cpf_cnpj;

    @Size(max = 100)
    @NotBlank
    private String nome_fantasia;

    @Size(max = 100)
    @NotBlank
    private String completo_razao_social;

    @Size(max = 15)
    private String insc_est_rg;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dt_nascimento;

    @Size(max = 100)
    private String endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cidade cidade;

    @Size(max = 100)
    private String bairro;

    @Size(max = 9)
    private String cep;

    @Size(max = 100)
    private String telefones;

    @Size(max = 100)
    @Email
    private String email;

    private String obs;

    private boolean ativo = true;

    @NotAudited
    @OneToMany(mappedBy = "cliente")
    private List<Boleto> boletos;

    @Override
    public String toString() {
    /*    if (!Utils.isNullOrEmpty(cpf_cnpj) && !Utils.isNullOrEmpty(nome_fantasia)) {
            String pattern;
            if (cpf_cnpj.length() > 11) {
                pattern = "##.###.###/####-##";
            } else {
                pattern = "###.###.###-##";
            }
            return Utils.format(pattern, cpf_cnpj).concat(" - ").concat(nome_fantasia);
        }*/
        return nome_fantasia; 
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

    public TipoPessoa getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(TipoPessoa tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getCompleto_razao_social() {
        return completo_razao_social;
    }

    public void setCompleto_razao_social(String completo_razao_social) {
        this.completo_razao_social = completo_razao_social;
    }

    public String getInsc_est_rg() {
        return insc_est_rg;
    }

    public void setInsc_est_rg(String insc_est_rg) {
        this.insc_est_rg = insc_est_rg;
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
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

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }
}
