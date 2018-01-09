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
public enum Raca {

    BRANCA(1, "Branca"),
    NEGRO(2, "Negro"),
    AMARELO(3, "Amarela"),
    INDIGENA(4, "Indigena"),
    PARDA(5, "Parda"),
    NAO_INFORMADO(6, "Não Informada");

    private Raca(int num, String descricao) {
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
