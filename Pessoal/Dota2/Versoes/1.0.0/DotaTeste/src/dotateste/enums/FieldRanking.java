/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotateste.enums;

/**
 *
 * @author Juniel
 */
public enum FieldRanking {

    KILLS(0, "kills", "Kills"),
    DEATHS(1, "deaths", "Deaths"),
    ASSISTS(2, "assists", "Assists"),
    KDA(3, "kda", "KDA"),
    GPM(4, "gold_per_min", "Gold per Min (GPM)"),
    XPM(5, "xp_per_min", "Xp per Min (XPM)"),
    LH(6, "last_hits", "Last Hists (LH)"),
    DENIES(7, "denies", "Denies"),
    PWO(8, "purchase_ward_observer", "Purchase Ward Observer"),
    PWS(9, "purchase_ward_sentry", "Purchase Ward Sentry"),
    PG(10, "purchase_gem", "Purchase gem"),
    PTP(11, "purchase_tpscroll", "Purchase tpscroll"),
    APM(12, "actions_per_min", "Actions per min"),
    NK(13, "neutral_kills", "Neutral Kills"),
    HH(14, "hero_healing", "Hero healing"),
    STUNS(15, "stuns", "Stuns"),
    PR(16, "purchase_rapier", "Purchase rapier"),
    DURATION(17, "duration", "Duration"),
    LE_PCT(18, "lane_efficiency_pct", "Lane efficiency pct");

    private FieldRanking(int num, String filter, String descricao) {
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
