/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.vos;

import br.gov.pi.ati.sisforms.modelo.formulario.Participante;
import java.io.Serializable;

/**
 *
 * @author Juniel
 */
public class ParticipanteVO implements Serializable {

    private String orgao;

    private String nome;

    private String areaFuncao;

    private String telefone;

    private String email;

    public String getOrgao() {
        return orgao;
    }

    public ParticipanteVO(Participante participante) {
//        this.orgao = participante.getOrgao().getNome();
        this.nome = participante.getNome();
        this.areaFuncao = participante.getAreaFuncao();
        this.telefone = participante.getTelefone();
        this.email = participante.getEmail();
    }
    
     public ParticipanteVO(){
         
     }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAreaFuncao() {
        return areaFuncao;
    }

    public void setAreaFuncao(String areaFuncao) {
        this.areaFuncao = areaFuncao;
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
