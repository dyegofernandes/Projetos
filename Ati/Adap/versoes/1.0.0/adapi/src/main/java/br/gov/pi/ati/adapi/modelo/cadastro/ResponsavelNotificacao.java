/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.adapi.modelo.cadastro;

import br.gov.pi.ati.adapi.modelo.enums.AreaDeAtuacao;
import br.gov.pi.ati.adapi.modelo.enums.PerfilNotificador;
import br.gov.pi.ati.adapi.modelo.enums.SimOuNao;
import br.gov.pi.ati.adapi.modelo.enums.TipoProfissional;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class ResponsavelNotificacao implements Serializable {

    @Id
    @SequenceGenerator(name = "ResponsavelNotificacao", sequenceName = "responsavelNotificacao_id_seq")
    @GeneratedValue(generator = "ResponsavelNotificacao")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoProfissional tipoProfissional;

    @Enumerated(EnumType.STRING)
    private AreaDeAtuacao areaDeAtuacao;

    @Enumerated(EnumType.STRING)
    private PerfilNotificador perfilNotificador;

    @Size(max = 260)
    private String nome;

    @Size(max = 260)
    @NotBlank
    private String telefone;

    @Size(max = 260)
    @Email
    private String email;

    @Override
    public String toString() {
        return telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoProfissional getTipoProfissional() {
        return tipoProfissional;
    }

    public void setTipoProfissional(TipoProfissional tipoProfissional) {
        this.tipoProfissional = tipoProfissional;
    }

    public PerfilNotificador getPerfilNotificador() {
        return perfilNotificador;
    }

    public void setPerfilNotificador(PerfilNotificador perfilNotificador) {
        this.perfilNotificador = perfilNotificador;
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

    public AreaDeAtuacao getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(AreaDeAtuacao areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
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
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ResponsavelNotificacao other = (ResponsavelNotificacao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
