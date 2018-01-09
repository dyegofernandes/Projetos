/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.cadastro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class GrauDeInstrucao implements Serializable {

    @Id
    @SequenceGenerator(name = "GrauDeInstrucao", sequenceName = "seq_grauDeInstrucao")
    @GeneratedValue(generator = "GrauDeInstrucao")
    private Long id;

    private Integer codigo;

    @Size(max = 260)
    @NotBlank
    private String descricao;

    private Integer sefip;

    private Integer caged;

    private Integer rais;
    
    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "grauDeInstrucao")
    private List<Servidor> servidores;
    
    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "grauDeInstrucao")
    private List<CadastroPessoal> pessoals;

    @Override
    public String toString() {
        return descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao != null) {
            descricao = descricao.trim().toUpperCase();
        }
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getSefip() {
        return sefip;
    }

    public void setSefip(Integer sefip) {
        this.sefip = sefip;
    }

    public Integer getCaged() {
        return caged;
    }

    public void setCaged(Integer caged) {
        this.caged = caged;
    }

    public Integer getRais() {
        return rais;
    }

    public void setRais(Integer rais) {
        this.rais = rais;
    }

    public List<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }

    public List<CadastroPessoal> getPessoals() {
        return pessoals;
    }

    public void setPessoals(List<CadastroPessoal> pessoals) {
        this.pessoals = pessoals;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final GrauDeInstrucao other = (GrauDeInstrucao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
