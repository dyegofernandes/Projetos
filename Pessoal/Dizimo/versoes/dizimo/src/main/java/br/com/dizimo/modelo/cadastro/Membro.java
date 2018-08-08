/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dizimo.modelo.cadastro;

import br.com.dizimo.modelo.enums.EstadoCivil;
import br.com.dizimo.modelo.enums.Sexo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Membro implements Serializable, Comparable<Membro> {

    @Id
    @SequenceGenerator(name = "Membro", sequenceName = "membro_seq_id")
    @GeneratedValue(generator = "Membro")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Sede sede;

    @Size(max = 250)
    @NotBlank
    private String nomeUsual;

    @Size(max = 250)
    @NotBlank
    private String nome;

    @Size(max = 50)
    @NotBlank
    private String codigo;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Endereco endereco = new Endereco();

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataCadastro = new Date();

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Temporal(TemporalType.DATE)
    private Date dataCasamento;

    private String nomeConjuge;

    private Integer quantidadeFilhos;

    private boolean ativo = true;

    @Override
    public String toString() {
        return nomeUsual; //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getNomeUsual() {
        return nomeUsual;
    }

    public void setNomeUsual(String nomeUsual) {
        this.nomeUsual = nomeUsual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getDataCasamento() {
        return dataCasamento;
    }

    public void setDataCasamento(Date dataCasamento) {
        this.dataCasamento = dataCasamento;
    }

    public String getNomeConjuge() {
        return nomeConjuge;
    }

    public void setNomeConjuge(String nomeConjuge) {
        this.nomeConjuge = nomeConjuge;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getQuantidadeFilhos() {
        return quantidadeFilhos;
    }

    public void setQuantidadeFilhos(Integer quantidadeFilhos) {
        this.quantidadeFilhos = quantidadeFilhos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Membro other = (Membro) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Membro o) {
        return this.nomeUsual.compareTo(o.nomeUsual);
    }

}
