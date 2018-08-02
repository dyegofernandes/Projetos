/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.cadastro.enums;

/**
 *
 * @author Juniel
 */
public enum Raca {
    
    BRANCA(1,"Branca"),
    PRETA(2,"Preta"),
    PARDA(3,"Parda"),
    AMARELA(4,"Amarela"),
    INDIGENA(5,"Indigena"),
    SEM_INFORMACAO(99,"Sem Informação");
    

    private Raca(int num, String descricao) {
        this.num = num;
        this.descricao = descricao;
    }
    private int num;
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public int getNum() {
        return num;
    }
    
}
