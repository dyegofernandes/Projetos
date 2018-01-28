/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.weblicita.modelo.cadastro.enums;

/**
 *
 * @author Juniel
 */
public enum ParecerJuridico {

    ANEXADO(1, "Anexado em: XX / XX / XXXX"),
    FINALIZADO(2, "Finalizado/Revisto em: XX / XX / XXXX");

    private ParecerJuridico(int num, String descricao) {
        this.descricao = descricao;
        this.num = num;
    }
    private String descricao;
    private int num;

    public String getDescricao() {
        return descricao;
    }

    public int getNum() {
        return num;
    }

}
