/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.modelo.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class Setor implements Serializable {

    @Id
    @SequenceGenerator(name = "Setor", sequenceName = "setor_id_seq")
    @GeneratedValue(generator = "Setor")
    private Long id;

    @Size(max = 50)
//    @NotBlank
    private String nome;

//    @NotNull
    private Integer quantidadeLinhas;

//    @NotNull
    private Integer quantidadeColunas;

    @ManyToMany(targetEntity = Assento.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Assento> assentos = new ArrayList<Assento>();

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

    public Integer getQuantidadeLinhas() {
        return quantidadeLinhas;
    }

    public void setQuantidadeLinhas(Integer quantidadeLinhas) {
        this.quantidadeLinhas = quantidadeLinhas;
    }

    public Integer getQuantidadeColunas() {
        return quantidadeColunas;
    }

    public void setQuantidadeColunas(Integer quantidadeColunas) {
        this.quantidadeColunas = quantidadeColunas;
    }

    public List<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(List<Assento> assentos) {
        this.assentos = assentos;
    }

    public Integer getQuantidadeCadeiras() {
        return (quantidadeColunas * quantidadeLinhas);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Setor other = (Setor) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
