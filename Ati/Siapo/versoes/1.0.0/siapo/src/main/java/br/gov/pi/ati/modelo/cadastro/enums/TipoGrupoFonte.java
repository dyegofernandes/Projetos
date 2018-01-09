/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro.enums;

/**
 *
 * @author Juniel
 */
public enum TipoGrupoFonte {

    RECURSOS_DO_ESTADO(1, "Recursos do Estado"),
    RECURSOS_EXTERNOS(2, "Recursos Externos");

    private TipoGrupoFonte(int num, String descricao) {
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
