/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.enums;

/**
 *
 * @author ti05
 */
public enum Sexo {
    
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private Sexo(String descricao) {
        this.descricao = descricao;
    }
    
    String descricao;

    public String getDescricao() {
        return descricao;
    }
    
    
}
