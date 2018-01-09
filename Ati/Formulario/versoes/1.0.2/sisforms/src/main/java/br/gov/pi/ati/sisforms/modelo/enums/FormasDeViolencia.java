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
public enum FormasDeViolencia {

    FISICA(1, "Física"),
    PSICOLOGICA(2, "Psicológia"),
    SEXUAL(3, "Sexual"),
    NEGLIGENCIA(4, "Negligência"),
    OUTROS(5, "Outros");

    private FormasDeViolencia(int num, String descricao) {
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
