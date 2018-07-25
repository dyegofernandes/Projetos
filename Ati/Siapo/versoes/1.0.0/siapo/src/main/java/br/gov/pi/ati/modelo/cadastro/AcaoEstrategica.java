/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro;

import br.gov.pi.ati.modelo.orcamento.MetaAcaoEstrategica;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
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
public class AcaoEstrategica implements Serializable {

    @Id
    @SequenceGenerator(name = "AcaoEstrategica", sequenceName = "acaoestrategica_id_seq")
    @GeneratedValue(generator = "AcaoEstrategica")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private UnidadeOrcamentaria unidadeOrcamentaria;

    @Size(max = 50)
    @NotBlank
    private String codigo;

    @Column(columnDefinition = "Text")
    @NotBlank
    private String nome;

    private boolean ativo = true;
    
    @OneToMany(mappedBy = "acaoEstrategica")
    @NotAudited
    private List<MetaAcaoEstrategica> metas;
    
    @OneToMany(mappedBy = "acaoEstrategica")
    @NotAudited
    private List<AcaoOrcamentaria> acoesOrcamentarias;

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

    public UnidadeOrcamentaria getUnidadeOrcamentaria() {
        return unidadeOrcamentaria;
    }

    public void setUnidadeOrcamentaria(UnidadeOrcamentaria unidadeOrcamentaria) {
        this.unidadeOrcamentaria = unidadeOrcamentaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<MetaAcaoEstrategica> getMetas() {
        return metas;
    }

    public void setMetas(List<MetaAcaoEstrategica> metas) {
        this.metas = metas;
    }

    public List<AcaoOrcamentaria> getAcoesOrcamentarias() {
        return acoesOrcamentarias;
    }

    public void setAcoesOrcamentarias(List<AcaoOrcamentaria> acoesOrcamentarias) {
        this.acoesOrcamentarias = acoesOrcamentarias;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final AcaoEstrategica other = (AcaoEstrategica) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
