/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import br.gov.pi.ati.siopm.modelo.enums.ClassificacaoPessoaOcorrencia;
import br.gov.pi.ati.siopm.modelo.enums.CorCabelo;
import br.gov.pi.ati.siopm.modelo.enums.CorOlho;
import br.gov.pi.ati.siopm.modelo.enums.Raca;
import br.gov.pi.ati.siopm.modelo.enums.Sexo;
import br.gov.pi.ati.siopm.modelo.enums.TipoPessoa;
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
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class PessoaEnvolvida implements Serializable {

    @Id
    @SequenceGenerator(name = "PessoaEnvolvida", sequenceName = "pessoaEnvolvida_id_seq")
    @GeneratedValue(generator = "PessoaEnvolvida")
    private Long id;

    @Size(max = 260)
    private String nome;

    @Size(max = 60)
    private String rg;
    
    private String descricao;
    
    private String cpf;
    
    private String cnh;

    @Size(max = 260)
    private String nomeDaMae;

    @Size(max = 260)
    private String nomeDoPai;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    private String naturalidade;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private CorOlho corDosOlhos;

    @Enumerated(EnumType.STRING)
    private CorCabelo corDoCabelo;

    @Enumerated(EnumType.STRING)
    private Raca raca;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @Enumerated(EnumType.STRING)
    private ClassificacaoPessoaOcorrencia classificaoOcorrencia;

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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public CorOlho getCorDosOlhos() {
        return corDosOlhos;
    }

    public void setCorDosOlhos(CorOlho corDosOlhos) {
        this.corDosOlhos = corDosOlhos;
    }

    public CorCabelo getCorDoCabelo() {
        return corDoCabelo;
    }

    public void setCorDoCabelo(CorCabelo corDoCabelo) {
        this.corDoCabelo = corDoCabelo;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public ClassificacaoPessoaOcorrencia getClassificaoOcorrencia() {
        return classificaoOcorrencia;
    }

    public void setClassificaoOcorrencia(ClassificacaoPessoaOcorrencia classificaoOcorrencia) {
        this.classificaoOcorrencia = classificaoOcorrencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final PessoaEnvolvida other = (PessoaEnvolvida) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
