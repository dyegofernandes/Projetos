/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.passelivre.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TipoEndereco {
    RUA("Rua"),
    AVENIDA("Avenida");
    

    private TipoEndereco(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
