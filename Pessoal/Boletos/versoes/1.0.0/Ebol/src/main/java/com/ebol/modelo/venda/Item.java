/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.venda;

import com.ebol.modelo.cadastro.Convenio;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */

@Entity
@Table(schema = "venda")
public class Item implements Serializable {

    @Id
    @SequenceGenerator(schema="venda", allocationSize = 1, name = "Item", sequenceName = "item_id_seq")
    @GeneratedValue(generator = "Item")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Convenio convenio;
    
    @Size(max = 50)
    @NotBlank
    private String descricao;
    
    @NotNull
    private BigDecimal unitario;
    
    @NotAudited
    @OneToMany(mappedBy = "item")
    private List<Item_Vendido> itens_vendidos;

    @Override
    public String toString() {
        return descricao; 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getUnitario() {
        return unitario;
    }

    public void setUnitario(BigDecimal unitario) {
        this.unitario = unitario;
    }

    public List<Item_Vendido> getItens_vendidos() {
        return itens_vendidos;
    }

    public void setItens_vendidos(List<Item_Vendido> itens_vendidos) {
        this.itens_vendidos = itens_vendidos;
    }
    
    
}
