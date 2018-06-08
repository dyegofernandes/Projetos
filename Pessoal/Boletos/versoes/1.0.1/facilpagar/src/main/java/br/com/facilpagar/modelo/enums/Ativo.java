/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facilpagar.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum Ativo {

    SIM(true, "Sim"),
    NAO(false, "Não");

    private Ativo(boolean status, String descricao) {
        this.descricao = descricao;
        this.status = status;
    }
    private String descricao;
    private boolean status;

    public String getDescricao() {
        return descricao;
    }

    public boolean isStatus() {
        return status;
    }

   
}
