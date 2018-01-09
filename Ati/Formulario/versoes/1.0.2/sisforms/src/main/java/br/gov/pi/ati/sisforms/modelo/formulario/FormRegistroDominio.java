/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import br.gov.pi.ati.sisforms.modelo.enums.Situacao;
import br.gov.pi.ati.sisforms.modelo.enums.StatusDominio;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author Juniel
 */
@Entity
public class FormRegistroDominio implements Serializable {

    @Id
    @SequenceGenerator(name = "FormRegistroDominio", sequenceName = "seq_formRegistroDominio")
    @GeneratedValue(generator = "FormRegistroDominio")
    private Long id;

    @Size(max = 255)
    @NotBlank
    private String entidade;

    @Size(max = 20)
    @NotBlank
    @CNPJ
    private String cnpj;

    @Size(max = 255)
    private String enderecoEntidade;

    @Size(max = 255)
    private String responsavelLegal;

    @Size(max = 20)
    private String cpfRespLegal;

    @Size(max = 50)
    private String rgRespLegal;

    @Size(max = 50)
    private String telefonesRespLegal;

    @Size(max = 50)
    private String emailRespLegal;

    @Size(max = 50)
    private String cargoRespLegal;

    @Size(max = 255)
    private String responsavelTecnico;

    @Size(max = 20)
    private String cpfRespTecnico;

    @Size(max = 20)
    private String cargoRespTecnico;

    @Size(max = 50)
    private String rgRespTecnico;

    @Size(max = 50)
    private String telefonesRespTecnico;

    @Size(max = 50)
    private String emailRespTecnico;

    @Size(max = 100)
    private String dominio;

    @Size(max = 100)
    private String servidorDNS1;

    @Size(max = 100)
    private String servidorDNS2;

    @Size(max = 100)
    private String servidorDNS3;

    @Size(max = 100)
    private String servidorDNS4;

    @NotNull
    private StatusDominio status = StatusDominio.NAO_ASSINADO;

    private String numeroContrato;

    @NotNull
    private Situacao situacao = Situacao.NOVA;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao = new Date();

    @Override
    public String toString() {
        return entidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEnderecoEntidade() {
        return enderecoEntidade;
    }

    public void setEnderecoEntidade(String enderecoEntidade) {
        this.enderecoEntidade = enderecoEntidade;
    }

    public String getResponsavelLegal() {
        return responsavelLegal;
    }

    public void setResponsavelLegal(String responsavelLegal) {
        this.responsavelLegal = responsavelLegal;
    }

    public String getCpfRespLegal() {
        return cpfRespLegal;
    }

    public void setCpfRespLegal(String cpfRespLegal) {
        this.cpfRespLegal = cpfRespLegal;
    }

    public String getRgRespLegal() {
        return rgRespLegal;
    }

    public void setRgRespLegal(String rgRespLegal) {
        this.rgRespLegal = rgRespLegal;
    }

    public String getTelefonesRespLegal() {
        return telefonesRespLegal;
    }

    public void setTelefonesRespLegal(String telefonesRespLegal) {
        this.telefonesRespLegal = telefonesRespLegal;
    }

    public String getEmailRespLegal() {
        return emailRespLegal;
    }

    public void setEmailRespLegal(String emailRespLegal) {
        this.emailRespLegal = emailRespLegal;
    }

    public String getResponsavelTecnico() {
        return responsavelTecnico;
    }

    public void setResponsavelTecnico(String responsavelTecnico) {
        this.responsavelTecnico = responsavelTecnico;
    }

    public String getCpfRespTecnico() {
        return cpfRespTecnico;
    }

    public void setCpfRespTecnico(String cpfRespTecnico) {
        this.cpfRespTecnico = cpfRespTecnico;
    }

    public String getRgRespTecnico() {
        return rgRespTecnico;
    }

    public void setRgRespTecnico(String rgRespTecnico) {
        this.rgRespTecnico = rgRespTecnico;
    }

    public String getTelefonesRespTecnico() {
        return telefonesRespTecnico;
    }

    public void setTelefonesRespTecnico(String telefonesRespTecnico) {
        this.telefonesRespTecnico = telefonesRespTecnico;
    }

    public String getEmailRespTecnico() {
        return emailRespTecnico;
    }

    public void setEmailRespTecnico(String emailRespTecnico) {
        this.emailRespTecnico = emailRespTecnico;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getServidorDNS1() {
        return servidorDNS1;
    }

    public void setServidorDNS1(String servidorDNS1) {
        this.servidorDNS1 = servidorDNS1;
    }

    public String getServidorDNS2() {
        return servidorDNS2;
    }

    public void setServidorDNS2(String servidorDNS2) {
        this.servidorDNS2 = servidorDNS2;
    }

    public String getServidorDNS3() {
        return servidorDNS3;
    }

    public void setServidorDNS3(String servidorDNS3) {
        this.servidorDNS3 = servidorDNS3;
    }

    public String getServidorDNS4() {
        return servidorDNS4;
    }

    public void setServidorDNS4(String servidorDNS4) {
        this.servidorDNS4 = servidorDNS4;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCargoRespLegal() {
        return cargoRespLegal;
    }

    public void setCargoRespLegal(String cargoRespLegal) {
        this.cargoRespLegal = cargoRespLegal;
    }

    public String getCargoRespTecnico() {
        return cargoRespTecnico;
    }

    public void setCargoRespTecnico(String cargoRespTecnico) {
        this.cargoRespTecnico = cargoRespTecnico;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public StatusDominio getStatus() {
        return status;
    }

    public void setStatus(StatusDominio status) {
        this.status = status;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final FormRegistroDominio other = (FormRegistroDominio) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
