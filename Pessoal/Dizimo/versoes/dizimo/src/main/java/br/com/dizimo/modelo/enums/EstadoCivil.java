/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dizimo.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum EstadoCivil {
    SOLTEIRO(1,"Solteiro(a)"),
    CASADO(2,"Casado(a)"),
    DIVORCIADO(3,"Divorciado(a)"),
    VIUVO(4,"Viúvo(a)"),
    SEPARADO(5,"Separado(a)"),
    COMPANHEIRO(6,"Companheiro(a)");

    private EstadoCivil(int num, String descricao) {
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

    public void setNum(int num) {
        this.num = num;
    }
    
    
}
