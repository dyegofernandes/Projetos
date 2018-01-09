/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dota2.modelo.cadastro;

import br.com.dota2.modelo.enums.AttackType;
import br.com.dota2.modelo.enums.PrimaryAttribute;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author KillerBee Reborn
 */
@Entity
public class Hero implements Serializable {

    @Id
    @SequenceGenerator(name = "Hero", allocationSize = 1, sequenceName = "seq_hero")
    @GeneratedValue(generator = "Hero")
    private Long id; // 1

    @NotBlank
    @Size(max = 200)
    private String name; // npc_dota_hero_antimage

    @NotBlank
    @Size(max = 200)
    private String localizedName; // Anti-Mage

    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private PrimaryAttribute primaryAttribute; //Agi

    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private AttackType attackType; //Meele

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Role> roles = new ArrayList<Role>();// Carry,Escape,Nuker

    @NotNull
    private Integer legs; // 2

    @Override
    public String toString() {
        return localizedName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public PrimaryAttribute getPrimaryAttribute() {
        return primaryAttribute;
    }

    public void setPrimaryAttribute(PrimaryAttribute primaryAttribute) {
        this.primaryAttribute = primaryAttribute;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getLegs() {
        return legs;
    }

    public void setLegs(Integer legs) {
        this.legs = legs;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Hero other = (Hero) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
