/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.cfcpm.modelo.cadastro;

import br.gov.pi.ati.cfcpm.modelo.enums.CidadeSAV;
import br.gov.pi.ati.cfcpm.modelo.enums.Sexo;
import br.gov.pi.ati.cfcpm.modelo.enums.Situacao;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class FormularioInscricaoSAV implements Serializable {

    @Id
    @SequenceGenerator(name = "FormularioInscricaoSAV", sequenceName = "formularioInscricaoSAV_id_seq")
    @GeneratedValue(generator = "FormularioInscricaoSAV")
    private Long id;

    @Size(max = 256)
    @NotBlank
    private String nome;

    @Size(max = 256)
    @NotBlank
    private String matricula;

    @Size(max = 256)
    @NotBlank
    private String identidade;

    @Size(max = 256)
    @NotBlank
    private String orgao;

    @Size(max = 256)
    @NotBlank
    private String cpf;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataDeNascimento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Size(max = 256)
    @NotBlank
    private String escolaridade;

    @Size(max = 256)
    @NotBlank
    private String endereco;

    @Size(max = 100)
    @NotBlank
    private String cidade;

    @Size(max = 20)
    @NotBlank
    private String telefone;

    @Size(max = 256)
    @NotBlank
    @Email
    private String email;

    @NotNull
    private BigDecimal altura = BigDecimal.ZERO;

//    @NotNull
    @Enumerated(EnumType.STRING)
    private CidadeSAV opcaoCidade;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.ENVIADA;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataInscricao = new Date();

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

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
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

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public CidadeSAV getOpcaoCidade() {
        return opcaoCidade;
    }

    public void setOpcaoCidade(CidadeSAV opcaoCidade) {
        this.opcaoCidade = opcaoCidade;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final FormularioInscricaoSAV other = (FormularioInscricaoSAV) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
