/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.politicalpartysystem.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TypePoliticalParty {

    NATIONAL(0, "Nacional"),
    STATE(1, "Estadual"),
    MUNICIPAL(2, "Municipal");

    private TypePoliticalParty(int code, String text) {
        this.text = text;
        this.code = code;
    }

    private String text;
    private int code;

    public String getText() {
        return text;
    }

    public int getCode() {
        return code;
    }
}
