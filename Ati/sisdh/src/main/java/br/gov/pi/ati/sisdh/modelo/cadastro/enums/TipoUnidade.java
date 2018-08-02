/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.cadastro.enums;

public enum TipoUnidade {

    CIPTUR(1, "Companhia Independente de Policiamento Turístico - CIPTUR"),
    BPM(2, "Batalhão de Polícia Militar"),
    DDDM(4, "Delegacias de Defesa dos Direitos da Mulher"),
    DRPC(3, "Delegacia Regional de Polícia Civil"),
    DP(5, "Distrito Policial"),
    PM(6, "Polícia Militar"),
    PC(7, "Polícia Civil"),
    DSPM(10, "DPCM - Menor Infrator"),
    DPCA(9, "DPCA - Menor Vítima"),
    DSPI(8, "DSPI - Idoso");

    private TipoUnidade(int num, String descricao) {
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

