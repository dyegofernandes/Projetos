/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.politicalpartysystem.modelo.cadastro;

import br.com.politicalpartysystem.modelo.enums.TypeAddress;
import br.com.politicalpartysystem.modelo.enums.TypePublicpark;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "Address", sequenceName = "address_id_seq")
    @GeneratedValue(generator = "Address")
    private Long id;

    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private TypePublicpark typePublicpark;

    @Size(max = 250)
    @NotBlank
    private String publicPark;

    @Size(max = 50)
    private String number;

    @Size(max = 250)
    private String complement;

    @Size(max = 50)
    @NotBlank
    private String postalCode;

    @Size(max = 250)
    private String landmark;

    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private TypeAddress typeAddress;

    private boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Neighborhood neighborhood;

    @NotAudited
    @OneToMany(mappedBy = "address")
    private List<Person> persons;

    @Override
    public String toString() {
        return publicPark; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Address other = (Address) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicPark() {
        return publicPark;
    }

    public void setPublicPark(String publicPark) {
        this.publicPark = publicPark;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    public TypePublicpark getTypePublicpark() {
        return typePublicpark;
    }

    public void setTypePublicpark(TypePublicpark typePublicpark) {
        this.typePublicpark = typePublicpark;
    }

    public TypeAddress getTypeAddress() {
        return typeAddress;
    }

    public void setTypeAddress(TypeAddress typeAddress) {
        this.typeAddress = typeAddress;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

}
