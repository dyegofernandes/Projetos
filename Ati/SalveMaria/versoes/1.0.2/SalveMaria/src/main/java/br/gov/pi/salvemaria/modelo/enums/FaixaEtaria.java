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
public enum FaixaEtaria {

    MENOR_DE_IDADE(1, "Menor de Idade (<18)"),
    MAIOR_DE_IDADE(2, "Maior de Idade (>=18 e <60)"),
    IDOSO(3, "Idoso (>=60)"),
    TODAS(4, "Todas");

    private FaixaEtaria(int num, String descricao) {
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
