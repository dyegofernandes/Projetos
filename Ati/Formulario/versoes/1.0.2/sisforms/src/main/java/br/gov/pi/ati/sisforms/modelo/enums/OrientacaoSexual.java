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
public enum OrientacaoSexual {
    HETERO("Hétero"),
    HSH("HSH"),
    MSM("MSM"),
    LESBICA("Lésbica"),
    GAY("Gay"),
    BISSEXUAL("Bissexual"),
    PREFERE_NAO_RESPONDER("Prefere não responder"),
    ASSEXUAL("Assexual"),
    PAMSEXUAL("Pamsexual");
    

    private OrientacaoSexual(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
