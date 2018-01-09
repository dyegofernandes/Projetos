/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum SituacaoDeRua {

    MENDICANCIA(1, "Mendicância"),
    TRABALHO_INFANTIL(2, "Trabalho infantil"),
    MORADORES_DE_RUA(3, "Moradores de rua"),
    OUTROS(4, "Outros");

    private SituacaoDeRua(int num, String descricao) {
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
