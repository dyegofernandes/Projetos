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
public enum ClassificacaoOcorrencia {

    POLICIAL_EM_PERIGO(1, "Policial em Perigo"),
    NORMAL(3, "Normal"),
    URGENTE(2, "Urgênte");

    private ClassificacaoOcorrencia(int num, String descricao) {
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
