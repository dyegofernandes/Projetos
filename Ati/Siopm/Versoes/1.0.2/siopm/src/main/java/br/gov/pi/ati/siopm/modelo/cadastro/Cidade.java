/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import java.io.Serializable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
//@Entity
public class Cidade implements Serializable {

    @Id
    @SequenceGenerator(name = "Cidade", allocationSize = 1, sequenceName = "cidade_id_seq")
    @GeneratedValue(generator = "Cidade")
    private Long id;

    @Size(max = 150)
    @NotBlank
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Estado estado;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private TerritorioPorCidade territorioPorCidade;

//    @NotAudited
//    @OrderBy("nome")
//    @OneToMany(mappedBy = "cidade")
//    private List<Bairro> bairros;
//
//    @NotAudited
//    @OneToMany(mappedBy = "cidade")
//    private List<Logradouro> logradouros;

//    @NotAudited
//    @OneToMany(mappedBy = "baseMunicipal")
//    private List<TerritorioPorCidade> circus_cidades;

//    @NotAudited
//    @OneToMany(mappedBy = "cidade")
//    private List<Cabina> cabines;

//    @NotAudited
//    @OneToMany(mappedBy = "naturalidade")
//    private List<PessoaEnvolvida> pessoasEnvolvidas;

//    @NotAudited
//    @OneToMany(mappedBy = "municipio")
//    private List<QualificacaoDeVeiculo> qualiticacoes;

   
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Cidade other = (Cidade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

   
}
