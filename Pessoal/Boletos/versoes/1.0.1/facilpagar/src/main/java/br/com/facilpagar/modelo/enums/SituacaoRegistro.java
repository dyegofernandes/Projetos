/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facilpagar.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum SituacaoRegistro {

    NAO_REGISTRADO(1, "Não Registrado"),
    REGISTRADO(2, "Registrado"),
    RECUSADO(3, "Recusado");

    private SituacaoRegistro(int num, String descricao) {
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
