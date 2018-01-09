/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import br.gov.pi.ati.sisforms.modelo.formulario.AtaDeReuniao;
import java.io.Serializable;
import javax.persistence.Column;
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
public class Observacao implements Serializable {

    @Id
    @SequenceGenerator(name = "Observacao", sequenceName = "seq_observacao")
    @GeneratedValue(generator = "Observacao")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private AtaDeReuniao ataDeReuniao;
    
    @Size(max = 255)
    @NotBlank
    private String assunto;
    
    @NotBlank
    @Column(columnDefinition = "Text")
    private String observacao;

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

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Observacao other = (Observacao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
     
}
