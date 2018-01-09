/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.weblicita.modelo.licitacao;

import br.com.weblicita.modelo.cadastro.TipoModalidade;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class SituacaoPedidoLicitacao implements Serializable {

    @Id
    @SequenceGenerator(name = "SituacaoPedidoLicitacao", allocationSize = 1, sequenceName = "situacaoPedidoLicitacao_id_seq")
    @GeneratedValue(generator = "SituacaoPedidoLicitacao")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoModalidade tipoModalidade;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataDefinicao = new Date();

    private boolean ativo = true;
    
    @NotAudited
    @OneToMany(mappedBy = "situacao")
    private List<PedidoLicitacao> pedidosLicitacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDefinicao() {
        return dataDefinicao;
    }

    public void setDataDefinicao(Date dataDefinicao) {
        this.dataDefinicao = dataDefinicao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<PedidoLicitacao> getPedidosLicitacoes() {
        return pedidosLicitacoes;
    }

    public void setPedidosLicitacoes(List<PedidoLicitacao> pedidosLicitacoes) {
        this.pedidosLicitacoes = pedidosLicitacoes;
    }

    public TipoModalidade getTipoModalidade() {
        return tipoModalidade;
    }

    public void setTipoModalidade(TipoModalidade tipoModalidade) {
        this.tipoModalidade = tipoModalidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final SituacaoPedidoLicitacao other = (SituacaoPedidoLicitacao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
