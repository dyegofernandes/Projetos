/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.modelo.eventos;

import br.gov.pi.ati.agendacultural.modelo.cadastro.LocalEvento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Evento implements Serializable {

    @Id
    @SequenceGenerator(name = "Evento", sequenceName = "evento_id_seq")
    @GeneratedValue(generator = "Evento")
    private Long id;

    @Size(max = 256)
    @NotBlank
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private LocalEvento localEvento;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Data Inicial do Evento é Obrigatória!")
    private Date dataInicio;

    @Temporal(TemporalType.TIME)
    private Date horaInicio;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Data final do Evento é Obrigatória!")
    private Date dataFim;

    @Temporal(TemporalType.TIME)
    private Date horaFim;

    @NotBlank
    @Column(columnDefinition = "Text")
    private String descricao;

    @ManyToMany(targetEntity = AgendaEvento.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<AgendaEvento> agenda = new ArrayList<AgendaEvento>();

    @ManyToMany(targetEntity = ValorEvento.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ValorEvento> valores = new ArrayList<ValorEvento>();

    @ManyToMany(targetEntity = CategoriaEvento.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<CategoriaEvento> categorias = new ArrayList<CategoriaEvento>();
    
    @Override
    public String toString() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<AgendaEvento> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<AgendaEvento> agenda) {
        this.agenda = agenda;
    }

    public LocalEvento getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(LocalEvento localEvento) {
        this.localEvento = localEvento;
    }

    public List<ValorEvento> getValores() {
        return valores;
    }

    public void setValores(List<ValorEvento> valores) {
        this.valores = valores;
    }

    public List<CategoriaEvento> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaEvento> categorias) {
        this.categorias = categorias;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Evento other = (Evento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
