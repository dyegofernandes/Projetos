/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dizimo.modelo.financeiro;

import br.com.dizimo.modelo.controleacesso.Usuario;
import br.com.dizimo.modelo.enums.StatusCaixa;
import java.io.Serializable;
import java.util.Date;
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

/**
 *
 * @author Juniel
 */
@Entity
public class Caixa implements Serializable {

    @Id
    @SequenceGenerator(name = "Caixa", sequenceName = "caixa_seq_id")
    @GeneratedValue(generator = "Caixa")
    private Long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date abertura;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario usuarioAbertura;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioFechamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusCaixa status = StatusCaixa.ABERTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public Date getFechamento() {
        return fechamento;
    }

    public void setFechamento(Date fechamento) {
        this.fechamento = fechamento;
    }

    public Usuario getUsuarioAbertura() {
        return usuarioAbertura;
    }

    public void setUsuarioAbertura(Usuario usuarioAbertura) {
        this.usuarioAbertura = usuarioAbertura;
    }

    public Usuario getUsuarioFechamento() {
        return usuarioFechamento;
    }

    public void setUsuarioFechamento(Usuario usuarioFechamento) {
        this.usuarioFechamento = usuarioFechamento;
    }

    public StatusCaixa getStatus() {
        return status;
    }

    public void setStatus(StatusCaixa status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Caixa other = (Caixa) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
