package br.gov.pi.ati.salvavidas.constante;

/**
 *
 * @author Ayslan
 */
public class Constantes {

    /**
     * define o nome da persistence-unit padrao
     */
    public static final String PERSISTENCE_UNIT_NAME = "salvavidasPU";
    /**
     * Tipo para String sem tamanho definido. 
     * 
     * Postgres: text 
     * Oracle: clob 
     * MySQL: longtext (ou text)
     * 
     */
    public static final String TIPO_TEXTO_BANCO = "text";
    /**
     * Define o tempo em minutos de validade da recuperacao de senha
     */
    public static final int MINUTOS_VALIDADE_RECUPERACAO_SENHA = 30;
    //AIzaSyDqNlqKwp8anYtmSrccmb5FTDwO1cINm-w
    public static final String CHAVE_API_GOOGLE_MAPS = "AIzaSyCxDu6cTyu1dwnFH01sNcCnLkml6e1YbHU";

    private Constantes() {
    }
}
