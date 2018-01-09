/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.modelo.cadastro.enums;

/**
 *
 * @author Juniel
 */
public enum StatusPedido {

    ABERTO(1, "Aberto"),
    FECHADO(2, "Fechado"),
    CANCELADO(3, "Cancelado");

    private StatusPedido(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }
    private String descricao;
    private int num;

    public String getDescricao() {
        return descricao;
    }

    public int getNum() {
        return num;
    }

}
