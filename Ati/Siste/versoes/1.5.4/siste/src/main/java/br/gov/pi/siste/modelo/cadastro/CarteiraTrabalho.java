/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.cadastro;

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
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class CarteiraTrabalho implements Serializable {

    @Id
    @SequenceGenerator(name = "CarteiraTrabalho", sequenceName = "seq_carteiraTrabalho")
    @GeneratedValue(generator = "CarteiraTrabalho")
    private Long id;

    @Size(max = 60)
    private String numero;

    @Size(max = 60)
    private String serie;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidade;

    @Temporal(TemporalType.DATE)
    private Date dataCarteira;

    @Size(max = 60)
    @NotBlank
    private String pisPasepNit;

    @Size(max = 60)
    private String anoPis;

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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Date getDataCarteira() {
        return dataCarteira;
    }

    public void setDataCarteira(Date dataCarteira) {
        this.dataCarteira = dataCarteira;
    }

    public String getPisPasepNit() {
        return pisPasepNit;
    }

    public void setPisPasepNit(String pisPasepNit) {
        this.pisPasepNit = pisPasepNit;
    }

    public String getAnoPis() {
        return anoPis;
    }

    public void setAnoPis(String anoPis) {
        this.anoPis = anoPis;
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
        final CarteiraTrabalho other = (CarteiraTrabalho) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
