/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro;

import br.gov.pi.ati.modelo.cadastro.enums.DiretrizPPA;
import br.gov.pi.ati.modelo.cadastro.enums.TipoDePrograma;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class ProgramaDeGoverno implements Serializable {

    @Id
    @SequenceGenerator(name = "ProgramaDeGoverno", sequenceName = "programaDeGoverno_seq_id")
    @GeneratedValue(generator = "ProgramaDeGoverno")
    private Long id;

    @NotBlank
    @Size(max = 260)
    private String codigo;

    @Size(max = 260)
    @NotBlank
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DiretrizPPA diretriz;

    @Enumerated(EnumType.STRING)
    private TipoDePrograma tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    private AreaTematica areaTematica;

    private boolean ativo = true;

    @OneToMany(mappedBy = "programa")
    @NotAudited
    private List<ProgramaPPA> programas;

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

    public List<ProgramaPPA> getProgramas() {
        return programas;
    }

    public void setProgramas(List<ProgramaPPA> programas) {
        this.programas = programas;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public DiretrizPPA getDiretriz() {
        return diretriz;
    }

    public void setDiretriz(DiretrizPPA diretriz) {
        this.diretriz = diretriz;
    }

    public TipoDePrograma getTipo() {
        return tipo;
    }

    public void setTipo(TipoDePrograma tipo) {
        this.tipo = tipo;
    }

    public AreaTematica getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(AreaTematica areaTematica) {
        this.areaTematica = areaTematica;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ProgramaDeGoverno other = (ProgramaDeGoverno) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
