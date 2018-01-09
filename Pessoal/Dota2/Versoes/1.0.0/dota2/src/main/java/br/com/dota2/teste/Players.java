/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dota2.teste;

/**
 *
 * @author KillerBee
 */
public enum Players {

    ALLISON(100748033, "Allison"),
    APOAN(120052142, "Apoan"),
    AVELINO(98455874, "Avelino"),
    CYB(163232633, "Cyb"),
    ERICK(220320950, "Erick"),
    GABI(130638551, "Gabriel"),
    GUI(66838329, "Guilherme"),
    GUSTAVO(99879844, "Gustavo"),
    HALLY(187547390, "Hally"),
    NIEL(100006000, "Niel"),
    NETO(137506070, "Neto"),
    LORAS(101924013, "Loras"),
    SIMPLICIO(63991544, "Simplicio"),
    STANLEY(86864244, "Stanley"),
    SUCATA(2081590, "Sucata"),
    TARSO(57167887, "Tarso"),
    TAVARES(291570686,"Tavares"),
    THIAGO(86857087, "Thiago");

    private Players(Integer steamId, String descricao) {
        this.descricao = descricao;
        this.steamId = steamId;
    }

    private String descricao;
    private Integer steamId;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getSteamId() {
        return steamId;
    }

    public void setSteamId(Integer steamId) {
        this.steamId = steamId;
    }

}
