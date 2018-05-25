package br.gov.pi.salvemaria.acessoapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Juniel
 */
public class Filtros {

    private String dataInicial;

    private String dataFinal;

    private String tipo;

    private String bairro;

    private Long cidade_id;
    
    private Long unidade_id;
    
    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getCidade_id() {
        return cidade_id;
    }

    public void setCidade_id(Long cidade_id) {
        this.cidade_id = cidade_id;
    }

    public Long getUnidade_id() {
        return unidade_id;
    }

    public void setUnidade_id(Long unidade_id) {
        this.unidade_id = unidade_id;
    }

    
}
