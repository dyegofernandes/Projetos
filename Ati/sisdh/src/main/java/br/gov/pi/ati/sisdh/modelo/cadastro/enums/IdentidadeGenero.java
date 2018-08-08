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
public enum IdentidadeGenero {
    HOMEM("Homem CIS"),
    MULHER("Mulher CIS"),
    TS_MASC("Homem Transexual"),
    TS_FEM("Mulher Transexual"),
    TRAVESTI("Travesti"),
    NAO_BINARIO("Travesti");
    

    private IdentidadeGenero(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
