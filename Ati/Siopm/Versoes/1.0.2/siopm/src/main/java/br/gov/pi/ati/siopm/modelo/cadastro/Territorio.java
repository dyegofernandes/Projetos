/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Territorio implements Serializable {

    @Id
    @SequenceGenerator(name = "Territorio", allocationSize = 1, sequenceName = "territorio_id_seq")
    @GeneratedValue(generator = "Territorio")
    private Long id;

    @NotBlank
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Territorio territorioPai;

    /**
     * iniciar com valor padrao 0
     */
    private Integer ordenacao = 0;

    @ManyToMany(targetEntity = Poligono.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Poligono> poligonos = new ArrayList<Poligono>();

    @OrderBy(value = "nome")
    @OneToMany(mappedBy = "territorioPai")
    private List<Territorio> filhos = new ArrayList<Territorio>();

    private boolean ativo = true;

    public Long getId() {
        return id;
    }

    public Territorio getTerritorioPai() {
        return territorioPai;
    }

    public void setTerritorioPai(Territorio territorioPai) {
        this.territorioPai = territorioPai;
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

    public List<Poligono> getPoligonos() {
        return poligonos;
    }

    public void setPoligonos(List<Poligono> poligonos) {
        this.poligonos = poligonos;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getOrdenacao() {
        return ordenacao;
    }

    public void setOrdenacao(Integer ordenacao) {
        this.ordenacao = ordenacao;
    }

    public List<Territorio> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<Territorio> filhos) {
        this.filhos = filhos;
    }

    @Override
    public String toString() {
        return nome;
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
        final Territorio other = (Territorio) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
