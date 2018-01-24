/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro;

import br.gov.pi.ati.util.Utils;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class CompentenciaPPA implements Serializable {

    @Id
    @SequenceGenerator(name = "CompentenciaPPA", sequenceName = "compentenciaPPA_id_seq")
    @GeneratedValue(generator = "CompentenciaPPA")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataInicial;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataFinal;

    private boolean ativo = true;
    
    @OneToMany(mappedBy = "competencia")
    @NotAudited
    private List<ProgramaPPA> programas;

    @Override
    public String toString() {
        return Utils.getAno(dataInicial).concat(" - ").concat(Utils.getAno(dataFinal));
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<ProgramaPPA> getProgramas() {
        return programas;
    }

    public void setProgramas(List<ProgramaPPA> programas) {
        this.programas = programas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final CompentenciaPPA other = (CompentenciaPPA) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
