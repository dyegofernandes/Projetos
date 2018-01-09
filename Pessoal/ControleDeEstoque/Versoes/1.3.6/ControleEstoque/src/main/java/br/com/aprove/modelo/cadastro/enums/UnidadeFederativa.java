/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprove.modelo.cadastro.enums;

/**
 *
 * @author KillerBeeTwo
 */
public enum UnidadeFederativa {

    AC("AC", "Acre", "12"),
    AL("AL", "Alagoas", "27"),
    AP("AP", "Amapá", "16"),
    AM("AM", "Amazonas", "13"),
    BA("BA", "Bahia", "29"),
    CE("CE", "Ceará", "23"),
    DF("DF", "Distrito Federal", "53"),
    GO("GO", "Goiás", "52"),
    ES("ES", "Espírito Santo", "32"),
    MA("MA", "Maranhão", "21"),
    MT("MT", "Mato Grosso", "51"),
    MS("MS", "Mato Grosso do Sul", "50"),
    MG("MG", "Minas Gerais", "31"),
    PA("PA", "Pará", "15"),
    PB("PB", "Paraiba", "25"),
    PR("PR", "Paraná", "41"),
    PE("PE", "Pernambuco", "26"),
    PI("PI", "Piauí", "22"),
    RJ("RJ", "Rio de Janeiro", "33"),
    RN("RN", "Rio Grande do Norte", "24"),
    RS("RS", "Rio Grande do Sul", "43"),
    RO("RO", "Rondonia", "11"),
    RR("RR", "Roraima", "14"),
    SP("SP", "São Paulo", "35"),
    SC("SC", "Santa Catarina", "42"),
    SE("SE", "Sergipe", "28"),
    TO("TO", "Tocantins", "17"),
    NACIONAL("NC", "Nacional", "90"),
    RFB("RFB", "RFB", "91");

    private final String codigo;
    private final String descricao;
    private final String codigoIbge;

    private UnidadeFederativa(final String codigo, final String descricao, final String codigoIbge) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.codigoIbge = codigoIbge;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getCodigoIbge() {
        return this.codigoIbge;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }

    /**
     * Identifica a UF pela sigla ou pelo codigo IBGE.
     *
     * @param codigo Sigla ou codigo IBGE da UF.
     * @return Objeto da UF.
     */
    public static UnidadeFederativa valueOfCodigo(final String codigo) {
        for (final UnidadeFederativa uf : UnidadeFederativa.values()) {
            if (uf.getCodigo().equalsIgnoreCase(codigo)) {
                return uf;
            } else if (uf.getCodigoIbge().equalsIgnoreCase(codigo)) {
                return uf;
            }
        }
        throw new IllegalArgumentException(String.format("N\u00e3o existe o c\u00f3digo %s no mapeamento.", codigo));
    }

}
