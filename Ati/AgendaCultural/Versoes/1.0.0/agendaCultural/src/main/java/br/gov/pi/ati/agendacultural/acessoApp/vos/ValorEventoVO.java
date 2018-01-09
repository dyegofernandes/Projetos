/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.acessoApp.vos;

import java.math.BigDecimal;

/**
 *
 * @author Juniel
 */
public class ValorEventoVO {

    private Long id;

    private String descricao;

    private BigDecimal valor;


    private BigDecimal valorMeia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorMeia() {
        return valorMeia;
    }

    public void setValorMeia(BigDecimal valorMeia) {
        this.valorMeia = valorMeia;
    }

}
