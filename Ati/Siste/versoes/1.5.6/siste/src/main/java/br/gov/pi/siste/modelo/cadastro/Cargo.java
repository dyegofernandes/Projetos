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
public class Cargo implements Serializable {

    @Id
    @SequenceGenerator(name = "Cargo", sequenceName = "seq_cargo")
    @GeneratedValue(generator = "Cargo")
    private Long id;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Orgao orgao;
    
    @Size(max = 60)
    @NotBlank
    private String codigo;
    
    @Size(max = 260)
    @NotBlank
    private String nome;
    
    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "cargo")
    private List<DadosFuncionais> dadosFuncionais;

    @Override
    public String toString() {
        return nome;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
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

    public List<DadosFuncionais> getDadosFuncionais() {
        return dadosFuncionais;
    }

    public void setDadosFuncionais(List<DadosFuncionais> dadosFuncionais) {
        this.dadosFuncionais = dadosFuncionais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Cargo other = (Cargo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
    
}
