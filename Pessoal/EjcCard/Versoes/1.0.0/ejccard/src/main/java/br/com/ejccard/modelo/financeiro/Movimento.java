/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ejccard.modelo.financeiro;

import br.com.ejccard.modelo.enums.TipoPagamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Movimento implements Serializable {

    @Id
    @SequenceGenerator(name = "Movimento", allocationSize = 1, sequenceName = "movimento_id_seq")
    @GeneratedValue(generator = "Movimento")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Caixa caixa;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataLancamento = new Date();

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoPagamento tipoPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    private EjcCard ejcCard;

    @ManyToMany(targetEntity = Pedido.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public EjcCard getEjcCard() {
        return ejcCard;
    }

    public void setEjcCard(EjcCard ejcCard) {
        this.ejcCard = ejcCard;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Movimento other = (Movimento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
