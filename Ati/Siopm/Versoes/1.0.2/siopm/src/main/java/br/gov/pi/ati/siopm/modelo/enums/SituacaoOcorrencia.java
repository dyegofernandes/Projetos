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
public enum SituacaoOcorrencia {

    PENDENTE(1, "Pendente"),
    ENCAMINHADA_VIATURA(2, "Encaminhada para Viatúra"),
    ENCERRADA(3, "Encerrada"),
    ABORTADA(4, "Abortada");

    private SituacaoOcorrencia(int num, String descricao) {
        this.num = num;
        this.descricao = descricao;
    }
    private String descricao;
    private int num;

    public String getDescricao() {
        return descricao;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
