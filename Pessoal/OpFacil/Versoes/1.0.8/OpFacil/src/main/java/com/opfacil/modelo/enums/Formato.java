/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.modelo.enums;

/**
 *
 * @author KillerBeeTwo
 */
public enum Formato {

    NUM("Número"),
    ALFA("Alfa Númerico");

    private Formato(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

}
