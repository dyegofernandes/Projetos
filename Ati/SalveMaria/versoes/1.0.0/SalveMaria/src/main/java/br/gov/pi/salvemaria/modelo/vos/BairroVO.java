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
public class BairroVO {
    private Long id;
    
    private String nome;
    
    private String regiao;

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

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public BairroVO(Long id, String nome, String regiao) {
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
    }

    public BairroVO() {
    }
    
    
    
}
