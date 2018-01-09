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
public enum SituacaoPessoaOcorrencia {

    AGENTE(1, "Agente"),
    AUTOR(2, "Autor"),
    PARTE_NAO_INFORMADA(3, "Parte não informada"),
    TESTEMUNHA(4, "Testemunha"),
    VITIMA(5, "Vitima");

    private SituacaoPessoaOcorrencia(int num, String descricao) {
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
