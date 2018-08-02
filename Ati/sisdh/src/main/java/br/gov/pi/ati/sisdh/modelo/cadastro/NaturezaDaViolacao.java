/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.cadastro;

import br.gov.pi.ati.sisdh.modelo.denuncia.Denuncia;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
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
public class NaturezaDaViolacao implements Serializable {

    @Id
    @SequenceGenerator(name = "NaturezaDaViolacao", sequenceName = "naturezaDaViolacao_id_seq")
    @GeneratedValue(generator = "NaturezaDaViolacao")
    private Long id;

    @Size(max = 50)
    @NotBlank
    private String nome;

    @NotAudited
    @OneToMany(mappedBy = "naturezaDaViolacao")
    private List<Denuncia> denuncias;

    @Override
    public String toString() {
        return nome;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final NaturezaDaViolacao other = (NaturezaDaViolacao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
