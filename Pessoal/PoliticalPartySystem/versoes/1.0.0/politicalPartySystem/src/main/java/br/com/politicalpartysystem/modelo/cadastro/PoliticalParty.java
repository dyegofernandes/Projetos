/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.politicalpartysystem.modelo.cadastro;

import br.com.politicalpartysystem.modelo.enums.TypePoliticalParty;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class PoliticalParty extends OwnerSystem implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    private PoliticalParty politicalParty;

    @Size(max = 50)
//    @NotBlank
    private String code;

    @NotNull
    private TypePoliticalParty type;

    @NotAudited
    @OneToMany(mappedBy = "politicalParty")
    private List<PoliticalParty> politicalParties;

    @NotAudited
    @OneToMany(mappedBy = "politicalParty")
    private List<MemberPoliticalParty> membros;

    @NotAudited
    @OneToMany(mappedBy = "politicalParty")
    private List<UserPoliticalParty> users;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PoliticalParty getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(PoliticalParty politicalParty) {
        this.politicalParty = politicalParty;
    }

    public List<PoliticalParty> getPoliticalParties() {
        return politicalParties;
    }

    public void setPoliticalParties(List<PoliticalParty> politicalParties) {
        this.politicalParties = politicalParties;
    }

    public TypePoliticalParty getType() {
        return type;
    }

    public void setType(TypePoliticalParty type) {
        this.type = type;
    }

    public List<MemberPoliticalParty> getMembros() {
        return membros;
    }

    public void setMembros(List<MemberPoliticalParty> membros) {
        this.membros = membros;
    }

    public List<UserPoliticalParty> getUsers() {
        return users;
    }

    public void setUsers(List<UserPoliticalParty> users) {
        this.users = users;
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
        final PoliticalParty other = (PoliticalParty) obj;
        if (getId() != other.getId() && (getId() == null || !getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

}
