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
public enum CategoriaTitular {

    EFETIVO(1, "Efetivo"),
    COMISSIONADO(2, "Comissionado"),
    TERCERIZADO(50, "Tercerizado"),
    PESSOA_JURIDICA(51, "Pessoa Jurídica"),
    EQUIPAMENTO(52, "Equipamento");
//    EFETIVO(6, "Física"),
//    EFETIVO(7, "Física"),
//    EFETIVO(8, "Física"),
//    EFETIVO(9, "Física"),
//    EFETIVO(10, "Física"),
//    EFETIVO(11, "Física"),
//    EFETIVO(12, "Física"),
//    EFETIVO(13, "Física"),
//    EFETIVO(14, "Física"),
//    EFETIVO(15, "Física"),
//    EFETIVO(1, "Física"),
//    EFETIVO(1, "Física"),;

    private CategoriaTitular(int num, String descricao) {
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
