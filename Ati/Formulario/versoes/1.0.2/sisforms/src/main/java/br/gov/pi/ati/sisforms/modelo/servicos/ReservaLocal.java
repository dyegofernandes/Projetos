/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.servicos;

import br.gov.pi.ati.sisforms.modelo.cadastro.Arquivo;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
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
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel, Nilson, Samuel, Yago
 */
@Entity
public class ReservaLocal implements Serializable {

    @Id
    @SequenceGenerator(name = "ReservaLocal", sequenceName = "seq_reservaLocal")
    @GeneratedValue(generator = "ReservaLocal")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private LocalReserva local;
    
    @Size(max = 200)
    @NotBlank
    private String titulo;

    @Size(max = 255)
    @NotBlank
    private String solicitante;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataFinal;

    @Column(columnDefinition = "Text")
    private String observacao;
    
    @ManyToMany(targetEntity = Arquivo.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Arquivo> arquivos = new ArrayList<Arquivo>();
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Orgao orgao;
    
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Orgao orgaoSolicitante;

    @Size(max = 200)
    @NotBlank
    private String contato;
    
    @Size(max = 20)
    @NotNull
    private String fone_contato;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario usuario;
    
    @Size(max = 10)
    @NotBlank
    private String numero_protocolo;
    
    @Size(max = 8)
    @NotBlank
    private String numero_oficio;
    
    @Override
    public String toString() {
        return titulo + " - " + local;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalReserva getLocal() {
        return local;
    }

    public void setLocal(LocalReserva local) {
        this.local = local;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Orgao getOrgaoSolicitante() {
        return orgaoSolicitante;
    }

    public void setOrgaoSolicitante(Orgao orgaoSolicitante) {
        this.orgaoSolicitante = orgaoSolicitante;
    }

    public String getFone_contato() {
        return fone_contato;
    }

    public void setFone_contato(String fone_contato) {
        this.fone_contato = fone_contato;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNumero_protocolo() {
        return numero_protocolo;
    }

    public void setNumero_protocolo(String numero_protocolo) {
        this.numero_protocolo = numero_protocolo;
    }

    public String getNumero_oficio() {
        return numero_oficio;
    }

    public void setNumero_oficio(String numero_oficio) {
        this.numero_oficio = numero_oficio;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReservaLocal other = (ReservaLocal) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
