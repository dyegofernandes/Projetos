/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import br.gov.pi.ati.sisforms.modelo.cadastro.OrgaoCertificado;
import br.gov.pi.ati.sisforms.modelo.cadastro.TipoCertificado;
import br.gov.pi.ati.sisforms.modelo.enums.AutoridadeCertificadora;
import br.gov.pi.ati.sisforms.modelo.enums.TipoCertificadoEnum;
import br.gov.pi.ati.sisforms.modelo.enums.TipoPessoa;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class ControleDeCertificado implements Serializable {

    @Id
    @SequenceGenerator(name = "ControleDeCertificado", sequenceName = "controleDeCertificado_id_seq")
    @GeneratedValue(generator = "ControleDeCertificado")
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String numeroSolicitacao;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoPessoa tipoPessoa = TipoPessoa.FISICA;

    @Size(max = 20)
    private String cnpj;

    @Size(max = 20)
    private String cpf;

    @Size(max = 100)
    @Email
    private String email;

    @Size(max = 255)
    private String enderecoWeb;

    @Size(max = 255)
    private String solicitante;

    @Size(max = 255)
    private String titular;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private OrgaoCertificado orgao;

    @Size(max = 255)
    private String protocoloAti;

    @Column(length = 40)
    @Enumerated(EnumType.STRING)
    private AutoridadeCertificadora ac;

    @Column(length = 40)
    @Enumerated(EnumType.STRING)
    private TipoCertificadoEnum infra;

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoCertificado tipoCertificado;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroSolicitacao() {
        return numeroSolicitacao;
    }

    public void setNumeroSolicitacao(String numeroSolicitacao) {
        this.numeroSolicitacao = numeroSolicitacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnderecoWeb() {
        return enderecoWeb;
    }

    public TipoCertificado getTipoCertificado() {
        return tipoCertificado;
    }

    public void setTipoCertificado(TipoCertificado tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public void setEnderecoWeb(String enderecoWeb) {
        this.enderecoWeb = enderecoWeb;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public OrgaoCertificado getOrgao() {
        return orgao;
    }

    public void setOrgao(OrgaoCertificado orgao) {
        this.orgao = orgao;
    }

    public String getProtocoloAti() {
        return protocoloAti;
    }

    public void setProtocoloAti(String protocoloAti) {
        this.protocoloAti = protocoloAti;
    }

    public AutoridadeCertificadora getAc() {
        return ac;
    }

    public void setAc(AutoridadeCertificadora ac) {
        this.ac = ac;
    }

    public TipoCertificadoEnum getInfra() {
        return infra;
    }

    public void setInfra(TipoCertificadoEnum infra) {
        this.infra = infra;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
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

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
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

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ControleDeCertificado other = (ControleDeCertificado) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
