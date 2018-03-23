/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pagcontascarne.modelo.dados.vos;

import java.io.Serializable;

/**
 *
 * @author Juniel
 */
public class CodigoDeBarrasVO implements Serializable {

    private String codigoBanco;

    private String codigoMoeda;

    private String fatorDeVencimento;

    private String fatorNominalDocumento;

    private String codigoCarteira;

    private String codigoCooperativa;

    private String modalidade;

    private String codigoCliente;

    private String numeroTitulo;

    private String parcela;

    private String dv;

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getCodigoMoeda() {
        return codigoMoeda;
    }

    public void setCodigoMoeda(String codigoMoeda) {
        this.codigoMoeda = codigoMoeda;
    }

    public String getFatorDeVencimento() {
        return fatorDeVencimento;
    }

    public void setFatorDeVencimento(String fatorDeVencimento) {
        this.fatorDeVencimento = fatorDeVencimento;
    }

    public String getFatorNominalDocumento() {
        return fatorNominalDocumento;
    }

    public void setFatorNominalDocumento(String fatorNominalDocumento) {
        this.fatorNominalDocumento = fatorNominalDocumento;
    }

    public String getCodigoCarteira() {
        return codigoCarteira;
    }

    public void setCodigoCarteira(String codigoCarteira) {
        this.codigoCarteira = codigoCarteira;
    }

    public String getCodigoCooperativa() {
        return codigoCooperativa;
    }

    public void setCodigoCooperativa(String codigoCooperativa) {
        this.codigoCooperativa = codigoCooperativa;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNumeroTitulo() {
        return numeroTitulo;
    }

    public void setNumeroTitulo(String numeroTitulo) {
        this.numeroTitulo = numeroTitulo;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    @Override
    public String toString() {
        return codigoBanco + codigoMoeda + dv + fatorDeVencimento + fatorNominalDocumento + codigoCarteira + codigoCooperativa + modalidade + codigoCliente + numeroTitulo + parcela;
    }

}
