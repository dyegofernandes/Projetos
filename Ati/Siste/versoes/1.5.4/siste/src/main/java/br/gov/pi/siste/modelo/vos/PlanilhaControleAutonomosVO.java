/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.vos;

import java.math.BigDecimal;

/**
 *
 * @author Juniel
 */
public class PlanilhaControleAutonomosVO {

    private String numeroNota;

    private String dataPagamento;

    private String elementoDespesa;

    private String nitPisPasep;

    private String nome;

    private BigDecimal valorBruto = BigDecimal.ZERO;

    private BigDecimal inss = BigDecimal.ZERO;

    private BigDecimal irrf = BigDecimal.ZERO;

    private BigDecimal iss = BigDecimal.ZERO;

    private BigDecimal sestSenat = BigDecimal.ZERO;

    public BigDecimal getValorLiquido() {
        BigDecimal valor = BigDecimal.ZERO;

        valor = valor.add(valorBruto != null ? valorBruto : BigDecimal.ZERO).subtract(inss != null ? inss : BigDecimal.ZERO).
                subtract(irrf != null ? irrf : BigDecimal.ZERO).subtract(iss != null ? iss : BigDecimal.ZERO).
                subtract(sestSenat != null ? sestSenat : BigDecimal.ZERO);

        return valor;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getElementoDespesa() {
        return elementoDespesa;
    }

    public void setElementoDespesa(String elementoDespesa) {
        this.elementoDespesa = elementoDespesa;
    }

    public String getNitPisPasep() {
        return nitPisPasep;
    }

    public void setNitPisPasep(String nitPisPasep) {
        this.nitPisPasep = nitPisPasep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public BigDecimal getInss() {
        return inss;
    }

    public void setInss(BigDecimal inss) {
        this.inss = inss;
    }

    public BigDecimal getIrrf() {
        return irrf;
    }

    public void setIrrf(BigDecimal irrf) {
        this.irrf = irrf;
    }

    public BigDecimal getIss() {
        return iss;
    }

    public void setIss(BigDecimal iss) {
        this.iss = iss;
    }

    public BigDecimal getSestSenat() {
        return sestSenat;
    }

    public void setSestSenat(BigDecimal sestSenat) {
        this.sestSenat = sestSenat;
    }

}
