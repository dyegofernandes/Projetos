/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pagcontascarne.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TipoRepasse {

    D0(1, "D+0"),
    D1(2, "D+1"),
    D2(3, "D+2"),
    S(4,"Semanal");

    private TipoRepasse(int num, String descricao) {
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
