/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.enums;

/**
 *
 * @author killerbee
 */
public enum AreaAtuacao {
    PSICOLOGO("Psicologo"),
    ASSESSORIA_JURIDICA("Assessoria Jurídica"),
    SERVICO_SOCIAL("Serviço Social");
    

    private AreaAtuacao(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
