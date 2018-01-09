package br.gov.pi.salvemaria.constante;

/**
 *
 * @author Ayslan
 */
public class Constantes {

    /**
     * define o nome da persistence-unit padrao
     */
    public static final String PERSISTENCE_UNIT_NAME = "SalveMariaPU";
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
    
    public static final String CHAVE_API_GOOGLE_MAPS = "AIzaSyAU8b2yrLl0WX_-Jz-MD0NxXAeC6INC5W4";

    private Constantes() {
    }
}
