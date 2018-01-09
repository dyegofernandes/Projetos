/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.agendacultural.modelo.eventos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class LinkPortfolio implements Serializable {

    @Id
    @SequenceGenerator(name = "LinkPortfolio", sequenceName = "linkPortfolio_id_seq")
    @GeneratedValue(generator = "LinkPortfolio")
    private Long id;

    @Size(max = 256)
    private String link;
    
    private String descricaoLink;

    @Override
    public String toString() {
        return link; //To change body of generated methods, choose Tools | Templates.
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescricaoLink() {
        return descricaoLink;
    }

    public void setDescricaoLink(String descricaoLink) {
        this.descricaoLink = descricaoLink;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final LinkPortfolio other = (LinkPortfolio) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
    
}
