/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dizimo.modelo.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class AtaDeReuniao implements Serializable {

    @Id
    @SequenceGenerator(name = "AtaDeReuniao", sequenceName = "atadereuniao_seq_id")
    @GeneratedValue(generator = "AtaDeReuniao")
    private Long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicial;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFinal;

    @Size(max = 250)
    @NotBlank
    private String assuntoGeral;

    @Size(max = 250)
    @NotBlank
    private String localizacao;

    @ManyToMany(targetEntity = MembroAtaReuniao.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<MembroAtaReuniao> membros = new ArrayList<MembroAtaReuniao>();

    @ManyToMany(targetEntity = Assunto.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Assunto> assuntos = new ArrayList<Assunto>();

    @Column(columnDefinition = "Text")
    private String observacoes;

    @Override
    public String toString() {
        return assuntoGeral; 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getAssuntoGeral() {
        return assuntoGeral;
    }

    public void setAssuntoGeral(String assuntoGeral) {
        this.assuntoGeral = assuntoGeral;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<MembroAtaReuniao> getMembros() {
        return membros;
    }

    public void setMembros(List<MembroAtaReuniao> membros) {
        this.membros = membros;
    }

    public List<Assunto> getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(List<Assunto> assuntos) {
        this.assuntos = assuntos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final AtaDeReuniao other = (AtaDeReuniao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
