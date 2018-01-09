/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.vos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Juniel
 */
public class DenunciaPorTerritorioPrincipalVO implements Serializable{

    private Long id;

    private String nome;

    private List<DenunciaPorTerritorioAuxVO> violencias;

    private Integer total = 0;

    public DenunciaPorTerritorioPrincipalVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<DenunciaPorTerritorioAuxVO> getViolencias() {
        return violencias;
    }

    public void setViolencias(List<DenunciaPorTerritorioAuxVO> violencias) {
        this.violencias = violencias;
    }

    

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
