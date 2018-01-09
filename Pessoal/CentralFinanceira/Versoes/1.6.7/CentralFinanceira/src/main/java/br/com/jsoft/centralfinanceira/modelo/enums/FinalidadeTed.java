/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum FinalidadeTed {
    
    SEMCONTA(1, "Sem Conta"),
    CONTACORRENTE(2, "Conta corrente"),
    POUPANCA(3, "Poupança");
   

    private FinalidadeTed(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    String descricao;
    int codigo;

    public String getDescricao() {
        return descricao;
    }

    public int getCodigo() {
        return codigo;
    }
    
    }
