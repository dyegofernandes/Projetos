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
public class PatrulhaAux implements Serializable {

    @Id
    @SequenceGenerator(name = "PatrulhaAux", sequenceName = "patrulhaAux_id_seq")
    @GeneratedValue(generator = "PatrulhaAux")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patrulha patrulha;

    @Temporal(TemporalType.DATE)
    private Date dataDespacho = new Date();

    @Temporal(TemporalType.TIME)
    private Date horaDespacho = new Date();

    @Temporal(TemporalType.TIME)
    private Date horaChegadaLocal;

    @Temporal(TemporalType.TIME)
    private Date horaSaidaLocal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patrulha getPatrulha() {
        return patrulha;
    }

    public void setPatrulha(Patrulha patrulha) {
        this.patrulha = patrulha;
    }

    public Date getDataDespacho() {
        return dataDespacho;
    }

    public void setDataDespacho(Date dataDespacho) {
        this.dataDespacho = dataDespacho;
    }

    public Date getHoraDespacho() {
        return horaDespacho;
    }

    public void setHoraDespacho(Date horaDespacho) {
        this.horaDespacho = horaDespacho;
    }

    public Date getHoraChegadaLocal() {
        return horaChegadaLocal;
    }

    public void setHoraChegadaLocal(Date horaChegadaLocal) {
        this.horaChegadaLocal = horaChegadaLocal;
    }

    public Date getHoraSaidaLocal() {
        return horaSaidaLocal;
    }

    public void setHoraSaidaLocal(Date horaSaidaLocal) {
        this.horaSaidaLocal = horaSaidaLocal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final PatrulhaAux other = (PatrulhaAux) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
