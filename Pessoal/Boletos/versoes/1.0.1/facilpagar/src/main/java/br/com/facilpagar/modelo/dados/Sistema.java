/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facilpagar.modelo.dados;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
@Table(schema = "dados")
public class Sistema implements Serializable {

    @Id
    @SequenceGenerator(schema = "dados", allocationSize = 1, name = "Sistema", sequenceName = "dados.seq_sistema_id")
    @GeneratedValue(generator = "Sistema")
    private Long id;

    @Column(columnDefinition = "Text")
    @NotBlank
    private String tokenRequestURL_BB;

    @Column(columnDefinition = "Text")
    @NotBlank
    private String clienteID_BB;

    @Column(columnDefinition = "Text")
    @NotBlank
    private String clienteSecret_BB;

    @Column(columnDefinition = "Text")
    private String token_BB;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataGeracaoToken;
    
    private Long tempoValidadeEmSegundos_BB;
    
    @Column(columnDefinition = "Text")
    private String observacaoToken_BB;

    @Column(columnDefinition = "Text")
    private String urlRegistrarBoleto_BB;

    private boolean ativo = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenRequestURL_BB() {
        return tokenRequestURL_BB;
    }

    public void setTokenRequestURL_BB(String tokenRequestURL_BB) {
        this.tokenRequestURL_BB = tokenRequestURL_BB;
    }

    public String getClienteID_BB() {
        return clienteID_BB;
    }

    public void setClienteID_BB(String clienteID_BB) {
        this.clienteID_BB = clienteID_BB;
    }

    public String getClienteSecret_BB() {
        return clienteSecret_BB;
    }

    public void setClienteSecret_BB(String clienteSecret_BB) {
        this.clienteSecret_BB = clienteSecret_BB;
    }

    public String getToken_BB() {
        return token_BB;
    }

    public void setToken_BB(String token_BB) {
        this.token_BB = token_BB;
    }

    public String getUrlRegistrarBoleto_BB() {
        return urlRegistrarBoleto_BB;
    }

    public void setUrlRegistrarBoleto_BB(String urlRegistrarBoleto_BB) {
        this.urlRegistrarBoleto_BB = urlRegistrarBoleto_BB;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataGeracaoToken() {
        return dataGeracaoToken;
    }

    public void setDataGeracaoToken(Date dataGeracaoToken) {
        this.dataGeracaoToken = dataGeracaoToken;
    }

    public String getObservacaoToken_BB() {
        return observacaoToken_BB;
    }

    public void setObservacaoToken_BB(String observacaoToken_BB) {
        this.observacaoToken_BB = observacaoToken_BB;
    }

    public Long getTempoValidadeEmSegundos_BB() {
        return tempoValidadeEmSegundos_BB;
    }

    public void setTempoValidadeEmSegundos_BB(Long tempoValidadeEmSegundos_BB) {
        this.tempoValidadeEmSegundos_BB = tempoValidadeEmSegundos_BB;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Sistema other = (Sistema) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
