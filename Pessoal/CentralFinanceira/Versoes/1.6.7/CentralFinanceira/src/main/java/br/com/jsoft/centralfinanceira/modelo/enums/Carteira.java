/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum Carteira {

    COBRANCA_SIMPLES_BB(11, "Cobrança simples"),
    COBRANCA_SIMPLES_UNI_VARIA_BB(12, "Cobrança simples em unidades variáveis"),
    COBRANCA_DIRETA_ADMIN_BB(13, "Cobrança direta administrativa"),
    COBRANCA_PREMIO_SEG_BB(15, "Cobrança premios de seguro"),
    COBRANCA_DIRETA_RECEB_BBCARNAS_ASS(16, "Cobrança direta - recebimento de carnes e assemelhados"),
    COBRANCA_DIRETA_ESPECIAL_BB(17, "Cobrança direta especial"),
    COBRANCA_DIRETA_LIVRE_PRE_IMP_BB(18, "Cobrança direta livre - pré-impressa"),
    PENHOR_CEDU_CAUCAO_FIXO_BB(31, "Penhor cedular -  caução fixo"),
    COBRANCA_DESCONTADA_BB(51, "Cobrança descontada"),
    COBRANCA_SIMPLES_BRA(6, "Cobrança simples"),
    COBRANCA_DESCONTADA_BRA(7, "Cobrança descontada"),
    COBRANCA_CAUCIONADA_BRA(9, "Cobrança Caucionada"),
    COBRANCA_REGISTRADA_BRA(16, "Cobrança Registrada"),
    COBRANCA_CONVENIADA_BRA(91, "Cobrança Conveniada"),
    COBRANCA_SIMPLES_CEF(11, "Cobrança Simples - SICOB"),
    COBRANCA_RAPIDA_CEF(12, "Cobrança Rápida - SICOB"),
    COBRANCA_SEM_REGISTRO_CEF(14, "Cobrança Sem Registro - SICOB"),
    COBRANCA_SEM_REGISTR_CEF(1, "Cobrança Sem Registrada - SICOB"),
    COBRANCA_SIMPLES_240_CEF(1, "Cobrança Simples - SICOB 240"),
    COBRANCA_CAUCIONADA_CEF(3, "Cobrança Caucionada - SICOB 240");
    
//    COBRANCA_DESCONTADA_BRA(3, "Cobrança Caucionada"),
//    COBRANCA_CAUCIONADA_BRA(9, "Cobrança Caucionada"), desconbrir depois pq tem varios repetidos
//    COBRANCA_REGISTRADA_BRA(16, "Cobrança Registrada"),
//    COBRANCA_CONVENIADA_BRA(91, "Cobrança Conveniada"),

    private Carteira(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    String descricao;
    int codigo;

    public String getDescricao() {
        return descricao;
    }

    public int getCodigo() {
        return codigo;
    }

}
