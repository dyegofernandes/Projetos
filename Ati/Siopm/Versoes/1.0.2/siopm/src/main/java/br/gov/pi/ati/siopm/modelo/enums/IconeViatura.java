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
public enum IconeViatura {

    VTR_BOPE("VTR_BOPE.png"),
    VTR_BPRE("VTR_BPRE.png"),
    VTR_BPRONE("VTR_BPRONE.png"),
    VTR_CONVENCIONAL("VTR_CONVENCIONAL.png"),
    MOTO_RONE("MOTO_RONE.png"),
    MOTO_CONVENCIONAL("MOTO_CONVENCIONAL.png");

    private IconeViatura(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

}
