/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro;

import br.gov.pi.ati.modelo.cadastro.enums.TipoGrupoFonte;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class GrupoDeFonte implements Serializable {

    @Id
    @SequenceGenerator(name = "FonteDeRecurso", sequenceName = "fonteDeRecurso_seq_id")
    @GeneratedValue(generator = "FonteDeRecurso")
    private Long id;
    
    @Size(max = 50)
    @NotBlank
    private String codigo;

    @Size(max = 260)
    @NotBlank
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoGrupoFonte uso;

    @NotAudited
    @OneToMany(mappedBy = "grupoDeFonte")
    private List<FonteDeRecurso> fontes;

    @Override
    public String toString() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoGrupoFonte getUso() {
        return uso;
    }

    public void setUso(TipoGrupoFonte uso) {
        this.uso = uso;
    }

    public List<FonteDeRecurso> getFontes() {
        return fontes;
    }

    public void setFontes(List<FonteDeRecurso> fontes) {
        this.fontes = fontes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final GrupoDeFonte other = (GrupoDeFonte) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
