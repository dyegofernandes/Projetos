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

/**
 *
 * @author Juniel
 */
@Entity
public class DrogaOcorrencia implements Serializable {

    @Id
    @SequenceGenerator(name = "DrogaOcorrencia", sequenceName = "drogaOcorrencia_id_seq")
    @GeneratedValue(generator = "DrogaOcorrencia")
    private Long id;

    private String nome;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "droga")
    private List<DrogaOcorrenciaItem> itensDroga;

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

    public List<DrogaOcorrenciaItem> getItensDroga() {
        return itensDroga;
    }

    public void setItensDroga(List<DrogaOcorrenciaItem> itensDroga) {
        this.itensDroga = itensDroga;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final DrogaOcorrencia other = (DrogaOcorrencia) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
