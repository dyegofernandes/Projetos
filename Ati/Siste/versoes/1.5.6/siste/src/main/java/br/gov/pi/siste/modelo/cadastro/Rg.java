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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */

@Entity
public class Rg implements Serializable {

    @Id
    @SequenceGenerator(name = "Rg", sequenceName = "seq_rg")
    @GeneratedValue(generator = "Rg")
    private Long id;
    
    @Size(max = 60)
    private String numero;
    
    @Size(max = 60)
    private String orgaoExpedidor;
    
    @Temporal(TemporalType.DATE)
    private Date expedicao;

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

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        if (orgaoExpedidor != null) {
            orgaoExpedidor = orgaoExpedidor.trim().toUpperCase();
        }
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public Date getExpedicao() {
        return expedicao;
    }

    public void setExpedicao(Date expedicao) {
        this.expedicao = expedicao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Rg other = (Rg) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
    
}
