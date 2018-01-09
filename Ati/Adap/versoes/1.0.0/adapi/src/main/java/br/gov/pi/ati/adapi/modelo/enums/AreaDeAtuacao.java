/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.adapi.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum AreaDeAtuacao {

    LABORATORIO_DE_DIAGNOSTICO("Laboratório de diagnóstico"),
    INSTITUICAO_DE_ENSINO_OU_PESQUISA("Instituição de Ensino ou Pesquisa"),
    OUTRAS_INSTITUICOES_GOVERNAMENTAIS("Outras Instituições governamentais"),
    INICIATIVA_PRIVADA("Iniciativa Privada"),
    OUTROS("Outros");

    private AreaDeAtuacao(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
