/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.vo;

import br.com.aprove.modelo.faturamento.ItemPedido;
import br.com.aprove.modelo.faturamento.ItemVenda;
import java.math.BigDecimal;

/**
 *
 * @author KillerBeeTwo
 */
public class SolicitacaoPedidoVO {

    private String index = "";

    private String produto = "";

    private String qtd = "";

    private String valorUnitario = "";

    private String unidadeDeVenda = "";

    private String icmsCompra = "";

    private String ipi = "";

    private String desconto = "";

    private String marca = "";

    private String totalPorProd = "";

    public SolicitacaoPedidoVO(int i, ItemPedido item) {
        this.index = String.format("%03d", i);
        this.produto = item.getProduto().getDescricao();
        this.marca = item.getMarca() != null ? item.getMarca() : "";
        this.unidadeDeVenda = item.getUnidadeDeVenda().toString();
        this.qtd = item.getQtd().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.valorUnitario = item.getValorUnitario().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.icmsCompra = item.getIcmsCompra().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.ipi = item.getProduto().getIpi().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.desconto = item.getValorDesconto().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.totalPorProd = item.getQtd().multiply(item.getValorUnitario()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public SolicitacaoPedidoVO(int i, ItemVenda item) {

        this.index = String.format("%03d", i);
        this.produto = item.getEstoque().getProduto().getDescricao();
        this.marca = item.getEstoque().getMarca() != null ? item.getEstoque().getMarca() : "";
        this.unidadeDeVenda = item.getUnidadeDeVenda().toString();
        this.qtd = item.getQtd().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.valorUnitario = item.getValorUnitario().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.ipi = item.getEstoque().getProduto().getIpi().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.desconto = item.getDesconto().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        this.totalPorProd = item.getQtd().multiply(item.getValorUnitario()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public String getProduto() {
        return produto;
    }

    public String getQtd() {
        return qtd;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public String getUnidadeDeVenda() {
        return unidadeDeVenda;
    }

    public String getIcmsCompra() {
        return icmsCompra;
    }

    public String getIpi() {
        return ipi;
    }

    public String getDesconto() {
        return desconto;
    }

    public String getMarca() {
        return marca;
    }

    public String getTotalPorProd() {
        return totalPorProd;
    }

    public String getIndex() {
        return index;
    }

}
