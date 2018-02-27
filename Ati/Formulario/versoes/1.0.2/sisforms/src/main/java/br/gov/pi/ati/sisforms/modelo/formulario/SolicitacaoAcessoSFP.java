/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import br.gov.pi.ati.sisforms.modelo.cadastro.TermoAceito;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.enums.Situacao;
import br.gov.pi.ati.sisforms.modelo.enums.TrabalhadorTipo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class SolicitacaoAcessoSFP implements Serializable {

    @Id
    @SequenceGenerator(name = "SolicitacaoAcessoSFP", allocationSize = 1, sequenceName = "seq_solicitacaoAcessoSFP")
    @GeneratedValue(generator = "SolicitacaoAcessoSFP")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario usuario;

    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private TrabalhadorTipo tipo = TrabalhadorTipo.SERVIDOR;

    @NotBlank
    private String telefone;

    private String cargoFuncao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissao = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtendimento;

    @ManyToMany(targetEntity = PerfilSFP.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<PerfilSFP> perfilsSolicitados = new ArrayList<PerfilSFP>();

    @Column(columnDefinition = "Text")
    private String observacao;

    @NotNull
    private Situacao situacao = Situacao.NOVA;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @NotNull
    private TermoAceito termoAceito;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargoFuncao() {
        return cargoFuncao;
    }

    public void setCargoFuncao(String cargoFuncao) {
        this.cargoFuncao = cargoFuncao;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public List<PerfilSFP> getPerfilsSolicitados() {
        return perfilsSolicitados;
    }

    public void setPerfilsSolicitados(List<PerfilSFP> perfilsSolicitados) {
        this.perfilsSolicitados = perfilsSolicitados;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public TermoAceito getTermoAceito() {
        return termoAceito;
    }

    public void setTermoAceito(TermoAceito termoAceito) {
        this.termoAceito = termoAceito;
    }

    public TrabalhadorTipo getTipo() {
        return tipo;
    }

    public void setTipo(TrabalhadorTipo tipo) {
        this.tipo = tipo;
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
        final SolicitacaoAcessoSFP other = (SolicitacaoAcessoSFP) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
