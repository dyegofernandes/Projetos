/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.cadastro;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class TituloEleitoral implements Serializable {

    @Id
    @SequenceGenerator(name = "TituloEleitoral", sequenceName = "seq_tituloEleitoral")
    @GeneratedValue(generator = "TituloEleitoral")
    private Long id;

    @Size(max = 60)
    private String numero;

    @Size(max = 60)
    private String digito;

    @Size(max = 60)
    private String zona;

    @Size(max = 60)
    private String secao;

    @Temporal(TemporalType.DATE)
    private Date dataTitulo;

    @Override
    public String toString() {
        return numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public Date getDataTitulo() {
        return dataTitulo;
    }

    public void setDataTitulo(Date dataTitulo) {
        this.dataTitulo = dataTitulo;
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
        final TituloEleitoral other = (TituloEleitoral) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
