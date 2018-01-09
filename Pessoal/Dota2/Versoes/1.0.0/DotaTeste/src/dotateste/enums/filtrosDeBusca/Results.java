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
public enum Results {

    LOSS(0, "win", "Loss"),
    WIN(1, "win", "Win");

    private Results(int num, String filter, String descricao) {
        this.descricao = descricao;
        this.num = num;
        this.filter = filter;
    }
    private String descricao;
    private String filter;
    private int num;

    public String getDescricao() {
        return descricao;
    }

    public int getNum() {
        return num;
    }

    public String getFilter() {
        return filter;
    }

}
