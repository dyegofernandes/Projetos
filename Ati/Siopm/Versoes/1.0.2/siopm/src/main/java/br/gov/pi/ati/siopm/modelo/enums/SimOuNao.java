/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum SimOuNao {

    SIM(1, "Sim"),
    NAO(2, "Não");

    private SimOuNao(int num, String descricao) {
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
