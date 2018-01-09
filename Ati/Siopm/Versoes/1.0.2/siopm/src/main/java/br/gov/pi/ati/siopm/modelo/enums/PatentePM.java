/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum PatentePM {

    CORONEL(1, "Coronel"),
    TENENTE_CORONEL(2, "Ten. Coronel"),
    MAJOR(3, "Major"),
    CAPITAO(4, "Capitão"),
    PRIMEIRO_TENENTE(5, "1° Tenente"),
    SEGUNDO_TENENTE(6, "2° Tenente"),
    SUB_TENENTE(7, "Sub. Tenente"),
    PRIMEIRO_SARGENTO(8, "1° Sargento"),
    SEGUNDO_SARGENTO(9, "2° Sargento"),
    TERCEIRO_SARGENTO(10, "3° Sargento"),
    CABO(11, "Cabo"),
    SOLDADO(12, "Soldado"),;

    private PatentePM(int num, String descricao) {
        this.num = num;
        this.descricao = descricao;
    }
    private String descricao;
    private int num;

    public int getNum() {
        return num;
    }

    public String getDescricao() {
        return descricao;
    }
}
