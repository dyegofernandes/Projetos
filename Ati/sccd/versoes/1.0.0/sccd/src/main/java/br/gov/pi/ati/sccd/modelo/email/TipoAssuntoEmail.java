package br.gov.pi.ati.sccd.modelo.email;

/**
 *
 * @author ayslan
 */
public enum TipoAssuntoEmail {

    RECUPERACAO_SENHA("Recuperação de Senha"),
    NOVO_USUARIO_SISTEMA("Novo Usuário no Sistema"),
    SOLICITACAO_AGENDAMENTO("Solicitação de Agendamento"),
    CONFIRMACAO_SOLICITACAO("Confirmação de Solicitação de Agendamento");

    private TipoAssuntoEmail(String descricao) {
        this.descricao = descricao;
    }
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
