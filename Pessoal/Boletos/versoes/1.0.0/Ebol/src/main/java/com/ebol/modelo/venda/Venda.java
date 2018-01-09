/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.venda;

import com.ebol.modelo.cadastro.Cliente;
import com.ebol.modelo.cadastro.Convenio;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
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
public class Venda implements Serializable {

    @Id
    @SequenceGenerator(schema="venda", allocationSize = 1, name = "Venda", sequenceName = "venda_id_seq")
    @GeneratedValue(generator = "Venda")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Convenio convenio;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cliente cliente;
    
    @Size(max = 100)
    @NotBlank
    private String referenteA;
     
    private String descricao;
    
    @NotAudited
    @OneToMany(mappedBy = "venda")
    private List<Item_Vendido> itens_vendidos;
    
    @NotAudited
    @OneToMany(mappedBy = "venda")
    private List<Acrescimo> acrescimos;
    
    @NotAudited
    @OneToMany(mappedBy = "venda")
    private List<Boleto> boletos;
    
    @NotAudited
    @OneToMany(mappedBy = "venda")
    private List<Desconto> descontos;

    @Override
    public String toString() {
        return referenteA; 
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Venda other = (Venda) obj;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getReferenteA() {
        return referenteA;
    }

    public void setReferenteA(String referenteA) {
        this.referenteA = referenteA;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Item_Vendido> getItens_vendidos() {
        return itens_vendidos;
    }

    public void setItens_vendidos(List<Item_Vendido> itens_vendidos) {
        this.itens_vendidos = itens_vendidos;
    }

    public List<Acrescimo> getAcrescimos() {
        return acrescimos;
    }

    public void setAcrescimos(List<Acrescimo> acrescimos) {
        this.acrescimos = acrescimos;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public List<Desconto> getDescontos() {
        return descontos;
    }

    public void setDescontos(List<Desconto> descontos) {
        this.descontos = descontos;
    }
    
    
}
