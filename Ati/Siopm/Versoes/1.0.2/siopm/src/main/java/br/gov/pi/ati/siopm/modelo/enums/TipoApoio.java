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
public enum TipoApoio {

    BOMBEIRO(1, "Bombeiro"),
    SAMU(2, "Samu"),
    TRANSITO(3, "Trânsito"),
    POLICIA_RODOVIARIA_FEDERAL(4, "Polícia Rodoviária Federal"),
    POLICIA_FEDERAL(5, "Polícia Federal"),
    GUARDA_MUNICIPAL(6, "Guarda Municipal");

    private TipoApoio(int num, String descricao) {
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
