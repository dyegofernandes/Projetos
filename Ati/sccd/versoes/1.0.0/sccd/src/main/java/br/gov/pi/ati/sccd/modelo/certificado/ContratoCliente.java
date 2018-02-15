/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.certificado;

import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificadoAux;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class ContratoCliente implements Serializable {

    @Id
    @SequenceGenerator(name = "ContratoCliente", sequenceName = "contratoCliente_id_seq")
    @GeneratedValue(generator = "ContratoCliente")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private ContratoFornecedor contratoFornecedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cliente cliente;

    @Size(max = 250)
    @NotBlank
    private String numeroContrato;

    @Size(max = 250)
    @NotBlank
    private String representanteLegal;

    @Size(max = 50)
    private String cpfRepresentanteLegal;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataFinal;

    @ManyToMany(targetEntity = TipoCertificadoAux.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<TipoCertificadoAux> certificados = new ArrayList<TipoCertificadoAux>();

    private boolean ativo = true;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
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

    public ContratoFornecedor getContratoFornecedor() {
        return contratoFornecedor;
    }

    public void setContratoFornecedor(ContratoFornecedor contratoFornecedor) {
        this.contratoFornecedor = contratoFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ContratoCliente other = (ContratoCliente) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
