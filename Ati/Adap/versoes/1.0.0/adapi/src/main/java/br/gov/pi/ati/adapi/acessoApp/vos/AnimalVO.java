/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.adapi.acessoApp.vos;

import java.io.Serializable;

/**
 *
 * @author Juniel
 */
public class AnimalVO implements Serializable {

    private Long id;

    private String nome;

    private EspecieVO especie;

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

    public EspecieVO getEspecie() {
        return especie;
    }

    public void setEspecie(EspecieVO especie) {
        this.especie = especie;
    }

}
