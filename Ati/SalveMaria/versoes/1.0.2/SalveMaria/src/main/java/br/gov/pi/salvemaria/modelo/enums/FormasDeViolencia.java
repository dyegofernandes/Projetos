/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum FormasDeViolencia {

    FISICA(0, "Física"),
    PSICOLOGICA(1, "Psicológica"),
    SEXUAL(2, "Sexual"),
    PATRIMONIAL(3, "Patrimonial"),
    MORAL(4, "Moral");

    private FormasDeViolencia(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }
    private String descricao;
    private int num;

    public int getNum() {
        return num;
    }

    public String getDescricao() {
        return descricao;
    }
}
