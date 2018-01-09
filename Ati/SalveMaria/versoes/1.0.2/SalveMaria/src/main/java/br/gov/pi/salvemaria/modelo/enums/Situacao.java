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
public enum Situacao {

    NOVA(1, "Nova"),
    DENUNCIA_SUBMETIDA(2, "Denúncia submetida à diligências"),
    DENUNCIA_POSITIVADA(3, "Denúncia positivada com instauração de procedimento"),
    DENUNCIA_NEGATIVADA(4, "Denúncia negativada por falta de elementos"),
    TROTE(5, "Trote"),
    DENUNCIA_POSITIVADA_SEM(6, "Denúncia positivada sem instauração de procedimento");

    private Situacao(int num, String descricao) {
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
