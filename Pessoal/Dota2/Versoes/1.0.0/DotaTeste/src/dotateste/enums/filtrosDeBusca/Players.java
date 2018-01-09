/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotateste.enums.filtrosDeBusca;

/**
 *
 * @author KillerBee
 */
public enum Players {

    ALLISON(100748033, "Allison"),
    APOAN(120052142, "Apoan"),
    AVELINO(98455874, "Avelino"),
    MANGA(183482669, "Manga"),
    CYB(163232633, "Cyb"),
    ERICK(220320950, "Erick"),
    GABI(130638551, "Gabriel"),
    GUI(66838329, "Guilherme"),
    GUSTAVO(99879844, "Gustavo"),
    HALLY(187547390, "Hally"),
    LUCIANO(70955571, "Luciano"),
    LORAS(101924013, "Loras"),
    NIEL(100006000, "Niel"),
    NETO(137506070, "Neto"),
    PLAPLA(100180075, "Plapla"),
    SIMPLICIO(63991544, "Simplicio"),
    ROGERIO(102499026, "Rogerio"),
    STANLEY(86864244, "Stanley"),
    SAMUEL(99826401, "Samuel"),
    SUCATA(2081590, "Sucata"),
    TARSO(57167887, "Tarso"),
    TAVARES(291570686, "Tavares"),
    THIAGO(86857087, "Thiago"),
    WHALEN(100776389, "Whalen"),
    XIMAS(119232297, "Ximas");

    private Players(Integer steamId, String descricao) {
        this.descricao = descricao;
        this.steamId = steamId;
    }

    private String descricao;
    private Integer steamId;

    public String getDescricao() {
        return descricao;
    }

    public Integer getSteamId() {
        return steamId;
    }

    public String getFilter() {
        return "excluded_account_id";
    }

}
