/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.cadastro;

import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Bairro implements Serializable , Comparable<Bairro>{

    @Id
    @SequenceGenerator(name = "Bairro", sequenceName = "seq_bairro")
    @GeneratedValue(generator = "Bairro")
    private Long id;

    @Size(max = 50)
    @NotBlank
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cidade cidade;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Circunscricao_Bairro circunscricao_Bairro;
    private boolean principal = false;

    @ManyToMany(targetEntity = CircunscricaoBairro.class, mappedBy = "bairros")
    private List<CircunscricaoBairro> circunscricoes;

    @NotAudited
    @OneToMany(mappedBy = "bairro")
    private List<Endereco> enderecos;

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
//        if (nome != null) {
//            nome = nome.trim().toUpperCase();
//        }
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public List<CircunscricaoBairro> getCircunscricoes() {
        return circunscricoes;
    }

    public void setCircunscricoes(List<CircunscricaoBairro> circunscricoes) {
        this.circunscricoes = circunscricoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Bairro other = (Bairro) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public int compareTo(Bairro o) {
        return this.nome.compareTo(o.nome);
    }

}
