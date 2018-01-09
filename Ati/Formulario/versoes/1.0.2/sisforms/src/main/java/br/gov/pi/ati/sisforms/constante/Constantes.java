package br.gov.pi.ati.sisforms.constante;

/**
 *
 * @author Ayslan
 */
public class Constantes {

    /**
     * define o nome da persistence-unit padrao
     */
    public static final String PERSISTENCE_UNIT_NAME = "sisformsPU";
    /**
     * Tipo para String sem tamanho definido.
     *
     * Postgres: text Oracle: clob MySQL: longtext (ou text)
     *
     */
    public static final String TIPO_TEXTO_BANCO = "text";
    /**
     * Define o tempo em minutos de validade da recuperacao de senha
     */
    public static final int MINUTOS_VALIDADE_RECUPERACAO_SENHA = 30;

    public static final String USUARIO_ZIMBRA = "sisforms@ati.pi.gov.br";

    public static final String SENHA_ZIMBRA = "Sysf0rms@";

    private Constantes() {
    }
}
