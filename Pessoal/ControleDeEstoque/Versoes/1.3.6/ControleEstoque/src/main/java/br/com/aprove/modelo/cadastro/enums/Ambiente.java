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
public enum Ambiente {
    PRODUCAO("1","Produção"),
    HOMOLOGACAO("2","Homologação");
    

    private Ambiente(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    private String descricao;
    private String codigo;

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }

}
