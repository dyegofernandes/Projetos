/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.orcamento;

import br.gov.pi.ati.modelo.cadastro.Produto;
import br.gov.pi.ati.modelo.cadastro.Territorio;
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
    private Integer ano;

    @NotNull
    private BigDecimal metaPPA;

    @NotNull
    private BigDecimal metaLDO;

    private BigDecimal metaRealizada; //Se despesas estiver com status homologado=true

    @ManyToMany(targetEntity = Territorio.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Territorio> territorios = new ArrayList<Territorio>();

    @OneToMany(mappedBy = "produtoLDO")
    @NotAudited
    private List<Dotacao> dotacoes;

    @OneToMany(mappedBy = "produtoLDO")
    @NotAudited
    private List<DespesaPublica> despesasPublicas;

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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public BigDecimal getMetaPPA() {
        return metaPPA;
    }

    public void setMetaPPA(BigDecimal metaPPA) {
        this.metaPPA = metaPPA;
    }

    public BigDecimal getMetaLDO() {
        return metaLDO;
    }

    public void setMetaLDO(BigDecimal metaLDO) {
        this.metaLDO = metaLDO;
    }

    public List<Territorio> getTerritorios() {
        return territorios;
    }

    public void setTerritorios(List<Territorio> territorios) {
        this.territorios = territorios;
    }

    public List<Dotacao> getDotacoes() {
        return dotacoes;
    }

    public void setDotacoes(List<Dotacao> dotacoes) {
        this.dotacoes = dotacoes;
    }

    public List<DespesaPublica> getDespesasPublicas() {
        return despesasPublicas;
    }

    public void setDespesasPublicas(List<DespesaPublica> despesasPublicas) {
        this.despesasPublicas = despesasPublicas;
    }

    public BigDecimal getMetaRealizada() {
        return metaRealizada;
    }

    public void setMetaRealizada(BigDecimal metaRealizada) {
        this.metaRealizada = metaRealizada;
    }

    public BigDecimal getGap() {
        BigDecimal valor = BigDecimal.ZERO;

        if (metaLDO != null) {
            valor = valor.add(metaLDO);
        }

        if (metaRealizada != null) {
            valor = valor.subtract(metaRealizada);
        }

        return valor;
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
