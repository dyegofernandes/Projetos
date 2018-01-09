/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.modelo.cadastro.enums;

/**
 *
 * @author killerbee
 */
public enum LoteIndicadorProcessamento {

    PROCESSAMENTO_ASSINCRONO("0", "Assincrono"), PROCESSAMENTO_SINCRONO("1", "Sincrono");

    private LoteIndicadorProcessamento(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    private String codigo;
    private String descricao;

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static LoteIndicadorProcessamento valueOfCodigo(final String codigo) {
        for (final LoteIndicadorProcessamento indicadorProcessamento : LoteIndicadorProcessamento.values()) {
            if (indicadorProcessamento.getCodigo().equals(codigo)) {
                return indicadorProcessamento;
            }
        }
        return null;
    }
}
