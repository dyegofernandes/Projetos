/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.modelo.cadastro;

import br.gov.pi.ati.agendacultural.modelo.enums.EstiloArquitetonico;
import br.gov.pi.ati.agendacultural.modelo.eventos.DiaVisitacaoPortfolio;
import br.gov.pi.ati.agendacultural.modelo.eventos.Evento;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class LocalEvento implements Serializable {

    @Id
    @SequenceGenerator(name = "LocalEvento", sequenceName = "localEvento_id_seq")
    @GeneratedValue(generator = "LocalEvento")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoLocal tipo;

    @Size(max = 250)
    @NotBlank
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dataConstrucao;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private EstiloArquitetonico estiloArquitetonico;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Endereco endereco = new Endereco();

    private String tomabamento;

    private Integer quantidadeLugares;

    private Integer quantidadeVendasOnline;

    @ManyToMany(targetEntity = Setor.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Setor> setores = new ArrayList<Setor>();

    @ManyToMany(targetEntity = Fone.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Fone> fones = new ArrayList<Fone>();

    @ManyToMany(targetEntity = DiaVisitacaoPortfolio.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<DiaVisitacaoPortfolio> diaHoraVisitacao = new ArrayList<DiaVisitacaoPortfolio>();

    private boolean ativo = true;

    @NotAudited
    @OneToMany(mappedBy = "localEvento")
    private List<Evento> eventos;

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

    public TipoLocal getTipo() {
        return tipo;
    }

    public void setTipo(TipoLocal tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataConstrucao() {
        return dataConstrucao;
    }

    public void setDataConstrucao(Date dataConstrucao) {
        this.dataConstrucao = dataConstrucao;
    }

    public EstiloArquitetonico getEstiloArquitetonico() {
        return estiloArquitetonico;
    }

    public void setEstiloArquitetonico(EstiloArquitetonico estiloArquitetonico) {
        this.estiloArquitetonico = estiloArquitetonico;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTomabamento() {
        return tomabamento;
    }

    public void setTomabamento(String tomabamento) {
        this.tomabamento = tomabamento;
    }

    public Integer getQuantidadeLugares() {
        return quantidadeLugares;
    }

    public void setQuantidadeLugares(Integer quantidadeLugares) {
        this.quantidadeLugares = quantidadeLugares;
    }

    public Integer getQuantidadeVendasOnline() {
        return quantidadeVendasOnline;
    }

    public void setQuantidadeVendasOnline(Integer quantidadeVendasOnline) {
        this.quantidadeVendasOnline = quantidadeVendasOnline;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    public List<Fone> getFones() {
        return fones;
    }

    public void setFones(List<Fone> fones) {
        this.fones = fones;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<DiaVisitacaoPortfolio> getDiaHoraVisitacao() {
        return diaHoraVisitacao;
    }

    public void setDiaHoraVisitacao(List<DiaVisitacaoPortfolio> diaHoraVisitacao) {
        this.diaHoraVisitacao = diaHoraVisitacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final LocalEvento other = (LocalEvento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
