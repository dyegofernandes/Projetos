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
public enum TipoArquivoAgendamento {

    TERMO(1, "Termo de Titularidade e Responsabilidade"),
    CNH(2, "CNH Colorida"),
    RG(3, "RG Colorido"),
    CPF(4, "CPF Colorido"),
    COMPROVANTE_RESIDENCIA(5, "Comprovante de Residência"),
    OFICIO_AUTORIZACAO(6, "Ofício de Autorização/ Protocolo de Autorização");

    private TipoArquivoAgendamento(int num, String descricao) {
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
