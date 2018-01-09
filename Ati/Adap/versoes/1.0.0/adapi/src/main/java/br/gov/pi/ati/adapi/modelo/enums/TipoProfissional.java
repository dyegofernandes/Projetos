/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.adapi.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TipoProfissional {

    MEDICO_VETERINARIO("Médico Veterinário"),
    BIOLOGO("Biólogo"),
    ZOOTECNISTA("Zootecnista"),
    TECNICO_AGROPECUARIA("Técnico em Agropecuária"),
    OUTROS("Outros");

    private TipoProfissional(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
