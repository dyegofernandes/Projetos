/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisrh.modelo.cadastro.enums;

/**
 *
 * @author killerbee
 */
public enum Sexo {
    MASCULINO("Masculino"),
    FENININO("Feminino");
    

    private Sexo(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
