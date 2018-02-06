/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.orcamento;

import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import br.gov.pi.ati.modelo.cadastro.ProgramaPPA;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class MetaAcaoEstrategica implements Serializable {

    @Id
    @SequenceGenerator(name = "MetaAcaoEstrategica", sequenceName = "metaAcaoEstrategica_id_seq")
    @GeneratedValue(generator = "MetaAcaoEstrategica")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private AcaoEstrategica acaoEstrategica;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private ProgramaPPA programaPPA;

    @ManyToMany(targetEntity = ReceitaMetaAcaoEstrategica.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ReceitaMetaAcaoEstrategica> receitas = new ArrayList<ReceitaMetaAcaoEstrategica>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AcaoEstrategica getAcaoEstrategica() {
        return acaoEstrategica;
    }

    public void setAcaoEstrategica(AcaoEstrategica acaoEstrategica) {
        this.acaoEstrategica = acaoEstrategica;
    }

    public ProgramaPPA getProgramaPPA() {
        return programaPPA;
    }

    public void setProgramaPPA(ProgramaPPA programaPPA) {
        this.programaPPA = programaPPA;
    }

    public List<ReceitaMetaAcaoEstrategica> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<ReceitaMetaAcaoEstrategica> receitas) {
        this.receitas = receitas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final MetaAcaoEstrategica other = (MetaAcaoEstrategica) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
