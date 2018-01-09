/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class ItemDaRequisicaoDeMaterial implements Serializable {

    @Id
    @SequenceGenerator(name = "ItemDaRequisicaoDeMaterial", sequenceName = "seq_itemDaRequisicaoDeMaterial")
    @GeneratedValue(generator = "ItemDaRequisicaoDeMaterial")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private RequisicaoDeMaterial requisicaoDeMaterial;

    @Size(max = 250)
    @NotBlank
    private String discriminacao;

    @NotNull
    private BigDecimal quantidade;

    private BigDecimal valor;

    public BigDecimal getTotalPorItem() {
        BigDecimal total = BigDecimal.ZERO;
        if (valor != null && quantidade != null) {
            total = total.add(valor.multiply(quantidade));
        }

        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RequisicaoDeMaterial getRequisicaoDeMaterial() {
        return requisicaoDeMaterial;
    }

    public void setRequisicaoDeMaterial(RequisicaoDeMaterial requisicaoDeMaterial) {
        this.requisicaoDeMaterial = requisicaoDeMaterial;
    }

    public String getDiscriminacao() {
        return discriminacao;
    }

    public void setDiscriminacao(String discriminacao) {
        this.discriminacao = discriminacao;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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
        final ItemDaRequisicaoDeMaterial other = (ItemDaRequisicaoDeMaterial) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
