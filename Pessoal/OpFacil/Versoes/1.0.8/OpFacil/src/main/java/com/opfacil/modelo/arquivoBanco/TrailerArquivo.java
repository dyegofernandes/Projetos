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
public class TrailerArquivo implements Serializable {

    private String campo1_9;
    private String campo2_9;
    private String campo3_9;
    private String campo4_9;
    private String campo5_9;
    private String campo6_9;
    private String campo7_9;
    private String campo8_9;

    public TrailerArquivo() {
        inicializar();
    }

    public TrailerArquivo(String campo1_9, String campo2_9, String campo3_9, String campo4_9, String campo5_9, String campo6_9, String campo7_9, String campo8_9) {
        this.campo1_9 = campo1_9;
        this.campo2_9 = campo2_9;
        this.campo3_9 = campo3_9;
        this.campo4_9 = campo4_9;
        this.campo5_9 = campo5_9;
        this.campo6_9 = campo6_9;
        this.campo7_9 = campo7_9;
        this.campo8_9 = campo8_9;
    }
    
    private void inicializar(){
        this.campo1_9 = "";
        this.campo2_9 = "";
        this.campo3_9 = "";
        this.campo4_9 = "";
        this.campo5_9 = "";
        this.campo6_9 = "";
        this.campo7_9 = "";
        this.campo8_9 = "";
    }

    public String getCampo1_9() {
        return campo1_9;
    }

    public void setCampo1_9(String campo1_9) {
        this.campo1_9 = campo1_9;
    }

    public String getCampo2_9() {
        return campo2_9;
    }

    public void setCampo2_9(String campo2_9) {
        this.campo2_9 = campo2_9;
    }

    public String getCampo3_9() {
        return campo3_9;
    }

    public void setCampo3_9(String campo3_9) {
        this.campo3_9 = campo3_9;
    }

    public String getCampo4_9() {
        return campo4_9;
    }

    public void setCampo4_9(String campo4_9) {
        this.campo4_9 = campo4_9;
    }

    public String getCampo5_9() {
        return campo5_9;
    }

    public void setCampo5_9(String campo5_9) {
        this.campo5_9 = campo5_9;
    }

    public String getCampo6_9() {
        return campo6_9;
    }

    public void setCampo6_9(String campo6_9) {
        this.campo6_9 = campo6_9;
    }

    public String getCampo7_9() {
        return campo7_9;
    }

    public void setCampo7_9(String campo7_9) {
        this.campo7_9 = campo7_9;
    }

    public String getCampo8_9() {
        return campo8_9;
    }

    public void setCampo8_9(String campo8_9) {
        this.campo8_9 = campo8_9;
    }

}
