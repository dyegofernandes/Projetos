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
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class GrupoResultadoOcorrencia implements Serializable {

    @Id
    @SequenceGenerator(name = "GrupoResultadoOcorrencia", sequenceName = "grupoResultadoOcorrencia_id_seq")
    @GeneratedValue(generator = "GrupoResultadoOcorrencia")
    private Long id;

    @Size(max = 255)
    @NotBlank
    private String nome;
    
    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "grupo")
    private List<ResultadoOcorrencia> resultados;

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

    public List<ResultadoOcorrencia> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoOcorrencia> resultados) {
        this.resultados = resultados;
    }

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final GrupoResultadoOcorrencia other = (GrupoResultadoOcorrencia) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
