/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.orcamento;

import br.gov.pi.ati.modelo.cadastro.Produto;
import br.gov.pi.ati.modelo.cadastro.UnidadeDeMedida;
import com.xpert.audit.NotAudited;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class MetaProduto implements Serializable {

    @Id
    @SequenceGenerator(name = "MetaProduto", sequenceName = "metaProduto_id_seq")
    @GeneratedValue(generator = "MetaProduto")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private MetaAcaoEstrategica metaAcao;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private UnidadeDeMedida unidadeMedida;

    @NotNull
    private BigDecimal valorMeta;

    @ManyToMany(targetEntity = Ldo.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Ldo> ldos = new ArrayList<Ldo>();

    @OneToMany(mappedBy = "produtoLDO")
    @NotAudited
    private List<Dotacao> dotacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MetaAcaoEstrategica getMetaAcao() {
        return metaAcao;
    }

    public void setMetaAcao(MetaAcaoEstrategica metaAcao) {
        this.metaAcao = metaAcao;
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

    public List<Dotacao> getDotacoes() {
        return dotacoes;
    }

    public void setDotacoes(List<Dotacao> dotacoes) {
        this.dotacoes = dotacoes;
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
        final MetaProduto other = (MetaProduto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
