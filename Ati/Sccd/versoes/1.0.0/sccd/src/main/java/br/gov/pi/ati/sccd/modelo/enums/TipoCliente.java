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
    DEPARTAMENTO(5, "Departamento"),
    INSTITUICAO_PUBLICA(6, "Instituição Pública"),
    INSTITUTO(7, "Instituto"),
    EMPRESA(8, "Empresa Pública"),
    FUNDACAO(9, "Fundação"),
    FUNDO(10, "Fundo"),
    HOSPITAL(11, "Hospital"),
    SECRETARIA(12, "Secretaria"),
    PESSOA_FISICA(13,"Pessoa Física"),
    PRIVADA(14, "Empresa Privada"),
    TRIBUNAL(15, "Tribunal");

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
