/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.enums;

/**
 *
 * @author ti05
 */
public enum TipoDespesaEnum {
    
    ANALITICO(0,"Analítico"),
    SINTENTICO(1,"Sintético");

    private TipoDespesaEnum(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }
    
    String descricao;
    int num;

    public String getDescricao() {
        return descricao;
    }

    public int getNum() {
        return num;
    }
      
}
