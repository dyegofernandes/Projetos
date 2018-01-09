/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.bombeiro.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TipoPoligono {

    AREA_POR_CIDADE("Área por Cidade"),
    CIDADE("Cidade"),
    ESTADO("Estado"),
    PAIS("País");

    private TipoPoligono(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
