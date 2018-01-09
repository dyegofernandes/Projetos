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
public enum TipoDeArma {

    ARMA_BRANCA(1, "Arma Branca"),
    ARMA_DE_HASTE(2, "Arma de Haste"),
    ARMA_DE_FOGO(3, "Arma de Fogo");

    private TipoDeArma(int num, String descricao) {
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
