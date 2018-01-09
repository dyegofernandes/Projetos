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
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class PautaDaReuniao implements Serializable {

    @Id
    @SequenceGenerator(name = "PautaDaReuniao", sequenceName = "seq_pautaDaReuniao")
    @GeneratedValue(generator = "PautaDaReuniao")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private AtaDeReuniao ataDeReuniao;
    
    @Column(columnDefinition = "Text")
    @NotBlank
    private String assunto;
    
    @Column(columnDefinition = "Text")
    @NotBlank
    private String resumoAssunto;

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

    public String getResumoAssunto() {
        return resumoAssunto;
    }

    public void setResumoAssunto(String resumoAssunto) {
        this.resumoAssunto = resumoAssunto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final PautaDaReuniao other = (PautaDaReuniao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
    
}
