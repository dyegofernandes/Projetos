/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.acessoApp.vos;

/**
 *
 * @author Juniel
 */
public class TipoLocalEventoVO {

    private Long id;

    private String descricao;

    private boolean assento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAssento() {
        return assento;
    }

    public void setAssento(boolean assento) {
        this.assento = assento;
    }

   
}
