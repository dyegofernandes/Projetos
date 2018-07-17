/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.orcamento;

import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class DespesaPublica implements Serializable {

    @Id
    @SequenceGenerator(name = "DespesaPublica", sequenceName = "despesaPublica_id_seq")
    @GeneratedValue(generator = "DespesaPublica")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private UnidadeOrcamentaria unidadeOrcamentaria;

    @NotBlank
    @Size(max = 50)
    private String numeroProcesso; //AA.002.1.008295/17

    @NotBlank
    @Column(columnDefinition = "Text")
    private String descricaoDespesa;
    
    @NotBlank
    @Size(max = 100)
    private String resumoDaDespesa;
    
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataCadastro = new Date();

    @OneToMany(targetEntity = Dotacao.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "depesapublica_dotacao",
    joinColumns = { @JoinColumn(name = "despesapublica_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "dotacao_id") })
    private List<Dotacao> dotacao = new ArrayList<Dotacao>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UnidadeOrcamentaria getUnidadeOrcamentaria() {
        return unidadeOrcamentaria;
    }

    public void setUnidadeOrcamentaria(UnidadeOrcamentaria unidadeOrcamentaria) {
        this.unidadeOrcamentaria = unidadeOrcamentaria;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        if (numeroProcesso != null) {
            numeroProcesso = numeroProcesso.trim().toUpperCase();
        }
        this.numeroProcesso = numeroProcesso;
    }

    public String getDescricaoDespesa() {
        return descricaoDespesa;
    }

    public void setDescricaoDespesa(String descricaoDespesa) {
        this.descricaoDespesa = descricaoDespesa;
    }

    public List<Dotacao> getDotacao() {
        return dotacao;
    }

    public void setDotacao(List<Dotacao> dotacao) {
        this.dotacao = dotacao;
    }

    public String getResumoDaDespesa() {
        return resumoDaDespesa;
    }

    public void setResumoDaDespesa(String resumoDaDespesa) {
        this.resumoDaDespesa = resumoDaDespesa;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return numeroProcesso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final DespesaPublica other = (DespesaPublica) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
