/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.modelo.cadastro.enums;

/**
 *
 * @author Juniel
 */
public enum StatusLote {

    AUTORIZADO("Autorizado"),
    NAO_AUTORIZADO("Não autorizado"),
    SEM_CONEXAO("Sem conexão");

    private StatusLote(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
