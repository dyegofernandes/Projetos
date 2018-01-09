/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.bombeiro.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum Situacao {

    NOVA(1, "Nova"),
    EM_ATENDIMENTO(2, "Denúncia submetida à diligências"),
    DENUNCIA_POSITIVADA(3, "Denúncia positivada"),
    DENUNCIA_NEGATIVADA(4, "Denúncia negativada"),
    TROTE(5, "Trote");

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
