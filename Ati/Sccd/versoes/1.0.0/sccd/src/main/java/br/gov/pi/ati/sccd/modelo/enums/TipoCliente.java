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
    DEPARTAMENTO(5,"Departamento"),
    INSTITUICAO_PUBLICA(6, "Instituição Pública"),
    EMPRESA(7, "Empresa Pública"),
    FUNDACAO(8, "Fundação"),
    SECRETARIA(9, "Secretaria"),
    PRIVADA(10, "Empresa Privada");

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
