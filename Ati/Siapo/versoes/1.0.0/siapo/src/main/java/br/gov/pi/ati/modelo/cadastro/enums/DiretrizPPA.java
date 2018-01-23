/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro.enums;

/**
 *
 * @author Juniel
 */
public enum DiretrizPPA {

    DIRETRIZ_I(1, "Diretriz I"),
    DIRETRIZ_II(2, "Diretriz II"),
    DIRETRIZ_III(3, "Diretriz III"),
    DIRETRIZ_IV(4, "Diretriz IV"),
    DIRETRIZ_V(5, "Diretriz V");

    private DiretrizPPA(int num, String descricao) {
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
