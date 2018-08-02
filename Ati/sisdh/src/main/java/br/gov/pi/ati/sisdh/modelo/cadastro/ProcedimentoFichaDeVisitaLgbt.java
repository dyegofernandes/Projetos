/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.cadastro;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class ProcedimentoFichaDeVisitaLgbt implements Serializable {

    @Id
    @SequenceGenerator(name = "ProcedimentoFichaDeVisitaLgbt", sequenceName = "seq_procedimentoFichaDeVisitaLgbt")
    @GeneratedValue(generator = "ProcedimentoFichaDeVisitaLgbt")
    private Long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataProcedimento;

    @Column(columnDefinition = "Text")
    @NotBlank
    private String procedimento;

    @Override
    public int hashCode() {
        int hash = 5;
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
        final ProcedimentoFichaDeVisitaLgbt other = (ProcedimentoFichaDeVisitaLgbt) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataProcedimento() {
        return dataProcedimento;
    }

    public void setDataProcedimento(Date dataProcedimento) {
        this.dataProcedimento = dataProcedimento;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    
}
