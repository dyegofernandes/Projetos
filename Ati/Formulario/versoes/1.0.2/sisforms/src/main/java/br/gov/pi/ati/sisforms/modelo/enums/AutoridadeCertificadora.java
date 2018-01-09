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
public enum AutoridadeCertificadora {

    AC_SERPRO_RFB("AC SERPRO RFB"),
    AC_SERPRO_ACF("AC SERPRO ACF");

    private AutoridadeCertificadora(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
