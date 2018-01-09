/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.vo;

import br.com.aprove.modelo.faturamento.ItemVenda;
import br.com.aprove.modelo.faturamento.Venda;
import java.math.BigDecimal;

/**
 *
 * @author KillerBeeTwo
 */
public class NFeVO {

    private String codigo;

    private String descricaoPouS;

    private String ncm;

    private String cst;

    private String cfop;

    private String unid;

    private String qtd;

    private String valorUni;

    private String valorTotal;

    private String icms;

    private String valorIcms;

    private String valorIpi;

    private String aliqIcms;

    private String aliqIpi;

    public NFeVO(ItemVenda item) {
        this.codigo = String.format("%013d", item.getEstoque().getProduto().getId());

        this.descricaoPouS = item.getEstoque().getProduto().getDescricao();

        this.ncm = item.getEstoque().getProduto().getCodigoNCM();

//        this.cst = item.getCodigoCst();
//        this.cfop = item.getEstoque().getProduto().getCfop();
        this.unid = item.getEstoque().getProduto().getUnidadeDeVenda().getDescricao();

        this.qtd = item.getQtd().toString();

        this.valorUni = item.getValorUnitario().toString();

        this.valorTotal = item.getQtd().multiply(item.getValorUnitario()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();

        this.icms = "0.00";

//        this.valorIcms = item.getEstoque().getProduto().getIcmsCompra().toString();
        this.valorIpi = item.getEstoque().getProduto().getIpi().toString();

        this.aliqIcms = "0.00";

        this.aliqIpi = "0.00";
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricaoPouS() {
        return descricaoPouS;
    }

    public String getNcm() {
        return ncm;
    }

    public String getCst() {
        return cst;
    }

    public String getCfop() {
        return cfop;
    }

    public String getUnid() {
        return unid;
    }

    public String getQtd() {
        return qtd;
    }

    public String getValorUni() {
        return valorUni;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public String getIcms() {
        return icms;
    }

    public String getValorIcms() {
        return valorIcms;
    }

    public String getValorIpi() {
        return valorIpi;
    }

    public String getAliqIcms() {
        return aliqIcms;
    }

    public String getAliqIpi() {
        return aliqIpi;
    }

}
