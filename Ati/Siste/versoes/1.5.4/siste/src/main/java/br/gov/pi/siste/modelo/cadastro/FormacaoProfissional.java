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
public class FormacaoProfissional implements Serializable {

    @Id
    @SequenceGenerator(name = "FormacaoProfissional", sequenceName = "seq_formacaoprofissional")
    @GeneratedValue(generator = "FormacaoProfissional")
    private Long id;

    @Size(max = 60)
    private String codigo;

    @Size(max = 260)
    @NotBlank
    private String nome;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "formacaoProfissional")
    private List<Servidor> servidores;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "formacaoProfissional")
    private List<CadastroPessoal> pessoals;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null) {
            nome = nome.trim().toUpperCase();
        }
        this.nome = nome;
    }

    public List<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }

    public List<CadastroPessoal> getPessoals() {
        return pessoals;
    }

    public void setPessoals(List<CadastroPessoal> pessoals) {
        this.pessoals = pessoals;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final FormacaoProfissional other = (FormacaoProfissional) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
