/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Organizacao implements Serializable {

    @Id
    @SequenceGenerator(name = "Organizacao", sequenceName = "organizacao_id_seq")
    @GeneratedValue(generator = "Organizacao")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Organizacao organizacaoPai;

    private Integer codigo;

    @Size(max = 250)
    @NotBlank
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @NotNull
    private Endereco endereco = new Endereco();

    @Size(max = 50)
    @NotBlank
    private String sigla;

    /**
     * iniciar com valor padrao 0
     */
    private Integer ordenacao = 0;

    private boolean ativo = true;

    @OrderBy(value = "nome")
    @OneToMany(mappedBy = "organizacaoPai")
    private List<Organizacao> filhos = new ArrayList<Organizacao>();

    @ManyToMany(targetEntity = Territorio.class, fetch = FetchType.LAZY)
    @OrderBy(value = "nome")
    private List<Territorio> territorios = new ArrayList<Territorio>();

    @ManyToMany(targetEntity = Telefone.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Telefone> telefones = new ArrayList<Telefone>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organizacao getOrganizacaoPai() {
        return organizacaoPai;
    }

    public void setOrganizacaoPai(Organizacao organizacaoPai) {
        this.organizacaoPai = organizacaoPai;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getOrdenacao() {
        return ordenacao;
    }

    public void setOrdenacao(Integer ordenacao) {
        this.ordenacao = ordenacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Organizacao> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<Organizacao> filhos) {
        this.filhos = filhos;
    }

    public List<Territorio> getTerritorios() {
        return territorios;
    }

    public void setTerritorios(List<Territorio> territorios) {
        this.territorios = territorios;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Organizacao other = (Organizacao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
