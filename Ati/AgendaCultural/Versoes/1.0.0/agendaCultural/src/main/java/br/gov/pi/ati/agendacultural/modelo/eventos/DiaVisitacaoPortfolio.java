/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.modelo.eventos;

import br.gov.pi.ati.agendacultural.modelo.enums.DiaSemana;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel
 */
@Entity
public class DiaVisitacaoPortfolio implements Serializable {

    @Id
    @SequenceGenerator(name = "DiaVisitacaoPortfolio", sequenceName = "diaVisitacaoPortfolio_id_seq")
    @GeneratedValue(generator = "DiaVisitacaoPortfolio")
    private Long id;

    @Temporal(TemporalType.TIME)
    private Date horarioInicial;

    @Temporal(TemporalType.TIME)
    private Date horarioFinal;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(Date horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public Date getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Date horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final DiaVisitacaoPortfolio other = (DiaVisitacaoPortfolio) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
