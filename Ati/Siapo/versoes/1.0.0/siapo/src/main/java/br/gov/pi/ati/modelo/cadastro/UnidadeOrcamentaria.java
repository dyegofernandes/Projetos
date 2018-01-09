/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class UnidadeOrcamentaria implements Serializable {

    @Id
    @SequenceGenerator(name = "UnidadeOrcamentaria", sequenceName = "unidadeOrcamentaria_id_seq")
    @GeneratedValue(generator = "UnidadeOrcamentaria")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private UnidadeGestora unidadeGestora;

    @Size(max = 50)
    @NotBlank
    private String codigo;

    @Size(max = 250)
    @NotBlank
    private String nome;

    @Size(max = 50)
    private String mnemonico;

    private boolean ativo = true;

    @OneToMany(mappedBy = "unidadeOrcamentaria")
    @NotAudited
    private List<DiretrizeDeGoverno> diretrizes;

    @OneToMany(mappedBy = "unidadeOrcamentaria")
    @NotAudited
    private List<ProgramaDeGoverno> programas;

    @Override
    public String toString() {
        return codigo.concat(" - ").concat(nome);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMnemonico() {
        return mnemonico;
    }

    public void setMnemonico(String mnemonico) {
        this.mnemonico = mnemonico;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public UnidadeGestora getUnidadeGestora() {
        return unidadeGestora;
    }

    public void setUnidadeGestora(UnidadeGestora unidadeGestora) {
        this.unidadeGestora = unidadeGestora;
    }

    public List<DiretrizeDeGoverno> getDiretrizes() {
        return diretrizes;
    }

    public void setDiretrizes(List<DiretrizeDeGoverno> diretrizes) {
        this.diretrizes = diretrizes;
    }

    public List<ProgramaDeGoverno> getProgramas() {
        return programas;
    }

    public void setProgramas(List<ProgramaDeGoverno> programas) {
        this.programas = programas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final UnidadeOrcamentaria other = (UnidadeOrcamentaria) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
