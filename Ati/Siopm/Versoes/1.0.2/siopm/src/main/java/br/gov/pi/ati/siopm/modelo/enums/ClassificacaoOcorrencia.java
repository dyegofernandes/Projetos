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

    NORMAL(1, "N", "Normal"),
    URGENTE(2, "U", "Urgênte");

    private ClassificacaoOcorrencia(int num, String sigla, String descricao) {
        this.descricao = descricao;
        this.num = num;
        this.sigla = sigla;
    }
    private String descricao;

    private String sigla;

    private int num;

    public String getDescricao() {
        return descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public int getNum() {
        return num;
    }

}
