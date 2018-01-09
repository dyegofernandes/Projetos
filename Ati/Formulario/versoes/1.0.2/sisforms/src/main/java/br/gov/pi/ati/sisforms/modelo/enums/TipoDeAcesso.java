/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TipoDeAcesso {

    PIAUI_CONECTADO("Piauí Conectado"),
    LINK_IT("Link It"),
    LINK_OI("Link Oi"),
    LINK_ATI("Link Ati");

    private TipoDeAcesso(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
