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
public enum CorVeiculo {

    PRATA("Prata"),
    PRETO("Preto"),
    CINZA("Cinza"),
    BRANCO("Branco"),
    VERMELHO("Vermelho"),
    AZUL("Azul"),
    VERDE("Verde"),
    AMARELO("Amarelo"),
    MARROM("Marrom"),
    ROSA("Rosa"),
    BEGE("Bege"),
    BORDO("Bordo");

    private CorVeiculo(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

}
