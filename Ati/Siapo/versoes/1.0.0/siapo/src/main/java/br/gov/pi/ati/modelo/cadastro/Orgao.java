/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro;

import br.gov.pi.ati.modelo.cadastro.enums.TipoDePoder;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Orgao implements Serializable {

    @Id
    @SequenceGenerator(name = "Orgao", sequenceName = "orgao_id_seq")
    @GeneratedValue(generator = "Orgao")
    private Long id;

    @Size(max = 50)
    @NotBlank
    private String codigo;

    @Size(max = 250)
    @NotBlank
    private String nome;

    @Size(max = 150)
    private String sigla;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoDePoder poder;

    @ManyToOne(fetch = FetchType.LAZY)
    private Orgao orgaoSuperior;

    private boolean ativo = true;

    @OneToMany(mappedBy = "orgaoSuperior")
    @NotAudited
    @OrderBy("nome")
    private List<Orgao> filhos;

    @OneToMany(mappedBy = "orgao")
    @NotAudited
    private List<UnidadeGestora> unidadesGestoras;

    @NotAudited
    @OneToMany(mappedBy = "orgao")
    private List<Produto> produtos;

    @NotAudited
    @OneToMany(mappedBy = "orgao")
    private List<AcaoEstrategica> acoes;

    @Override
    public String toString() {
        return codigo.concat(" - ").concat(nome);
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
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public TipoDePoder getPoder() {
        return poder;
    }

    public void setPoder(TipoDePoder poder) {
        this.poder = poder;
    }

    public Orgao getOrgaoSuperior() {
        return orgaoSuperior;
    }

    public void setOrgaoSuperior(Orgao orgaoSuperior) {
        this.orgaoSuperior = orgaoSuperior;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Orgao> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<Orgao> filhos) {
        this.filhos = filhos;
    }

    public List<UnidadeGestora> getUnidadesGestoras() {
        return unidadesGestoras;
    }

    public void setUnidadesGestoras(List<UnidadeGestora> unidadesGestoras) {
        this.unidadesGestoras = unidadesGestoras;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<AcaoEstrategica> getAcoes() {
        return acoes;
    }

    public void setAcoes(List<AcaoEstrategica> acoes) {
        this.acoes = acoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Orgao other = (Orgao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
