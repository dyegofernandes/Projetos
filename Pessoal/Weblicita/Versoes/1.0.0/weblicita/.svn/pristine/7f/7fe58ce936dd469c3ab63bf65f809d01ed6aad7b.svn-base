/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.weblicita.modelo.licitacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class PesquisaDePreco implements Serializable {

    @Id
    @SequenceGenerator(name = "PesquisaDePreco", allocationSize = 1, sequenceName = "pesquisaDePreco_id_seq")
    @GeneratedValue(generator = "PesquisaDePreco")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private PedidoLicitacao processoAdministrativo;

    @ManyToMany(targetEntity = Proponente.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Proponente> proponentes = new ArrayList<Proponente>();

    @Column(columnDefinition = "Text")
    private String observacao;

    @ManyToMany(targetEntity = Licitante.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Licitante> licitantes = new ArrayList<Licitante>();

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataInclusao = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PedidoLicitacao getProcessoAdministrativo() {
        return processoAdministrativo;
    }

    public void setProcessoAdministrativo(PedidoLicitacao processoAdministrativo) {
        this.processoAdministrativo = processoAdministrativo;
    }

    public List<Proponente> getProponentes() {
        return proponentes;
    }

    public void setProponentes(List<Proponente> proponentes) {
        this.proponentes = proponentes;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Licitante> getLicitantes() {
        return licitantes;
    }

    public void setLicitantes(List<Licitante> licitantes) {
        this.licitantes = licitantes;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final PesquisaDePreco other = (PesquisaDePreco) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
