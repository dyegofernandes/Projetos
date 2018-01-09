/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.adapi.modelo.notificacao;

import br.gov.pi.ati.adapi.modelo.cadastro.Animal;
import br.gov.pi.ati.adapi.modelo.cadastro.Arquivo;
import br.gov.pi.ati.adapi.modelo.cadastro.Endereco;
import br.gov.pi.ati.adapi.modelo.cadastro.ResponsavelNotificacao;
import br.gov.pi.ati.adapi.modelo.cadastro.SinalClinico;
import br.gov.pi.ati.adapi.modelo.enums.AreaDeAtuacao;
import br.gov.pi.ati.adapi.modelo.enums.SimOuNao;
import br.gov.pi.ati.adapi.modelo.enums.TipoProfissional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Notificacao implements Serializable {

    @Id
    @SequenceGenerator(name = "Notificacao", sequenceName = "notificacao_id_seq")
    @GeneratedValue(generator = "Notificacao")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SimOuNao anonimo = SimOuNao.SIM;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private ResponsavelNotificacao responsavelNotificacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Animal animal;

    @Size(max = 260)
    @NotBlank
    private String nomeEstabelecimento;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @NotNull
    private Endereco endereco = new Endereco();

    @Column(columnDefinition = "Text")
    private String observacao;

    @ManyToMany(targetEntity = SinalClinico.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<SinalClinico> sinaisClinicos = new ArrayList<SinalClinico>();

    @ManyToMany(targetEntity = Arquivo.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Arquivo> arquivos = new ArrayList<Arquivo>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SimOuNao getAnonimo() {
        return anonimo;
    }

    public void setAnonimo(SimOuNao anonimo) {
        this.anonimo = anonimo;
    }

    public ResponsavelNotificacao getResponsavelNotificacao() {
        return responsavelNotificacao;
    }

    public void setResponsavelNotificacao(ResponsavelNotificacao responsavelNotificacao) {
        this.responsavelNotificacao = responsavelNotificacao;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<SinalClinico> getSinaisClinicos() {
        return sinaisClinicos;
    }

    public void setSinaisClinicos(List<SinalClinico> sinaisClinicos) {
        this.sinaisClinicos = sinaisClinicos;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Notificacao other = (Notificacao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
