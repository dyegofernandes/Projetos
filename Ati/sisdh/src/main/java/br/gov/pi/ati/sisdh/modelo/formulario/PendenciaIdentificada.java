/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.formulario;

import br.gov.pi.ati.sisdh.modelo.cadastro.Orgao;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class PendenciaIdentificada implements Serializable {

    @Id
    @SequenceGenerator(name = "Observacao", sequenceName = "seq_observacao")
    @GeneratedValue(generator = "Observacao")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private AtaDeReuniao ataDeReuniao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Orgao orgao;
    
    @Size(max = 255)
    @NotBlank
    private String pendencia;
    
    @Size(max = 255)
    @NotBlank
    private String responsavel;
    
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataPrevista;

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

    public String getPendencia() {
        return pendencia;
    }

    public void setPendencia(String pendencia) {
        this.pendencia = pendencia;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final PendenciaIdentificada other = (PendenciaIdentificada) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}

