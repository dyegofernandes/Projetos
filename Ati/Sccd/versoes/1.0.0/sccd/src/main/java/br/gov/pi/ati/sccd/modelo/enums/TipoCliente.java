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
    COMPANHIA(4,"Companhia"),
    CONSELHO_ESCOLAR(5, "Conselho Escolar"),
    DEPARTAMENTO(6, "Departamento"),
    INSTITUICAO_PUBLICA(7, "Instituição Pública"),
    INSTITUTO(8, "Instituto"),
    EMPRESA(9, "Empresa Pública"),
    FUNDACAO(10, "Fundação"),
    FUNDO(11, "Fundo"),
    HOSPITAL(12, "Hospital"),
    SECRETARIA(13, "Secretaria"),
    S_A(14,"S/A"),
    PESSOA_FISICA(15,"Pessoa Física"),
    PRIVADA(16, "Empresa Privada"),
    TRIBUNAL(17, "Tribunal");

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
