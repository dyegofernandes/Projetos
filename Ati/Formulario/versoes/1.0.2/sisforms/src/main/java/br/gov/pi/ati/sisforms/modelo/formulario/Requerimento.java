/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.enums.AssuntoRequerimento;
import br.gov.pi.ati.sisforms.modelo.enums.Situacao;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Juniel
 */
@Entity
public class Requerimento implements Serializable {

    @Id
    @SequenceGenerator(name = "Requerimento", sequenceName = "seq_requerimento")
    @GeneratedValue(generator = "Requerimento")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario usuario;

    @Size(max = 250)
    @NotBlank(message = "Destinatário é Obrigatório!")
    private String destinatario;

    @Size(max = 250)
    @NotBlank
    private String requerente;

    private String matricula;

    @CPF
    @Size(max = 50)
    @NotBlank
    private String cpf;

    @Size(max = 50)
    @NotBlank
    private String telefone;

    @Size(max = 100)
    @NotBlank
    private String cargo;

    @Size(max = 100)
    @NotBlank
    private String area;

    @Size(max = 600)
    private String solicitacao;

    @NotNull
    private AssuntoRequerimento assuntoRequerimento;

    @NotNull
    private Situacao situacao = Situacao.NOVA;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSolicitacao = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtendimento;

    @Size(max = 600)
    private String observacaoAtendimento;
    
    private String crm;
    
    private String nomeDoMedico;
    
    private String cid;

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

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRequerente() {
        return requerente;
    }

    public void setRequerente(String requerente) {
        this.requerente = requerente;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(String solicitacao) {
        this.solicitacao = solicitacao;
    }

    public AssuntoRequerimento getAssuntoRequerimento() {
        return assuntoRequerimento;
    }

    public void setAssuntoRequerimento(AssuntoRequerimento assuntoRequerimento) {
        this.assuntoRequerimento = assuntoRequerimento;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getObservacaoAtendimento() {
        return observacaoAtendimento;
    }

    public void setObservacaoAtendimento(String observacaoAtendimento) {
        this.observacaoAtendimento = observacaoAtendimento;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNomeDoMedico() {
        return nomeDoMedico;
    }

    public void setNomeDoMedico(String nomeDoMedico) {
        this.nomeDoMedico = nomeDoMedico;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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
        final Requerimento other = (Requerimento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
