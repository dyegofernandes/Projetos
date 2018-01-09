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
public enum BairroGoogle {

    SIM(1, "Sim"),
    NAO(2, "Não");

    private BairroGoogle(int num, String descricao) {
        this.num = num;
        this.descricao = descricao;
    }
    private String descricao;
    private int num;

    public int getNum() {
        return num;
    }

    public String getDescricao() {
        return descricao;
    }
}
