/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.weblicita.modelo.licitacao;

import br.com.weblicita.modelo.cadastro.Documento;
import br.com.weblicita.modelo.cadastro.Fornecedor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Juniel
 */
@Entity
public class Proponente implements Serializable {

    @Id
    @SequenceGenerator(name = "Proponente", allocationSize = 1, sequenceName = "proponente_id_seq")
    @GeneratedValue(generator = "Proponente")
    private Long id;

//    @NotNull
    @Temporal(TemporalType.DATE)
    private Date anexada = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    private Fornecedor fornecedor;

    @ManyToMany(targetEntity = Documento.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Documento> documentos = new ArrayList<Documento>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAnexada() {
        return anexada;
    }

    public void setAnexada(Date anexada) {
        this.anexada = anexada;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Proponente other = (Proponente) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
