/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.certificado;

import br.gov.pi.ati.sccd.modelo.cadastro.Arquivo;
import br.gov.pi.ati.sccd.modelo.cadastro.Fornecedor;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificadoAux;
import com.xpert.audit.NotAudited;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class ContratoFornecedor implements Serializable {

    @Id
    @SequenceGenerator(name = "ContratoFornecedor", sequenceName = "contratoFornecedor_id_seq")
    @GeneratedValue(generator = "ContratoFornecedor")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Fornecedor fornecedor;

    @Size(max = 250)
    @NotBlank
    private String numeroContrato;
    
    @Size(max = 250)
    @NotBlank
    private String representanteLegal;

    @Size(max = 50)
    @NotBlank
    private String cpfRepresentanteLegal;

    @Size(max = 250)
    @NotBlank
    private String representanteAti;

    @Size(max = 50)
    @NotBlank
    private String cpfRepresentanteAti;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataFinal;

    @ManyToMany(targetEntity = TipoCertificadoAux.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<TipoCertificadoAux> certificados = new ArrayList<TipoCertificadoAux>();
    
    private boolean ativo = true;
    
    @ManyToMany(targetEntity = Arquivo.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Arquivo> arquivos = new ArrayList<Arquivo>();
    
    @NotAudited
    @OneToMany(mappedBy = "contratoFornecedor")
    private List<ContratoCliente> contratos;

    @Override
    public String toString() {
        return numeroContrato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
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

    public List<TipoCertificadoAux> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<TipoCertificadoAux> certificados) {
        this.certificados = certificados;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getCpfRepresentanteLegal() {
        return cpfRepresentanteLegal;
    }

    public void setCpfRepresentanteLegal(String cpfRepresentanteLegal) {
        this.cpfRepresentanteLegal = cpfRepresentanteLegal;
    }

    public String getRepresentanteAti() {
        return representanteAti;
    }

    public void setRepresentanteAti(String representanteAti) {
        this.representanteAti = representanteAti;
    }

    public String getCpfRepresentanteAti() {
        return cpfRepresentanteAti;
    }

    public void setCpfRepresentanteAti(String cpfRepresentanteAti) {
        this.cpfRepresentanteAti = cpfRepresentanteAti;
    }

    public List<ContratoCliente> getContratos() {
        return contratos;
    }

    public void setContratos(List<ContratoCliente> contratos) {
        this.contratos = contratos;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ContratoFornecedor other = (ContratoFornecedor) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
