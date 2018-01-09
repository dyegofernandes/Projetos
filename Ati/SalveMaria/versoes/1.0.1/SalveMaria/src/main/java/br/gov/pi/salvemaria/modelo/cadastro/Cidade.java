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
public class Cidade implements Serializable {

    @Id
    @SequenceGenerator(name = "Cidade", sequenceName = "seq_cidade")
    @GeneratedValue(generator = "Cidade")
    private Long id;

    @Size(max = 50)
    @NotBlank(message = "O nome da Cidade é Obrigatório!")
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Estado estado;
    
    @ManyToOne(fetch = FetchType.LAZY)
//    @NotNull
    private Circunscricao circunscricao;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "cidade")
    private List<Bairro> bairros;
    
    @NotAudited
    @OneToMany(mappedBy = "baseMunicipal")
    private List<Circunscricao> circus_cidades;
    
    @NotAudited
    @OneToMany(mappedBy = "cidade")
    private List<Circunscricao_Bairro> circus_bairros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Bairro> getBairros() {
        return bairros;
    }

    public void setBairros(List<Bairro> bairros) {
        this.bairros = bairros;
    }

    public String getNome() {
//        if (nome != null) {
//            nome = nome.trim().toUpperCase();
//        }
        return nome;
    }

    public void setNome(String nome) {
//        if (nome != null) {
//            nome = nome.trim().toUpperCase();
//        }
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Circunscricao> getCircus_cidades() {
        return circus_cidades;
    }

    public void setCircus_cidades(List<Circunscricao> circus_cidades) {
        this.circus_cidades = circus_cidades;
    }

    public List<Circunscricao_Bairro> getCircus_bairros() {
        return circus_bairros;
    }

    public void setCircus_bairros(List<Circunscricao_Bairro> circus_bairros) {
        this.circus_bairros = circus_bairros;
    }

    public Circunscricao getCircunscricao() {
        return circunscricao;
    }

    public void setCircunscricao(Circunscricao circunscricao) {
        this.circunscricao = circunscricao;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Cidade other = (Cidade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
