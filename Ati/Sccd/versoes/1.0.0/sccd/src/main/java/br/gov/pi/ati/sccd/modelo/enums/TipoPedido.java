/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TipoPedido {

    OFICIO(1, "Pedido por Ofício"),
    AGENDAMENTO(2, "Pedido por Agendamento");

    private TipoPedido(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }
    private String descricao;

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDescricao() {
        return descricao;
    }
}
