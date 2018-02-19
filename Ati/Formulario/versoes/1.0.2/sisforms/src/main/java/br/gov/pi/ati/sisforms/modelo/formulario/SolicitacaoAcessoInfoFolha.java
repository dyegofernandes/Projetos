/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

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
public class SolicitacaoAcessoInfoFolha implements Serializable {

    @Id
    @SequenceGenerator(name = "SolicitacaoAcessoInfoFolha", allocationSize = 1, sequenceName = "seq_solicitacaoAcessoInfoFolha")
    @GeneratedValue(generator = "SolicitacaoAcessoInfoFolha")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario usuario;

    @NotNull
    private TrabalhadorTipo tipo = TrabalhadorTipo.SERVIDOR;

    private String matricula;

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
    private Situacao situacao = Situacao.NOVA;

    @ManyToMany(targetEntity = PerfilInfoFolha.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<PerfilInfoFolha> perfilsSolicitados = new ArrayList<PerfilInfoFolha>();

    @ManyToMany(targetEntity = PerfilInfoFolha.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<PerfilInfoFolha> perfilsAprovados = new ArrayList<PerfilInfoFolha>();

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TrabalhadorTipo getTipo() {
        return tipo;
    }

    public void setTipo(TrabalhadorTipo tipo) {
        this.tipo = tipo;
    }

    public List<PerfilInfoFolha> getPerfilsSolicitados() {
        return perfilsSolicitados;
    }

    public void setPerfilsSolicitados(List<PerfilInfoFolha> perfilsSolicitados) {
        this.perfilsSolicitados = perfilsSolicitados;
    }

    public List<PerfilInfoFolha> getPerfilsAprovados() {
        return perfilsAprovados;
    }

    public void setPerfilsAprovados(List<PerfilInfoFolha> perfilsAprovados) {
        this.perfilsAprovados = perfilsAprovados;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final SolicitacaoAcessoInfoFolha other = (SolicitacaoAcessoInfoFolha) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
