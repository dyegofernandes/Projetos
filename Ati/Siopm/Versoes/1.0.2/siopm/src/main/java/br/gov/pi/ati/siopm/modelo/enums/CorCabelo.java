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
public enum CorCabelo {

    AVERMELHADO(1, "Avermelhado"),
    BRANCO(2, "Branco"),
    CALVICE_TOTAL(3, "Calvice Total"),
    CASTANHO_CLARO(4, "Castanho Claro"),
    CASTANHO_ESCURO(5, "Castanho Escuro"),
    CASTANHO_MEDIO(6, "Castanho Médio"),
    LOIRO_CLARISSIMO(7, "Loiro Claríssimo"),
    LOIRO_CLARO(8, "Loiro Claro"),
    LOIRO_ESCURO(9, "Loiro Escuro"),
    RUIVO(10, "Ruivo"),
    CINZA_GRISALHO(11, "Cinza ou Grisalho"),
    VERDE(12, "Verde"),
    ROSA(13, "Rosa"),
    AZUL(14, "Azul"),
    PRETO(15, "Preto");

    private CorCabelo(int num, String descricao) {
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
