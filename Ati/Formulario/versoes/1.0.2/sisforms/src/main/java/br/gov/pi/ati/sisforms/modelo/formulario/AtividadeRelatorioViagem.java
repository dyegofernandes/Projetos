/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class AtividadeRelatorioViagem implements Serializable {

    @Id
    @SequenceGenerator(name = "AtividadeRelatorioViagem", sequenceName = "seq_atividadeRelatorioViagem")
    @GeneratedValue(generator = "AtividadeRelatorioViagem")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private RelatorioDeViagem relatorioDeViagem;

    @Column(columnDefinition = "Text")
    @NotBlank
    private String descricao;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtividade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RelatorioDeViagem getRelatorioDeViagem() {
        return relatorioDeViagem;
    }

    public void setRelatorioDeViagem(RelatorioDeViagem relatorioDeViagem) {
        this.relatorioDeViagem = relatorioDeViagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(Date dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final AtividadeRelatorioViagem other = (AtividadeRelatorioViagem) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
