/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.modelo.eventos;

import br.gov.pi.ati.agendacultural.modelo.cadastro.Arquivo;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Endereco;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Fone;
import br.gov.pi.ati.agendacultural.modelo.cadastro.TipoLocal;
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
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Portfolio implements Serializable {

    @Id
    @SequenceGenerator(name = "Portfolio", allocationSize = 1, sequenceName = "portfolio_id_seq")
    @GeneratedValue(generator = "Portfolio")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoLocal tipo;

    @Size(max = 256)
    @NotBlank
    private String localPortfolio;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Endereco endereco = new Endereco();

    @ManyToMany(targetEntity = DiaVisitacaoPortfolio.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<DiaVisitacaoPortfolio> diaHoraVisitacao = new ArrayList<DiaVisitacaoPortfolio>();

    @ManyToMany(targetEntity = HistoricoPortfolio.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<HistoricoPortfolio> historicos = new ArrayList<HistoricoPortfolio>();

    @ManyToMany(targetEntity = LinkPortfolio.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<LinkPortfolio> links = new ArrayList<LinkPortfolio>();

    @ManyToMany(targetEntity = Arquivo.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Arquivo> arquivos = new ArrayList<Arquivo>();

    @ManyToMany(targetEntity = Fone.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Fone> fones = new ArrayList<Fone>();

    private boolean ativo = true;

    @Override
    public String toString() {
        return localPortfolio; //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalPortfolio() {
        return localPortfolio;
    }

    public void setLocalPortfolio(String localPortfolio) {
        this.localPortfolio = localPortfolio;
    }

    public List<DiaVisitacaoPortfolio> getDiaHoraVisitacao() {
        return diaHoraVisitacao;
    }

    public void setDiaHoraVisitacao(List<DiaVisitacaoPortfolio> diaHoraVisitacao) {
        this.diaHoraVisitacao = diaHoraVisitacao;
    }

    public List<HistoricoPortfolio> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricoPortfolio> historicos) {
        this.historicos = historicos;
    }

    public List<LinkPortfolio> getLinks() {
        return links;
    }

    public void setLinks(List<LinkPortfolio> links) {
        this.links = links;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public TipoLocal getTipo() {
        return tipo;
    }

    public void setTipo(TipoLocal tipo) {
        this.tipo = tipo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Fone> getFones() {
        return fones;
    }

    public void setFones(List<Fone> fones) {
        this.fones = fones;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Portfolio other = (Portfolio) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
