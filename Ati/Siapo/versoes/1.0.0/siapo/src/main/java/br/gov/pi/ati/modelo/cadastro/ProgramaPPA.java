/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro;

import br.gov.pi.ati.modelo.orcamento.MetaPPA;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class ProgramaPPA implements Serializable {

    @Id
    @SequenceGenerator(name = "ProgramaPPA", sequenceName = "programaPPA_id_seq")
    @GeneratedValue(generator = "ProgramaPPA")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private ProgramaDeGoverno programa;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private CompentenciaPPA competencia;

    @NotNull
    private BigDecimal valor;

    private boolean ativo = true;
    
    @OneToMany(mappedBy = "programa")
    @NotAudited
    private List<AcaoOrcamentaria> acoes;
    
    @OneToMany(mappedBy = "programa")
    @NotAudited
    private List<MetaPPA> metasPPA;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProgramaDeGoverno getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaDeGoverno programa) {
        this.programa = programa;
    }

    public CompentenciaPPA getCompetencia() {
        return competencia;
    }

    public void setCompetencia(CompentenciaPPA competencia) {
        this.competencia = competencia;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<AcaoOrcamentaria> getAcoes() {
        return acoes;
    }

    public void setAcoes(List<AcaoOrcamentaria> acoes) {
        this.acoes = acoes;
    }

    public List<MetaPPA> getMetasPPA() {
        return metasPPA;
    }

    public void setMetasPPA(List<MetaPPA> metasPPA) {
        this.metasPPA = metasPPA;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final ProgramaPPA other = (ProgramaPPA) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
