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
public enum Side {

    DIRE(0, "Dire"),
    RADIANT(1, "Radiant");

    private Side(int num, String descricao) {
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
        return "is_radiant";
    }

}
