/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.enums.Situacao;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class FormAcessoConteudo implements Serializable {

    @Id
    @SequenceGenerator(name = "FormAcessoConteudo", sequenceName = "seq_formAcessoConteudo")
    @GeneratedValue(generator = "FormAcessoConteudo")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Orgao orgao;

    @Size(max = 255)
    @NotBlank
    private String nomeCompleto;

    @Size(max = 255)
    private String cargo;

    @Size(max = 50)
    private String matriculaEstado;

    @Size(max = 50)
    private String telefone;

    @Size(max = 255)
    @Email
    private String emailCoorporativo;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao = new Date();

    @NotNull
    private Situacao situacao = Situacao.NOVA;

    @NotAudited
    @OneToMany(mappedBy = "formAcessoConteudo")
    private List<ItemFormAcessoConteudo> formsCriacaoEmail;

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public List<ItemFormAcessoConteudo> getFormsCriacaoEmail() {
        return formsCriacaoEmail;
    }

    public void setFormsCriacaoEmail(List<ItemFormAcessoConteudo> formsCriacaoEmail) {
        this.formsCriacaoEmail = formsCriacaoEmail;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getMatriculaEstado() {
        return matriculaEstado;
    }

    public void setMatriculaEstado(String matriculaEstado) {
        this.matriculaEstado = matriculaEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmailCoorporativo() {
        return emailCoorporativo;
    }

    public void setEmailCoorporativo(String emailCoorporativo) {
        this.emailCoorporativo = emailCoorporativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final FormAcessoConteudo other = (FormAcessoConteudo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
