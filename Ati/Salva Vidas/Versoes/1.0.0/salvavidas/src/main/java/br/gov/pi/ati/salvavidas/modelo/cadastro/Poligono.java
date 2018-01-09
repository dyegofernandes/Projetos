/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.salvavidas.modelo.cadastro;

import br.gov.pi.ati.salvavidas.modelo.enums.TipoPoligono;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Juniel
 */
@Entity
public class Poligono implements Serializable {

    @Id
    @SequenceGenerator(name = "Poligono", sequenceName = "poligono_id_seq")
    @GeneratedValue(generator = "Poligono")
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoPoligono tipo;

    @ManyToMany(targetEntity = Ponto.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    List<Ponto> pontos = new ArrayList<Ponto>();

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

    public List<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    public TipoPoligono getTipo() {
        return tipo;
    }

    public void setTipo(TipoPoligono tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Poligono other = (Poligono) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
