/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel
 */
@Entity
public class LocalIntermediarioAux implements Serializable {

    @Id
    @SequenceGenerator(name = "LocalIntermediarioAux", sequenceName = "localIntermediarioAux_id_seq")
    @GeneratedValue(generator = "LocalIntermediarioAux")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private LocalIntermediario local;

    @Temporal(TemporalType.TIME)
    private Date horaChegada;

    @Temporal(TemporalType.TIME)
    private Date horaSaida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalIntermediario getLocal() {
        return local;
    }

    public void setLocal(LocalIntermediario local) {
        this.local = local;
    }

    public Date getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(Date horaChegada) {
        this.horaChegada = horaChegada;
    }

    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final LocalIntermediarioAux other = (LocalIntermediarioAux) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
