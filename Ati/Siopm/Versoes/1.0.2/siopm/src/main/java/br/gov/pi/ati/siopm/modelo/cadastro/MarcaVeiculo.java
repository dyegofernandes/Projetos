/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class MarcaVeiculo implements Serializable {

    @Id
    @SequenceGenerator(name = "MarcaVeiculo", sequenceName = "marcaVeiculo_id_seq")
    @GeneratedValue(generator = "MarcaVeiculo")
    private Long id;

    @Size(max = 260)
    @NotBlank
    private String nome;
    
    @NotAudited
    @OneToMany(mappedBy = "marca")
    private List<ModeloVeiculo> modelos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ModeloVeiculo> getModelos() {
        return modelos;
    }

    public void setModelos(List<ModeloVeiculo> modelos) {
        this.modelos = modelos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final MarcaVeiculo other = (MarcaVeiculo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

}
