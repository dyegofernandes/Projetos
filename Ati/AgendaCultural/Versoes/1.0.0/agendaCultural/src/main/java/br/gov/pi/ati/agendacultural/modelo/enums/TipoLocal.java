/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TipoLocal {

    AUDITORIO(1, "Auditório"),
    AVENIDA(2, "Avenida"),
    GINASIO(3, "Ginásio"),
    PRACA(4, "Praça"),
    TEATRO(5, "Teatro");

    private TipoLocal(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
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
