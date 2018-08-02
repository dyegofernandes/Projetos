/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.cadastro;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class EncaminhamentoLGBT implements Serializable {

    @Id
    @SequenceGenerator(name = "RequerimentoLGBT", sequenceName = "seq_requerimentoLGBT")
    @GeneratedValue(generator = "RequerimentoLGBT")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataEmissao = new Date();

    @NotBlank
    private String nome;

    private String rg;

    private String cpf;

    private String telefone;
    
    private String celular;

    private String endereco;

    private String area;

    private String ncUsuario;

    private String encaminhadoPara;

    private String responsavelRedeServico;

    private String responsavelCR;

    @Column(columnDefinition = "Text")
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNcUsuario() {
        return ncUsuario;
    }

    public void setNcUsuario(String ncUsuario) {
        this.ncUsuario = ncUsuario;
    }

    public String getEncaminhadoPara() {
        return encaminhadoPara;
    }

    public void setEncaminhadoPara(String encaminhadoPara) {
        this.encaminhadoPara = encaminhadoPara;
    }

    public String getResponsavelRedeServico() {
        return responsavelRedeServico;
    }

    public void setResponsavelRedeServico(String responsavelRedeServico) {
        this.responsavelRedeServico = responsavelRedeServico;
    }

    public String getResponsavelCR() {
        return responsavelCR;
    }

    public void setResponsavelCR(String responsavelCR) {
        this.responsavelCR = responsavelCR;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final EncaminhamentoLGBT other = (EncaminhamentoLGBT) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
