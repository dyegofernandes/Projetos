/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.cfcpm.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum Situacao {

    ENVIADA("Enviada"),
    DEFERIDA("Deferida"),
    INDEFERIDA("Indeferida"),
    PENDENTE("Pendente");

    private Situacao(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

}
