/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum DiaSemana {

    DOMINGO("Dom", "Domingo"),
    SEGUNDA("Seg", "Segunda-feira"),
    TERCA("Ter", "Terça-feira"),
    QUARTA("Qua", "Quarta-feira"),
    QUINTA("Qui", "Quinta-feira"),
    SEXTA("Sex", "Sexta-feira"),
    SABADO("Sab", "Sábado");

    private DiaSemana(String sigla, String descricao) {
        this.descricao = descricao;
        this.sigla = sigla;
    }

    private String sigla;
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public String getSigla() {
        return sigla;
    }

}
