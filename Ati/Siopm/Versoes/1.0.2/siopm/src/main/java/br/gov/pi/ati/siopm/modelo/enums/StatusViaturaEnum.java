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
public enum StatusViaturaEnum {

    DISPONIVEL("Disponível"),
    ATENDENDO("Em atendimento"),
    INDISPONIVEL("Indisponível");

    private StatusViaturaEnum(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

}