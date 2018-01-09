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
public class ResponsavelVO implements Serializable{
        
    private String tipoProfissional;
    
    private String areaDeAtuacao;
    
    private String proprietario;
    
    private String nome;
    
    private String telefone;
    
      private String email;

    public String getTipoProfissional() {
        return tipoProfissional;
    }

    public void setTipoProfissional(String tipoProfissional) {
        this.tipoProfissional = tipoProfissional;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
