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
public enum ClassificacaoChamada {

//    ASSUNTO_ADM_OPERACIONAL(1, "Assunto Admin. Operacional"),
//    CHAMADA_NAO_CONCLUIDA(2, "Chamada não concluída"),
//    ORIENTACAO_AO_PUBLICO(3, "Orientação ao Público"),
    TROTE(1, "Trote"),
    OCORRENCIA(2, "Ocorrência");

    private ClassificacaoChamada(int num, String descricao) {
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

    public void setNum(int num) {
        this.num = num;
    }

}
