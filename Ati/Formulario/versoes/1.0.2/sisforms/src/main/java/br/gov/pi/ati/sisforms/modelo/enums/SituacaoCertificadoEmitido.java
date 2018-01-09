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
public enum SituacaoCertificadoEmitido {

    EM_ANDAMENTO_AGUARDANDO_AGENDAMENTO("Em Andamento - Aguardando Agendamento"),
    EM_ANDAMENTO_AGUARDANDO_INTERESSADO("Em Andamento - Aguardando Interessado"),
    DEVOLVIDO_DEFERIDO_CERTIFICADO_EMITIDO("Devolvido (Deferido) - Certificado emitido"),
    DEVOLVIDO_DEFERIDO_NAO_COMPARECEU("Devolvido (Deferido) - Não compareceu"),
    DEVOLVIDO_DEFERIDO_DESISTENCIA("Devolvido (Deferido) - Desistência"),
    DEVOLVIDO_INDEFERIDO("Devolvido (Indeferido)");

    private SituacaoCertificadoEmitido(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
