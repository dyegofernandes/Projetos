/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.cadastro.enums;

/**
 *
 * @author ads-pc
 */
public enum Mes {
    JANEIRO("01", "Janeiro"),
    FEVEREIRO("02", "Fevereiro"),
    MARCO("03", "Março"),
    ABRIL("04", "Abril"),
    MAIO("05", "Maio"),
    JUNHO("06", "Junho"),
    JULHO("07", "Julho"),
    AGOSTO("08", "Agosto"),
    SETEMBRO("09", "Setembro"),
    OUTUBRO("10", "Outubro"),
    NOVEMBRO("11", "Novembro"),
    DEZEMBRO("12", "Dezembro");

    private Mes(String num, String descricao) {
        this.num = num;
        this.descricao = descricao;
    }
    private String descricao;
    private String num;

    public String getDescricao() {
        return descricao;
    }

    public String getNum() {
        return num;
    }
}
