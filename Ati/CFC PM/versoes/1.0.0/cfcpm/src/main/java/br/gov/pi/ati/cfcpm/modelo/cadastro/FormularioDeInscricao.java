/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.cfcpm.modelo.cadastro;

import br.gov.pi.ati.cfcpm.modelo.enums.Sexo;
import br.gov.pi.ati.cfcpm.modelo.enums.Situacao;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
public class FormularioDeInscricao implements Serializable {

    @Id
    @SequenceGenerator(name = "FormularioDeInscricao", sequenceName = "formularioDeInscricao_id_seq")
    @GeneratedValue(generator = "FormularioDeInscricao")
    private Long id;

    @Size(max = 256)
    @NotBlank
    private String nome;

    @Size(max = 256)
    @NotBlank
    private String identidade;

    @Size(max = 256)
    @NotBlank
    private String cpf;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataDeNascimento;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataDeNomeacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Size(max = 256)
    @NotBlank
    private String lotacao;

    @Size(max = 400)
    @NotBlank
    private String endereco;

    @Size(max = 256)
    @NotBlank(message = "Número do Endereço é obrigatório")
    private String numero;

    @Size(max = 256)
    @NotBlank(message = "Bairro do Endereço é obrigatório")
    private String bairro;

    @Size(max = 400)
    private String complemento;

    @Size(max = 256)
    @NotBlank(message = "Cidade do Endereço é obrigatório")
    private String cidade;

    @Size(max = 256)
    @NotBlank(message = "Estado do Endereço é obrigatório")
    private String estado;

    @Size(max = 256)
    private String cep;

    @Size(max = 256)
    @NotBlank
    @Email
    private String email;

    @Size(max = 50)
    @NotBlank
    private String telefone;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataInscricao = new Date();

    @NotNull
    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.ENVIADA;

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Date getDataDeNomeacao() {
        return dataDeNomeacao;
    }

    public void setDataDeNomeacao(Date dataDeNomeacao) {
        this.dataDeNomeacao = dataDeNomeacao;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getLotacao() {
        return lotacao;
    }

    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final FormularioDeInscricao other = (FormularioDeInscricao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
