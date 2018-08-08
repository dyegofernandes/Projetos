/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dizimo.modelo.cadastro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Estado implements Serializable {

    @Id
    @SequenceGenerator(name = "Estado", sequenceName = "estado_seq_id")
    @GeneratedValue(generator = "Estado")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Pais pais;

    @Size(max = 2)
    @NotBlank
    private String sigla;

    @Size(max = 50)
    @NotBlank
    private String nome;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades;

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        if (sigla != null) {
            sigla = sigla.trim().toUpperCase();
        }
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null) {
            nome = nome.trim().toUpperCase();
        }
        this.nome = nome;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Pais getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return nome;
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
        final Estado other = (Estado) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
