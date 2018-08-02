/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ejccard.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TipoPagamento {

    AVISTA(1,"Avista"),
    DEBITO(2,"Débito"),
    CREDITO(3,"Crédito");

    private TipoPagamento(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }
    private String descricao;
    private int num;

    public String getDescricao() {
        return descricao;
    }
    
    public int getNum(){
        return num;
    }
}
