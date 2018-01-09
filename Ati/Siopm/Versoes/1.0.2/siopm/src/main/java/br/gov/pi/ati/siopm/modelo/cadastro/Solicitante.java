/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import br.gov.pi.ati.siopm.modelo.enums.Anonimo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class Solicitante implements Serializable {

    @Id
    @SequenceGenerator(name = "Solicitante", sequenceName = "solicitante_id_seq")
    @GeneratedValue(generator = "Solicitante")
    private Long id;

    @Size(max = 260)
    private String nome;

    @Enumerated(EnumType.STRING)
    private Anonimo anonimo = Anonimo.SIM;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Telefone telefone = new Telefone();

    @Temporal(TemporalType.TIME)
    private Date horarioSolicitacao = new Date();

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

    public Anonimo getAnonimo() {
        return anonimo;
    }

    public void setAnonimo(Anonimo anonimo) {
        this.anonimo = anonimo;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Date getHorarioSolicitacao() {
        return horarioSolicitacao;
    }

    public void setHorarioSolicitacao(Date horarioSolicitacao) {
        this.horarioSolicitacao = horarioSolicitacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Solicitante other = (Solicitante) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
