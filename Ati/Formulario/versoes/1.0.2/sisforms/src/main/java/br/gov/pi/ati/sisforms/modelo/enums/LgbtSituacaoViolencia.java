/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.enums;

/**
 *
 * @author killerbee
 */
public enum LgbtSituacaoViolencia {

    LGBTFOBIA(1, "LGBTFobia"),
    AMEACAS(2, "Ameaça"),
    DISCRIMINACAO(3, "Discriminação"),
    OUTROS(4, "Outras");

    private LgbtSituacaoViolencia(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }
    private String descricao;
    private int num;

    public String getDescricao() {
        return descricao;
    }

    public int getNum() {
        return num;
    }
}
