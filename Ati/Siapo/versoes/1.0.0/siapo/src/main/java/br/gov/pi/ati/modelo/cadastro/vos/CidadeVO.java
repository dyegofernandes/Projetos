/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro.vos;

import java.io.Serializable;

/**
 *
 * @author Juniel
 */
public class CidadeVO implements Serializable {

    private Long id;

    private String nome;

    private Long territorio_id;

    private String territorio;

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

    public Long getTerritorio_id() {
        return territorio_id;
    }

    public void setTerritorio_id(Long territorio_id) {
        this.territorio_id = territorio_id;
    }

    public String getTerritorio() {
        return territorio;
    }

    public void setTerritorio(String territorio) {
        this.territorio = territorio;
    }
}
