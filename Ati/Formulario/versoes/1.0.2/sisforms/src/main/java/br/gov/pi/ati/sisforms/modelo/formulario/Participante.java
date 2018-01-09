/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Participante implements Serializable {

    @Id
    @SequenceGenerator(name = "Participante", sequenceName = "seq_participante")
    @GeneratedValue(generator = "Participante")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private AtaDeReuniao ataDeReuniao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Orgao orgao;

    @Size(max = 255)
    @NotBlank
    private String nome;

    @Size(max = 255)
    @NotBlank
    private String areaFuncao;

    @Size(max = 255)
    private String telefone;

    @Size(max = 255)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtaDeReuniao getAtaDeReuniao() {
        return ataDeReuniao;
    }

    public void setAtaDeReuniao(AtaDeReuniao ataDeReuniao) {
        this.ataDeReuniao = ataDeReuniao;
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

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participante other = (Participante) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
