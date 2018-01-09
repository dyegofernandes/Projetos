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
public class CidadeVO {
    
    private Long id;
    
    private String nome;
    
    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
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
    public CidadeVO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CidadeVO() {
    }
    
}
