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
public enum CorOlho {

    AZUL(1, "Azul"),
    AZUL_CLARO(2, "Azul Claro"),
    CASTANHO_CLARO(3, "Castanho Claro"),
    CASTANHO_MEDIO(4, "Castanho Médio"),
    CASTANHO_ESCURO(5, "Castanho Escuro"),
    ESVERDEADO(6, "Esverdeado"),
    VERDE(7, "Verde"),
    PRETO(8, "Preto");

    private CorOlho(int num, String descricao) {
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
