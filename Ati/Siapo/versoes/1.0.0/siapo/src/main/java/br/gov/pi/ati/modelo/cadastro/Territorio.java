/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro;

import br.gov.pi.ati.modelo.orcamento.TerritorioPPA;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Territorio implements Serializable {

    @Id
    @SequenceGenerator(name = "Territorio", sequenceName = "territorio_id_seq")
    @GeneratedValue(generator = "Territorio")
    private Long id;

    @Size(max = 50)
    @NotBlank
    private String codigo;

    @Size(max = 250)
    @NotBlank
    private String nome;

    private boolean ativo = true;

    @OneToMany(targetEntity = Municipio.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(name = "territorio_municipio",
    joinColumns = { @JoinColumn(name = "territorio_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "municipios_id") })
    private List<Municipio> municipios = new ArrayList<Municipio>();

    @OneToMany(mappedBy = "territorio")
    @NotAudited
    private List<TerritorioPPA> territoriosPpa;

    @Override
    public String toString() {
        return codigo.concat(" - ").concat(nome);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<TerritorioPPA> getTerritoriosPpa() {
        return territoriosPpa;
    }

    public void setTerritoriosPpa(List<TerritorioPPA> territoriosPpa) {
        this.territoriosPpa = territoriosPpa;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.id != null ? this.id.hashCode() : 0);
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
