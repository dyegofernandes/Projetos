/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.servicos;

import br.gov.pi.ati.sisforms.modelo.cadastro.TermoAceito;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.enums.NomeSistema;
import br.gov.pi.ati.sisforms.modelo.enums.Situacao;
import br.gov.pi.ati.sisforms.modelo.enums.TrabalhadorTipo;
import br.gov.pi.ati.sisforms.modelo.formulario.PerfilInfoFolha;
import br.gov.pi.ati.sisforms.modelo.formulario.PerfilSFP;
import br.gov.pi.ati.sisforms.util.Utils;
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
public class SolicitacaoAcessoSistema implements Serializable {

    @Id
    @SequenceGenerator(name = "SolicitacaoAcessoSistema", allocationSize = 1, sequenceName = "seq_solicitacaoAcessoSistema")
    @GeneratedValue(generator = "SolicitacaoAcessoSistema")
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

    @Column(columnDefinition = "Text")
    private String observacao;

    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.NOVA;

    @NotNull
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private NomeSistema acessoAoSistema;

    @ManyToMany(targetEntity = PerfilInfoFolha.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<PerfilInfoFolha> perfilsInfofolha = new ArrayList<PerfilInfoFolha>();

    @ManyToMany(targetEntity = PerfilSFP.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<PerfilSFP> perfilsSFP = new ArrayList<PerfilSFP>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @NotNull
    private TermoAceito termoAceito;

    private String senha = Utils.gerarSenha(8);

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

    public TrabalhadorTipo getTipo() {
        return tipo;
    }

    public void setTipo(TrabalhadorTipo tipo) {
        this.tipo = tipo;
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

    public List<PerfilInfoFolha> getPerfilsInfofolha() {
        return perfilsInfofolha;
    }

    public void setPerfilsInfofolha(List<PerfilInfoFolha> perfilsInfofolha) {
        this.perfilsInfofolha = perfilsInfofolha;
    }

    public List<PerfilSFP> getPerfilsSFP() {
        return perfilsSFP;
    }

    public void setPerfilsSFP(List<PerfilSFP> perfilsSFP) {
        this.perfilsSFP = perfilsSFP;
    }

    public TermoAceito getTermoAceito() {
        return termoAceito;
    }

    public void setTermoAceito(TermoAceito termoAceito) {
        this.termoAceito = termoAceito;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public NomeSistema getAcessoAoSistema() {
        return acessoAoSistema;
    }

    public void setAcessoAoSistema(NomeSistema acessoAoSistema) {
        this.acessoAoSistema = acessoAoSistema;
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
        final SolicitacaoAcessoSistema other = (SolicitacaoAcessoSistema) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
