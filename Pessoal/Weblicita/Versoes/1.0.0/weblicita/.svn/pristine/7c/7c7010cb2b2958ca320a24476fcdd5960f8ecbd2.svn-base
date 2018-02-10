/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.weblicita.modelo.licitacao;

import br.com.weblicita.modelo.cadastro.Fornecedor;
import br.com.weblicita.modelo.controleacesso.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
 *
 */
@Entity
public class HomolagacaoAtaAdjucao implements Serializable {

    @Id
    @SequenceGenerator(name = "HomolagacaoAtaAdjucao", allocationSize = 1, sequenceName = "homolagacaoAtaAdjucao_id_seq")
    @GeneratedValue(generator = "HomolagacaoAtaAdjucao")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PedidoLicitacao pedidoLicitacao;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataCriacao = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date ultimaGeracao = new Date();

    @ManyToMany(targetEntity = Fornecedor.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Fornecedor> vencedores = new ArrayList<Fornecedor>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PedidoLicitacao getPedidoLicitacao() {
        return pedidoLicitacao;
    }

    public void setPedidoLicitacao(PedidoLicitacao pedidoLicitacao) {
        this.pedidoLicitacao = pedidoLicitacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getUltimaGeracao() {
        return ultimaGeracao;
    }

    public void setUltimaGeracao(Date ultimaGeracao) {
        this.ultimaGeracao = ultimaGeracao;
    }

    public List<Fornecedor> getVencedores() {
        return vencedores;
    }

    public void setVencedores(List<Fornecedor> vencedores) {
        this.vencedores = vencedores;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final HomolagacaoAtaAdjucao other = (HomolagacaoAtaAdjucao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
