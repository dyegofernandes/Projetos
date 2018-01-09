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
public enum TipoUnidade {

    CIPTUR(1, "Companhia Independente de Policiamento Turístico - CIPTUR"),
    BPM(2, "Batalhão de Polícia Militar"),
    DDDM(3, "Delegacias de Defesa dos Direitos da Mulher"),
    DRPC(4, "Delegacia Regional de Polícia Civil"),
    DP(5, "Distrito Policial"),
    PM(6, "Polícia Militar"),
    PC(7, "Polícia Civil"),
    DPCAV(7, "DPCAV - Menor de Idade"),
    DFPI(7, "DFPI - Idoso");

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
