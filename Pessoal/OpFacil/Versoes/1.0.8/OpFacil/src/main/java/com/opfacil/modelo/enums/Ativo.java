/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.modelo.enums;

/**
 *
 * @author ti05
 */
public enum Ativo {

    SIM("Sim"),
    NAO("Não");

    private Ativo(String descricao) {
        this.descricao = descricao;
    }

    String descricao;

    public String getDescricao() {
        return descricao;
    }

}
