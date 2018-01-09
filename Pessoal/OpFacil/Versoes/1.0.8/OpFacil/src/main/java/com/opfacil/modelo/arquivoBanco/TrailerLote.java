/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.modelo.arquivoBanco;

import java.io.Serializable;

/**
 *
 * @author Juniel
 */
public class TrailerLote implements Serializable{
    private String campo1_5;
    private String campo2_5;
    private String campo3_5;
    private String campo4_5;
    private String campo5_5;
    private String campo6_5;
    private String campo7_5;
    private String campo8_5;
    private String campo9_5;
    private String campo10_5;

    public TrailerLote() {
        inicializar();
    }

    public TrailerLote(String campo1_5, String campo2_5, String campo3_5, String campo4_5, String campo5_5, String campo6_5, String campo7_5, String campo8_5, String campo9_5, String campo10_5) {
        this.campo1_5 = campo1_5;
        this.campo2_5 = campo2_5;
        this.campo3_5 = campo3_5;
        this.campo4_5 = campo4_5;
        this.campo5_5 = campo5_5;
        this.campo6_5 = campo6_5;
        this.campo7_5 = campo7_5;
        this.campo8_5 = campo8_5;
        this.campo9_5 = campo9_5;
        this.campo10_5 = campo10_5;
    }

    private void inicializar(){
        this.campo1_5 = "";
        this.campo2_5 = "";
        this.campo3_5 = "";
        this.campo4_5 = "";
        this.campo5_5 = "";
        this.campo6_5 = "";
        this.campo7_5 = "";
        this.campo8_5 = "";
        this.campo9_5 = "";
        this.campo10_5 = "";
    }
    public String getCampo1_5() {
        return campo1_5;
    }

    public void setCampo1_5(String campo1_5) {
        this.campo1_5 = campo1_5;
    }

    public String getCampo2_5() {
        return campo2_5;
    }

    public void setCampo2_5(String campo2_5) {
        this.campo2_5 = campo2_5;
    }

    public String getCampo3_5() {
        return campo3_5;
    }

    public void setCampo3_5(String campo3_5) {
        this.campo3_5 = campo3_5;
    }

    public String getCampo4_5() {
        return campo4_5;
    }

    public void setCampo4_5(String campo4_5) {
        this.campo4_5 = campo4_5;
    }

    public String getCampo5_5() {
        return campo5_5;
    }

    public void setCampo5_5(String campo5_5) {
        this.campo5_5 = campo5_5;
    }

    public String getCampo6_5() {
        return campo6_5;
    }

    public void setCampo6_5(String campo6_5) {
        this.campo6_5 = campo6_5;
    }

    public String getCampo7_5() {
        return campo7_5;
    }

    public void setCampo7_5(String campo7_5) {
        this.campo7_5 = campo7_5;
    }

    public String getCampo8_5() {
        return campo8_5;
    }

    public void setCampo8_5(String campo8_5) {
        this.campo8_5 = campo8_5;
    }

    public String getCampo9_5() {
        return campo9_5;
    }

    public void setCampo9_5(String campo9_5) {
        this.campo9_5 = campo9_5;
    }

    public String getCampo10_5() {
        return campo10_5;
    }

    public void setCampo10_5(String campo10_5) {
        this.campo10_5 = campo10_5;
    }
    
    
}
