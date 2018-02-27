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
public enum CidadeSAV {

    TERESINA("Teresina"),
    FLORIANDO("Floriano"),
    PICOS("Picos"),
    CORRENTE("Corrente"),
    URUCUI("Uruçuí"),
    SAO_RAIMUNDO_NONATO("São Raimundo Nonato"),
    PIRIPIRI("Piripiri"),
    OEIRAS("Oeiras"),
    CAMPO_MAIOR("Campo Maior"),
    JOSE_DE_FREITAS("José de Freitas"),
    AGUA_BRANCA("Água Branca"),
    BOM_JESUS("Bom Jesus"),
    PAULISTANA("Paulistana"),
    LUIS_CORREA("Luis Correa"),
    PARNAIBA("Panaíba");

    private CidadeSAV(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

}
