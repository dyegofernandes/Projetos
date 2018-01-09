/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.cadastro.enums;

/**
 *
 * @author Juniel
 */
public enum TipoDateFormat {
    DDMMYYYY_SEM_BARRA("ddMMyyyy"),
    DDMMYYYYCOM_BARRA("dd/MM/yyyy"),
    DDMM_SEM_BARRA("ddMM"),
    DDMM_COM_BARRA("dd/MM"),
    MMYYYY_SEM_BARRA("MMyyyy"),
    MMYYYY_COM_BARRA("MM/yyyy");
    

    private TipoDateFormat(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
