/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.orcamento;

import br.gov.pi.ati.modelo.cadastro.Produto;
import br.gov.pi.ati.modelo.cadastro.ProgramaPPA;
import br.gov.pi.ati.modelo.cadastro.UnidadeDeMedida;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class MetaPPA implements Serializable {

    @Id
    @SequenceGenerator(name = "MetaPPA", sequenceName = "metaPPA_id_seq")
    @GeneratedValue(generator = "MetaPPA")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private ProgramaPPA programa;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private UnidadeDeMedida unidadeMedida;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private BigDecimal valorMeta;

    @ManyToMany(targetEntity = Ldo.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Ldo> ldos = new ArrayList<Ldo>();

    @ManyToMany(targetEntity = TerritorioPPA.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<TerritorioPPA> territorios = new ArrayList<TerritorioPPA>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProgramaPPA getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaPPA programa) {
        this.programa = programa;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public UnidadeDeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeDeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public BigDecimal getValorMeta() {
        return valorMeta;
    }

    public void setValorMeta(BigDecimal valorMeta) {
        this.valorMeta = valorMeta;
    }

    public List<Ldo> getLdos() {
        return ldos;
    }

    public void setLdos(List<Ldo> ldos) {
        this.ldos = ldos;
    }

    public List<TerritorioPPA> getTerritorios() {
        return territorios;
    }

    public void setTerritorios(List<TerritorioPPA> territorios) {
        this.territorios = territorios;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final MetaPPA other = (MetaPPA) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
