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
public enum Game_Mode {

    UNKNOWN(0, "Unknown"),
    ALL_PICK(1, "Practice"),
    CAPTAINS_MODE(2, "Captains Mode"),
    RANDOM_DRAFT(3, "Random Draft"),
    SINGLE_DRAFT(4, "Single Draft"),
    ALL_RANDOM(5, "All Random"),
    INTRO(6, "Intro"),
    DIRETIDE(7, "Diretide"),
    REVERSE_CAPTAINS_MODE(8, "Reverse Captains Mode"),
    THE_GREEVILING(9, "The Greeviling");

    private Game_Mode(int num, String descricao) {
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
        return "game_mode";
    }

}
