/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.modelo.cadastro;

import br.gov.pi.ati.agendacultural.modelo.eventos.Portfolio;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class TipoLocal implements Serializable {

    @Id
    @SequenceGenerator(name = "TipoLocal", sequenceName = "tipoLocal_id_seq")
    @GeneratedValue(generator = "TipoLocal")
    private Long id;

    @Size(max = 256)
    @NotBlank
    private String descricao;

    private boolean assento = false;

    private boolean ativo = true;

    @NotAudited
    @OneToMany(mappedBy = "tipo")
    private List<LocalEvento> locais;
    
    @NotAudited
    @OneToMany(mappedBy = "tipo")
    private List<Portfolio> portfolios;

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
        this.descricao = descricao;
    }

    public boolean isAssento() {
        return assento;
    }

    public void setAssento(boolean assento) {
        this.assento = assento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<LocalEvento> getLocais() {
        return locais;
    }

    public void setLocais(List<LocalEvento> locais) {
        this.locais = locais;
    }

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final TipoLocal other = (TipoLocal) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
