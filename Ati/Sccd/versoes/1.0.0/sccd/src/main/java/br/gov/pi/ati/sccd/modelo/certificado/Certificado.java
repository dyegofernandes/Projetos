/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.certificado;

import br.gov.pi.ati.sccd.modelo.cadastro.AutoridadeCertificadora;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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

/**
 *
 * @author Juniel
 */
@Entity
public class Certificado implements Serializable {

    @Id
    @SequenceGenerator(name = "Certificado", sequenceName = "certificado_id_seq")
    @GeneratedValue(generator = "Certificado")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private ContratoCliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private ItemPedido titular;

    @Size(max = 250)
    @NotBlank
    private String numeroSolicitacao;

    @Size(max = 250)
    private String cpfRepresentanteLegal;

    @Size(max = 250)
    private String nomeRepresentanteLegal;

    @Size(max = 250)
    private String cpfResponsavelLegal;

    @Size(max = 250)
    private String nomeResponsavelLegal;

    @Size(max = 250)
    private String enderecoEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    private AutoridadeCertificadora autoridadeCertificadora;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataAprovacao;

    @Size(max = 255)
    private String documento;

    @NotNull
    private Integer armario;

    @NotNull
    private Integer caixa;

    @NotNull
    private Integer sequencial;

    private String baixa;

    @Size(max = 255)
    private String documentoRevogacao;

    @Temporal(TemporalType.DATE)
    private Date dataRevogacao;

    @Column(columnDefinition = "Text")
    private String observacao;

    @Override
    public String toString() {
        return numeroSolicitacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContratoCliente getCliente() {
        return cliente;
    }

    public void setCliente(ContratoCliente cliente) {
        this.cliente = cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ItemPedido getTitular() {
        return titular;
    }

    public void setTitular(ItemPedido titular) {
        this.titular = titular;
    }

    public String getNumeroSolicitacao() {
        return numeroSolicitacao;
    }

    public void setNumeroSolicitacao(String numeroSolicitacao) {
        this.numeroSolicitacao = numeroSolicitacao;
    }

    public String getCpfRepresentanteLegal() {
        return cpfRepresentanteLegal;
    }

    public void setCpfRepresentanteLegal(String cpfRepresentanteLegal) {
        this.cpfRepresentanteLegal = cpfRepresentanteLegal;
    }

    public String getNomeRepresentanteLegal() {
        return nomeRepresentanteLegal;
    }

    public void setNomeRepresentanteLegal(String nomeRepresentanteLegal) {
        this.nomeRepresentanteLegal = nomeRepresentanteLegal;
    }

    public String getCpfResponsavelLegal() {
        return cpfResponsavelLegal;
    }

    public void setCpfResponsavelLegal(String cpfResponsavelLegal) {
        this.cpfResponsavelLegal = cpfResponsavelLegal;
    }

    public String getNomeResponsavelLegal() {
        return nomeResponsavelLegal;
    }

    public void setNomeResponsavelLegal(String nomeResponsavelLegal) {
        this.nomeResponsavelLegal = nomeResponsavelLegal;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public AutoridadeCertificadora getAutoridadeCertificadora() {
        return autoridadeCertificadora;
    }

    public void setAutoridadeCertificadora(AutoridadeCertificadora autoridadeCertificadora) {
        this.autoridadeCertificadora = autoridadeCertificadora;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getArmario() {
        return armario;
    }

    public void setArmario(Integer armario) {
        this.armario = armario;
    }

    public Integer getCaixa() {
        return caixa;
    }

    public void setCaixa(Integer caixa) {
        this.caixa = caixa;
    }

    public Integer getSequencial() {
        return sequencial;
    }

    public void setSequencial(Integer sequencial) {
        this.sequencial = sequencial;
    }

    public String getBaixa() {
        return baixa;
    }

    public void setBaixa(String baixa) {
        this.baixa = baixa;
    }

    public String getDocumentoRevogacao() {
        return documentoRevogacao;
    }

    public void setDocumentoRevogacao(String documentoRevogacao) {
        this.documentoRevogacao = documentoRevogacao;
    }

    public Date getDataRevogacao() {
        return dataRevogacao;
    }

    public void setDataRevogacao(Date dataRevogacao) {
        this.dataRevogacao = dataRevogacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
        final Certificado other = (Certificado) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
