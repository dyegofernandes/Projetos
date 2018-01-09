/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.modelo.faturamento;

import br.com.aprove.modelo.cadastro.Produto;
import br.com.aprove.modelo.cadastro.enums.UnidadeDeMedida;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author juniel
 */
@Entity
public class ItemPedido implements Serializable {

    @Id
    @SequenceGenerator(name = "ItemPedido", allocationSize = 1, sequenceName = "seq_itemPedido")
    @GeneratedValue(generator = "ItemPedido")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;

    private String codigo;

    @Size(max = 200)
    private String marca;

    @NotNull
    private BigDecimal qtd;

    @NotNull
    private BigDecimal valorUnitario;

    @NotNull
    private UnidadeDeMedida unidadeDeVenda;

    private BigDecimal porcentagemDesconto = BigDecimal.ZERO;

    private BigDecimal icmsCompra = BigDecimal.ZERO;

    @Temporal(TemporalType.DATE)
    private Date dataFabricacao;

    @Temporal(TemporalType.DATE)
    private Date dataValidade;

    public boolean ativo = true;

    public BigDecimal getValorTotal() {
        BigDecimal valor = BigDecimal.ZERO;

        if (qtd != null && valorUnitario != null) {
            valor = valor.add(qtd.multiply(valorUnitario));
        }

        return valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public UnidadeDeMedida getUnidadeDeVenda() {
        return unidadeDeVenda;
    }

    public void setUnidadeDeVenda(UnidadeDeMedida unidadeDeVenda) {
        this.unidadeDeVenda = unidadeDeVenda;
    }

    public BigDecimal getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    public void setPorcentagemDesconto(BigDecimal porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }

    public BigDecimal getValorDesconto() {
        BigDecimal desconto = BigDecimal.ZERO;

        if (qtd != null && valorUnitario != null && porcentagemDesconto != null) {
            desconto = qtd.multiply(valorUnitario).multiply(porcentagemDesconto).divide(new BigDecimal(100));
        }

        return desconto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getIcmsCompra() {
        return icmsCompra;
    }

    public void setIcmsCompra(BigDecimal icmsCompra) {
        this.icmsCompra = icmsCompra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ItemPedido other = (ItemPedido) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
