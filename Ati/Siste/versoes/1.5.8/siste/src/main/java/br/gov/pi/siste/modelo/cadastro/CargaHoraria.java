/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.cadastro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class CargaHoraria implements Serializable {

    @Id
    @SequenceGenerator(name = "CargaHoraria", sequenceName = "seq_cargaHoraria")
    @GeneratedValue(generator = "CargaHoraria")
    private Long id;

    @Size(max = 260)
    @NotBlank
    private String descricao;
    
    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "cargaHoraria")
    private List<DadosFuncionais> dadosFuncionais;

    @Override
    public String toString() {
        return descricao; 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao != null) {
            descricao = descricao.trim().toUpperCase();
        }
        this.descricao = descricao;
    }

    public List<DadosFuncionais> getDadosFuncionais() {
        return dadosFuncionais;
    }

    public void setDadosFuncionais(List<DadosFuncionais> dadosFuncionais) {
        this.dadosFuncionais = dadosFuncionais;
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
        final CargaHoraria other = (CargaHoraria) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
    
}
