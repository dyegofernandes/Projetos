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
public enum TypePerson {

    INDIVIDUAL_PERSON(1, "Físca"),
    LEGAL_PERSON(2, "Juridica");

    private TypePerson(int code, String text) {
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
