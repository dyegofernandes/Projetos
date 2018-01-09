/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KillerBeeTwo
 */
public enum Tipo {

    CIPTUR(1, "Companhia Independente de Policiamento Turístico - CIPTUR"),
    BPM(2, "Batalhão de Polícia Militar"),
    DDDM(4, "Delegacias de Defesa dos Direitos da Mulher"),
    DRPC(3, "Delegacia Regional de Polícia Civil"),
    DP(5, "Distrito Policial"),
    PM(6, "Polícia Militar"),
    PC(7, "Polícia Civil"),
    DPCA(8, "DPCA - Menor de Idade"),
    DFPI(9, "DFPI - Idoso");

    private Tipo(int num, String descricao) {
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
