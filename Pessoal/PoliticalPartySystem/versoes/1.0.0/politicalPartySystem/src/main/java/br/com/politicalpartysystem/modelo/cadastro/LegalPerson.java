/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.politicalpartysystem.modelo.cadastro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class LegalPerson extends Person implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    private LegalPerson subsidiary;

    @Size(max = 250)
    @NotBlank
    private String corporateName;

    @Size(max = 250)
    @NotBlank
    private String fancyName;

    @Size(max = 20)
    @NotBlank
    private String cnpj;

    @Size(max = 20)
    private String stateRegistration;

    @NotAudited
    @OrderBy("corporateName")
    @OneToMany(mappedBy = "subsidiary")
    private List<LegalPerson> legalPersons;
    private static final Logger LOG = Logger.getLogger(LegalPerson.class.getName());

    @Override
    public String toString() {
        return corporateName; //To change body of generated methods, choose Tools | Templates.
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
        final LegalPerson other = (LegalPerson) obj;
        if (getId() != other.getId() && (getId() == null || !getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    public LegalPerson getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(LegalPerson subsidiary) {
        this.subsidiary = subsidiary;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getFancyName() {
        return fancyName;
    }

    public void setFancyName(String fancyName) {
        this.fancyName = fancyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public List<LegalPerson> getLegalPersons() {
        return legalPersons;
    }

    public void setLegalPersons(List<LegalPerson> legalPersons) {
        this.legalPersons = legalPersons;
    }

}
