/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.politicalpartysystem.modelo.cadastro;

import br.com.politicalpartysystem.modelo.controleacesso.Usuario;
import br.com.politicalpartysystem.modelo.enums.Sex;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
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
public class MemberPoliticalParty extends OwnerSystem implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private PoliticalParty politicalParty;

    @Size(max = 250)
    @NotBlank
    private String register;

    @NotNull
    private Sex sex;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date affiliationDate;

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public Date getAffiliationDate() {
        return affiliationDate;
    }

    public void setAffiliationDate(Date affiliationDate) {
        this.affiliationDate = affiliationDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public PoliticalParty getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(PoliticalParty politicalParty) {
        this.politicalParty = politicalParty;
    }

    @Override
    public String toString() {
        return register;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (getId() != null ? getId().hashCode() : 0);
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
        final MemberPoliticalParty other = (MemberPoliticalParty) obj;
        if (getId() != other.getId() && (getId() == null || !getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }
}
