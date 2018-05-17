/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TipoCliente {

    AGENCIA(1, "Agência"),
    AUTARQUIA(2, "Autarquia"),
    COORDENADORIA(3, "Coordenadoria"),
    CONSELHO_ESCOLAR(4, "Conselho Escolar"),
    EMPRESA(5, "Empresa"),
    FUNDACAO(6, "Fundação"),
    SECRETARIA(7, "Secretaria"),
    PRIVADA(8, "Empresa Privada");

    private TipoCliente(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }
    private String descricao;

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDescricao() {
        return descricao;
    }
}
