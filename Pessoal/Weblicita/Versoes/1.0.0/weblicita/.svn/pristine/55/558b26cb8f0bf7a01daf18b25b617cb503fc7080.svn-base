/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.weblicita.modelo.cadastro;

import br.com.weblicita.modelo.licitacao.SituacaoPedidoLicitacao;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class TipoModalidade implements Serializable {

    @Id
    @SequenceGenerator(name = "TipoModalidade", allocationSize = 1, sequenceName = "tipoModalidade_id_seq")
    @GeneratedValue(generator = "TipoModalidade")
    private Long id;
    
    @NotBlank
    @Size(max = 250)
    private String descricao;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataDefinicao = new Date();

    private boolean ativo = true;
    
    @NotAudited
    @OneToMany(mappedBy = "tipoModalidade")
    private List<SituacaoPedidoLicitacao> situacoes;

    @Override
    public String toString() {
        return descricao; 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public List<SituacaoPedidoLicitacao> getSituacoes() {
        return situacoes;
    }

    public void setSituacoes(List<SituacaoPedidoLicitacao> situacoes) {
        this.situacoes = situacoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final TipoModalidade other = (TipoModalidade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
