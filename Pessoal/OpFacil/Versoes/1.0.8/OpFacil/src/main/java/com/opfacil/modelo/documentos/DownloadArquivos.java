/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.modelo.documentos;

import com.opfacil.modelo.cadastro.Empresa;
import com.opfacil.modelo.enums.TipoArquivo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class DownloadArquivos implements Serializable {

    @Id
    @SequenceGenerator(name = "DownloadArquivos", allocationSize = 1, sequenceName = "downloadarquivos_id_seq")
    @GeneratedValue(generator = "DownloadArquivos")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa empresa;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataPublicao;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Arquivo arquivo;

    private TipoArquivo tipo = TipoArquivo.GERADA;

    private Integer cdOp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Date getDataPublicao() {
        return dataPublicao;
    }

    public void setDataPublicao(Date dataPublicao) {
        this.dataPublicao = dataPublicao;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public TipoArquivo getTipo() {
        return tipo;
    }

    public void setTipo(TipoArquivo tipo) {
        this.tipo = tipo;
    }

    public Integer getCdOp() {
        return cdOp;
    }

    public void setCdOp(Integer cdOp) {
        this.cdOp = cdOp;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final DownloadArquivos other = (DownloadArquivos) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
