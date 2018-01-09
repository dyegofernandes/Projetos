/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.modelo.faturamento;

import br.com.aprove.modelo.cadastro.Fornecedor;
import br.com.aprove.modelo.cadastro.Loja_Filial;
import br.com.aprove.modelo.cadastro.Produto;
import br.com.aprove.modelo.cadastro.enums.UnidadeDeMedida;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Estoque implements Serializable {

    @Id
    @SequenceGenerator(name = "Estoque", allocationSize = 1, sequenceName = "seq_estoque")
    @GeneratedValue(generator = "Estoque")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Loja_Filial empresa;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Fornecedor fornecedor;

    @Size(max = 200)
    @NotNull
    private String marca; 

    @Size(max = 200)
    private String codigo; 

    @NotNull
    @Enumerated
    private UnidadeDeMedida unidade;

    @NotNull
    private BigDecimal quantidade;

    @NotNull
    private BigDecimal qtdMinima = BigDecimal.ZERO;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataFabricacao;

    @Temporal(TemporalType.DATE)
    private Date dataValidade;

    private boolean ativo = true;

    @OneToMany(mappedBy = "produto")
    private List<ItemVenda> itensVenda;

    @OneToMany(mappedBy = "produto")
    private List<ItemPedido> itensPedidos;

    public Estoque() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Loja_Filial getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Loja_Filial empresa) {
        this.empresa = empresa;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(BigDecimal qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public UnidadeDeMedida getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeDeMedida unidade) {
        this.unidade = unidade;
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

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Estoque other = (Estoque) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public void addQuantidade(BigDecimal qtd) {
        if (quantidade != null) {
            quantidade = quantidade.add(qtd);
        } else {
            quantidade = qtd;
        }
    }

    public void removeQuantidade(BigDecimal qtd) {
        quantidade = quantidade.subtract(qtd);
    }

}
