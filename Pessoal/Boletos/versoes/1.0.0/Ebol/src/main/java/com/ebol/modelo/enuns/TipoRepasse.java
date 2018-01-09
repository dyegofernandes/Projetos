/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebol.modelo.enuns;

/**
 *
 * @author Juniel
 */
public enum TipoRepasse {
    D0("Repasse no mesmo dia"),
    D1("Repasse no primeiro dia útil"),
    D2("Repasse no segundo dia útil"),
    D3("Repasse no terceiro dia útil"),
    SEMANAL("Repasse semanal"),
    MENSAL("Repasse mensal");
    

    private TipoRepasse(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
    
}
