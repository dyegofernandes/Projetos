/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.modelo.arquivoBanco;

import java.io.Serializable;

/**
 *
 * @author KillerBeeTwo
 */
public class DetalheItem implements Serializable{

    private String campoTexto;
    private String campoValor;
    private String campoSinal;

    public DetalheItem() {
        inicializar();
    }

    public DetalheItem(String campoTexto, String campoValor, String campoSinal) {
        this.campoTexto = campoTexto;
        this.campoValor = campoValor;
        this.campoSinal = campoSinal;
    }

    private void inicializar() {
        this.campoTexto = "";
        this.campoValor = "";
        this.campoSinal = "";
    }

    public String getCampoTexto() {
        return campoTexto;
    }

    public void setCampoTexto(String campoTexto) {
        this.campoTexto = campoTexto;
    }

    public String getCampoValor() {
        return campoValor;
    }

    public void setCampoValor(String campoValor) {
        this.campoValor = campoValor;
    }

    public String getCampoSinal() {
        return campoSinal;
    }

    public void setCampoSinal(String campoSinal) {
        this.campoSinal = campoSinal;
    }

}
