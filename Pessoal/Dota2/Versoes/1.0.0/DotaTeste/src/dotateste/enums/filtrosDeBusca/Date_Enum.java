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
public enum Date_Enum {

    LAST_WEEK(7, "Last Week"),
    LAST_MONTH(30, "Last Month"),
    LAST_3_MONTHS(90, "Last 3 Months"),
    LAST_6_MONTHS(180, "Last 6 Months");

    private Date_Enum(int num, String descricao) {
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
        return "date";
    }

}
