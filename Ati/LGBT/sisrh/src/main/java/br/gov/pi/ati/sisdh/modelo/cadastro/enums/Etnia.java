/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.cadastro.enums;

/**
 *
 * @author Juniel
 */
public enum Etnia {
    BRANCA("Branca"),
    NEGRA("Negra"),
    PARDA("Parda"),
    AMARELA("Amarela"),
    INDIGENA("Indígena");
    

    private Etnia(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
