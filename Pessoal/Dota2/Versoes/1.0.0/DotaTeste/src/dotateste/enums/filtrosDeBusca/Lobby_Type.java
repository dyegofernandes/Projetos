/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotateste.enums.filtrosDeBusca;

/**
 *
 * @author Juniel
 */
public enum Lobby_Type {

    NORMAL(0, "Normal"),
    PRACTICE(1, "Practice"),
    TOURNAMENT(2, "Tournament"),
    TUTORIAL(3, "Tutorial"),
    CO_OP_BOTS(4, "Co-Op Bots"),
    RANKED_TEAM_MM(5, "Ranked Team MM (Legacy)"),
    RANKED_SOLO_MM(6, "Ranked Soloam MM (Legacy)"),
    RANKED(7, "Ranked"),
    _1V1(8, "1v1 Mid"),
    BATTLE_CUP(9, "Battle Cup");

    private Lobby_Type(int num, String descricao) {
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

    public String getFilter() {
        return "lobby_type";
    }

}
