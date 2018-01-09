/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel
 */
@Entity
public class ItemViatura implements Serializable {

    @Id
    @SequenceGenerator(name = "ItemViatura", sequenceName = "itemViatura_id_seq")
    @GeneratedValue(generator = "ItemViatura")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Viatura viatura;

    private String imei;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String telefone;

    @ManyToOne(fetch = FetchType.LAZY)
    private Operacao operacao;

    @Temporal(TemporalType.TIME)
    private Date inicioTurno;

    @Temporal(TemporalType.TIME)
    private Date fimTurno;

    @ManyToOne(fetch = FetchType.LAZY)
    private StatusViatura status;

    @OneToMany(targetEntity = GuarnicaoViatura.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<GuarnicaoViatura> componentes = new ArrayList<GuarnicaoViatura>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Viatura getViatura() {
        return viatura;
    }

    public void setViatura(Viatura viatura) {
        this.viatura = viatura;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Date getInicioTurno() {
        return inicioTurno;
    }

    public void setInicioTurno(Date inicioTurno) {
        this.inicioTurno = inicioTurno;
    }

    public Date getFimTurno() {
        return fimTurno;
    }

    public void setFimTurno(Date fimTurno) {
        this.fimTurno = fimTurno;
    }

    public StatusViatura getStatus() {
        return status;
    }

    public void setStatus(StatusViatura status) {
        this.status = status;
    }

    public List<GuarnicaoViatura> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<GuarnicaoViatura> componentes) {
        this.componentes = componentes;
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
        final ItemViatura other = (ItemViatura) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
