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

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "cidade")
    private List<CarteiraTrabalho> carteira;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "cidade")
    private List<Endereco> enderecos;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "naturalidade")
    private List<Servidor> servidores;

    @NotAudited
    @OrderBy("nome")
    @OneToMany(mappedBy = "naturalidade")
    private List<CadastroPessoal> pessoals;

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
        if (nome != null) {
            nome = nome.trim().toUpperCase();
        }
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<CarteiraTrabalho> getCarteira() {
        return carteira;
    }

    public void setCarteira(List<CarteiraTrabalho> carteira) {
        this.carteira = carteira;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
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
