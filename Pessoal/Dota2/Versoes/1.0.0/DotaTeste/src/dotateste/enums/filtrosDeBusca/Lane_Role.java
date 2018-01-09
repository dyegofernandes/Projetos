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
public enum Lane_Role {

    UNKNOWN(0, "Unknown"),
    SAFE(1, "Safe"),
    MID(2, "Mid"),
    OFF(3, "Off"),
    JUNGLE(4, "Jungle");

    private Lane_Role(int num, String descricao) {
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
        return "lane_role";
    }

}
