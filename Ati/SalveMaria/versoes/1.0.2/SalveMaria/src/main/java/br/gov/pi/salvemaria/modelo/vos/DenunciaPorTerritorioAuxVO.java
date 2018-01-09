/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.vos;

/**
 *
 * @author Juniel
 */
public class DenunciaPorTerritorioAuxVO {

    private String violencia;

    private Integer total = 0;

    public String getViolencia() {
        return violencia;
    }

    public void setViolencia(String violencia) {
        this.violencia = violencia;
    }

    
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

 
    
}
