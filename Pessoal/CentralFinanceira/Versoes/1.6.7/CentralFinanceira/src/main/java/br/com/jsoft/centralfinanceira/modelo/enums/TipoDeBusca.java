/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TipoDeBusca {
    
    EM_ABERTO(1, "Em Aberto"),
    ENTRADAS(2, "Entradas"),
    PAGOS(3,"Pagas"),
    CANCELADADAS(4,"Canceladas");

    private TipoDeBusca(int num, String descricao) {
        this.descricao = descricao;
    }

    String descricao;
    int num;

    public int getNum() {
        return num;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
