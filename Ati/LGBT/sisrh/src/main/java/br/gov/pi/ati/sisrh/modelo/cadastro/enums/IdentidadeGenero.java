/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisrh.modelo.cadastro.enums;

/**
 *
 * @author Juniel
 */
public enum IdentidadeGenero {
    HOMEM("Homem"),
    MULHER("Mulher"),
    TS_MASC("TS Masc."),
    TS_FEM("TS Fem."),
    TRAVESTI("Travesti");
    

    private IdentidadeGenero(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
