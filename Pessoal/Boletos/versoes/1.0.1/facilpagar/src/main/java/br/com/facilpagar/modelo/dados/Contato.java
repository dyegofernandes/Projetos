/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facilpagar.modelo.dados;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "dados")
public class Contato implements Serializable {

    @Id
    @SequenceGenerator(schema ="dados",allocationSize = 1, name = "Contato", sequenceName = "dados.seq_contato_id")
    @GeneratedValue(generator = "Contato")
    private Long id;  
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Convenio convenio;
    
    @Size(max = 50)
    @NotBlank
    private String nome;
    
    @Size(max = 50)
    @Email
    private String email;
    
    @Size(max = 100)
    private String telefones;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt_nascimento = new Date();
    
    private boolean proprietario = false;
    
    private boolean financeiro = false;
    
    @Size(max = 50)
    private String conjuge;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt_anivconjuge = new Date();
    

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Contato other = (Contato) obj;
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

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public boolean isProprietario() {
        return proprietario;
    }

    public void setProprietario(boolean proprietario) {
        this.proprietario = proprietario;
    }

    public boolean isFinanceiro() {
        return financeiro;
    }

    public void setFinanceiro(boolean finaceiro) {
        this.financeiro = finaceiro;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    public Date getDt_anivconjuge() {
        return dt_anivconjuge;
    }

    public void setDt_anivconjuge(Date dt_anivconjuge) {
        this.dt_anivconjuge = dt_anivconjuge;
    }
    
    

    
}
