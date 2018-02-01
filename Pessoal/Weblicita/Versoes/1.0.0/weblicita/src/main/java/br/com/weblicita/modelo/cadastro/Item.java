/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.weblicita.modelo.cadastro;

import br.com.weblicita.modelo.controleacesso.Usuario;
import br.com.weblicita.modelo.licitacao.ItemLicitacao;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class Item implements Serializable {

    @Id
    @SequenceGenerator(name = "Item", allocationSize = 1, sequenceName = "item_id_seq")
    @GeneratedValue(generator = "Item")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

//    @NotBlank
    @Size(max = 50)
    private String codigo;

//    @NotBlank
    @Size(max = 255)
    private String descricao;

    @ManyToMany(targetEntity = UnidadeDeMedida.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<UnidadeDeMedida> unidade;

    private boolean ativo = true;

    @NotAudited
    @OneToMany(mappedBy = "item")
    private List<ItemLicitacao> itens;

    @Override
    public String toString() {
        return descricao; //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<ItemLicitacao> getItens() {
        return itens;
    }

    public void setItens(List<ItemLicitacao> itens) {
        this.itens = itens;
    }

    public List<UnidadeDeMedida> getUnidade() {
        return unidade;
    }

    public void setUnidade(List<UnidadeDeMedida> unidade) {
        this.unidade = unidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Item other = (Item) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
