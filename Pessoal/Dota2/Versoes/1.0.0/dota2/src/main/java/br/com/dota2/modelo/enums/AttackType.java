/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dota2.modelo.enums;

/**
 *
 * @author killerbee
 */
public enum AttackType {
    MASCULINO("Masculino"),
    FENININO("Feminino");
    

    private AttackType(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
