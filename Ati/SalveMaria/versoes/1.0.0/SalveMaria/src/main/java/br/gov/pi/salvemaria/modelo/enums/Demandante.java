/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum Demandante {

    ANONIMO(1, "Anônimo"),
    VITIMA(2, "Própria vítima"),
    FAMILIAR(3, "Familiar"),
    VIZINHO(4, "Vizinho");

    private Demandante(int num, String descricao) {
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
