/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.vos;

import java.io.Serializable;

/**
 *
 * @author Juniel
 */
public class DestribuicaoViolenciaPorTDVO implements Serializable{
    private Long id;
    
    private String nomeTerritorio;
    
    private String tipoViolencia;
    
    private Integer total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTerritorio() {
        return nomeTerritorio;
    }

    public void setNomeTerritorio(String nomeTerritorio) {
        this.nomeTerritorio = nomeTerritorio;
    }

    public String getTipoViolencia() {
        return tipoViolencia;
    }

    public void setTipoViolencia(String tipoViolencia) {
        this.tipoViolencia = tipoViolencia;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
    
}
