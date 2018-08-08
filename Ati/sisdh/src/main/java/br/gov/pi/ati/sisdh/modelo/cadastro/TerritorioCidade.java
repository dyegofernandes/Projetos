/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.cadastro;

import com.xpert.audit.NotAudited;
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
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class TerritorioCidade implements Serializable {

    @Id
    @SequenceGenerator(name = "TerritorioCidade", sequenceName = "seq_territorio_cidade")
    @GeneratedValue(generator = "TerritorioCidade")
    private Long id;

    @Size(max = 80)
    @NotBlank
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cidade baseMunicipal;

    private String latitude;

    private String longitude;

    @ManyToMany(targetEntity = Cidade.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Cidade> cidades = new ArrayList<Cidade>();

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

    public Cidade getBaseMunicipal() {
        return baseMunicipal;
    }

    public void setBaseMunicipal(Cidade baseMunicipal) {
        this.baseMunicipal = baseMunicipal;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final TerritorioCidade other = (TerritorioCidade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
