/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.cadastro;

import br.gov.pi.ati.modelo.orcamento.DespesaPublica;
import br.gov.pi.ati.modelo.orcamento.Dotacao;
import br.gov.pi.ati.modelo.orcamento.ProgramacaoFinanceira;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
public class AcaoOrcamentaria implements Serializable {

    @Id
    @SequenceGenerator(name = "AcaoOrcamentaria", sequenceName = "acaoOrcamentaria_id_seq")
    @GeneratedValue(generator = "AcaoOrcamentaria")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private UnidadeOrcamentaria unidadeOrcamentaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Funcao funcao;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private SubFuncao subfuncao;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private ProgramaPPA programa;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private AcaoEstrategica acaoEstrategica;

    @Size(max = 50)
    @NotBlank
    private String codigo;

    @Size(max = 250)
    @NotBlank
    private String nome;

    private boolean ativo = true;
    
    @OneToMany(mappedBy = "acaoOrcamentaria")
    @NotAudited
    private List<Dotacao> dotacoes;
    
    @ManyToMany(targetEntity = FonteDeRecurso.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<FonteDeRecurso> fontesDeRecurso = new ArrayList<FonteDeRecurso>();

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

    public UnidadeOrcamentaria getUnidadeOrcamentaria() {
        return unidadeOrcamentaria;
    }

    public void setUnidadeOrcamentaria(UnidadeOrcamentaria unidadeOrcamentaria) {
        this.unidadeOrcamentaria = unidadeOrcamentaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public SubFuncao getSubfuncao() {
        return subfuncao;
    }

    public void setSubfuncao(SubFuncao subfuncao) {
        this.subfuncao = subfuncao;
    }

    public ProgramaPPA getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaPPA programa) {
        this.programa = programa;
    }

    public AcaoEstrategica getAcaoEstrategica() {
        return acaoEstrategica;
    }

    public void setAcaoEstrategica(AcaoEstrategica acaoEstrategica) {
        this.acaoEstrategica = acaoEstrategica;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Dotacao> getDotacoes() {
        return dotacoes;
    }

    public void setDotacoes(List<Dotacao> dotacoes) {
        this.dotacoes = dotacoes;
    }

    public List<FonteDeRecurso> getFontesDeRecurso() {
        return fontesDeRecurso;
    }

    public void setFontesDeRecurso(List<FonteDeRecurso> fontesDeRecurso) {
        this.fontesDeRecurso = fontesDeRecurso;
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
        final AcaoOrcamentaria other = (AcaoOrcamentaria) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
