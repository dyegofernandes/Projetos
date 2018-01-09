/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TipoEndereco {
    RESIDENCIAL("Residêncial"),
    COMERCIAL("Comercial"),
    CORRESPONDENCIA("Correspondência"),
    COBRANCA("Cobrança");
    

    private TipoEndereco(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
