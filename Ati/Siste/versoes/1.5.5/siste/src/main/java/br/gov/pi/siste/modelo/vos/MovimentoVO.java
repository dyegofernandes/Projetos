/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.vos;

import br.gov.pi.siste.modelo.cadastro.enums.TipoPessoa;
import java.math.BigDecimal;

/**
 *
 * @author Juniel
 */
public class MovimentoVO {
    
    private String tipo;

    private String cpf;

    private String credor;

    private String pisPasep;

    private String notaEmpenho;

    private String notaLiquidacao;

    private String descricaoServico;

    private BigDecimal valorBruto;

    private BigDecimal valorBCalc;

    private String fonte;

    private BigDecimal descontoInss;

    private BigDecimal desconto20;
    
    private BigDecimal valorTotal;

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public String getPisPasep() {
        return pisPasep;
    }

    public void setPisPasep(String pisPasep) {
        this.pisPasep = pisPasep;
    }

    public String getNotaEmpenho() {
        return notaEmpenho;
    }

    public void setNotaEmpenho(String notaEmpenho) {
        this.notaEmpenho = notaEmpenho;
    }

    public String getNotaLiquidacao() {
        return notaLiquidacao;
    }

    public void setNotaLiquidacao(String notaLiquidacao) {
        this.notaLiquidacao = notaLiquidacao;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public BigDecimal getValorBCalc() {
        return valorBCalc;
    }

    public void setValorBCalc(BigDecimal valorBCalc) {
        this.valorBCalc = valorBCalc;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public BigDecimal getDescontoInss() {
        return descontoInss;
    }

    public void setDescontoInss(BigDecimal descontoInss) {
        this.descontoInss = descontoInss;
    }

    public BigDecimal getDesconto20() {
        return desconto20;
    }

    public void setDesconto20(BigDecimal desconto20) {
        this.desconto20 = desconto20;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
