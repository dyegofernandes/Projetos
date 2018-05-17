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

    COMPROVANTE_RESIDENCIA(1, "Comprovante de Residência"),
    CONTRATO_SOCIAL(2, "Contrato Social"),
    CNH(3, "CNH Colorida"),
    CPF(4, "CPF Colorido"),
    ESTATUTO(5, "Estatuto"),
    LEI_DE_CRIACAO(6, "Lei de Criação"),
    NOMEACAO_DIARIO_OFICIAL(7, "Nomeação publicada no Diário Oficial do Piauí"),
    OFICIO_SOLICITACAO(8, "Ofício de Solicitação"),
    PIS_PASEP(9, "PIS/PASEP"),
    RG(10, "RG Colorido"),
    TERMO(11, "Termo de Titularidade e Responsabilidade");

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
