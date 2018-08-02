/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ejccard.modelo.financeiro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Juniel
 */
@Entity
public class Pedido implements Serializable {

    @Id
    @SequenceGenerator(name = "Pedido", allocationSize = 1, sequenceName = "pedido_id_seq")
    @GeneratedValue(generator = "Pedido")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Estoque estoque;

    private BigDecimal quantidade;

    private BigDecimal precoUnitario;

    public BigDecimal getTotal() {

        BigDecimal total = BigDecimal.ZERO;

        if (quantidade != null && precoUnitario != null) {
            total = quantidade.multiply(quantidade);
        }

        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    

}
