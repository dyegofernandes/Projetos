/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.cadastro.enums;

/**
 *
 * @author killerbee
 */
public enum TipoPessoa {
    PF(1,"Pessoa Física"),
    PJ(2,"Pessoa Jurídica");
    

    private TipoPessoa(int num, String descricao) {
        this.num = num;
        this.descricao = descricao;
    }
    private String descricao;
    private int num;

    public int getNum() {
        return num;
    }

    public String getDescricao() {
        return descricao;
    }
}
