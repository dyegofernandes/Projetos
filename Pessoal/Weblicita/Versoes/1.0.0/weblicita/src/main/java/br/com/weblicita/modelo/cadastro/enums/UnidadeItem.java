/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.weblicita.modelo.cadastro.enums;

/**
 *
 * @author Juniel
 */
public enum UnidadeItem {
    UNIDADE("Unidade"),
    KG("Kg"),
    METRO("Metro"),
    M2("M²"),
    M3("M³"),
    DUZIA("Dúzia"),
    RESMA("Resma"),
    PACOTE("Pacote"),
    CAIXA("Caixa"),
    VOLUME("Volume"),
    LITRO("Litro"),
    GALAO("Galão"),
    SACO("Saco"),
    AMPOLAS("Ampolas"),
    OUTRO("Outro"),;
    

    private UnidadeItem(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
