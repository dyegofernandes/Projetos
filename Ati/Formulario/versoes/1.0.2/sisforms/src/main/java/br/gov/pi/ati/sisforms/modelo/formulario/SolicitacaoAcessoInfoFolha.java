/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
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
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Orgao orgao;

    @NotBlank
    @Size(max = 20)
    private String cpf;

    @NotNull
    private TrabalhadorTipo tipo = TrabalhadorTipo.SERVIDOR;

    private String matricula;

    private String telefone;

    @NotBlank
    @Size(max = 150)
    private String nome;

    private String cargoFuncao;

    @NotBlank
    @Size(max = 150)
    @Email
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissao = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtendimento;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @NotNull
    private ModuloInfoFolha modulo = new ModuloInfoFolha();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @NotNull
    private ModuloInfoFolha moduloSead = new ModuloInfoFolha();

    @Column(columnDefinition = "Text")
    private String observacao;

    @NotNull
    private Situacao situacao = Situacao.NOVA;

    @ManyToMany(targetEntity = Orgao.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Orgao> orgaosDeAcessos = new ArrayList<Orgao>();

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

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargoFuncao() {
        return cargoFuncao;
    }

    public void setCargoFuncao(String cargoFuncao) {
        this.cargoFuncao = cargoFuncao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public ModuloInfoFolha getModulo() {
        return modulo;
    }

    public void setModulo(ModuloInfoFolha modulo) {
        this.modulo = modulo;
    }

    public ModuloInfoFolha getModuloSead() {
        return moduloSead;
    }

    public void setModuloSead(ModuloInfoFolha moduloSead) {
        this.moduloSead = moduloSead;
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

    public List<Orgao> getOrgaosDeAcessos() {
        return orgaosDeAcessos;
    }

    public void setOrgaosDeAcessos(List<Orgao> orgaosDeAcessos) {
        this.orgaosDeAcessos = orgaosDeAcessos;
    }

    public TrabalhadorTipo getTipo() {
        return tipo;
    }

    public void setTipo(TrabalhadorTipo tipo) {
        this.tipo = tipo;
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
