/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TipoCertificadoEnum {

    PF_A1("E-CPF A1 (VALIDADE 01 ANO)"),
    PF_A3("E-CPF A3 (VALIDADE 03 ANOS)"),
    PJ_A1("E-CNPJ A1 (VALIDADE 01 ANO)"),
    PJ_A3("E-CNPJ A3 (VALIDADE 03 ANO)"),
    EQP_A1("E-EQUIPAMENTO A1 (VALIDADE 01 ANO)"),
    APL_A1("E-APLICAÇÃO A-1 (VALIDADE 01 ANO)");

    private TipoCertificadoEnum(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
