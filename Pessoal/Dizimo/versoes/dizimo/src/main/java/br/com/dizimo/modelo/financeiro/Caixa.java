/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dizimo.modelo.financeiro;

import br.com.dizimo.modelo.controleacesso.Usuario;
import br.com.dizimo.modelo.enums.StatusCaixa;
import br.com.dizimo.util.Utils;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
    private Date abertura = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Usuario usuario;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusCaixa status = StatusCaixa.ABERTO;

    @NotAudited
    @OneToMany(mappedBy = "caixa")
    @OrderBy("dataDevolucao")
    private List<Dizimo> dizimos;

    @Override
    public String toString() {
        if (abertura != null && status != null) {
            return Utils.convertDateToString(abertura, "dd/MM/yyyy HH:mm").concat(" - ").concat(status.getDescricao());
        }
        return Utils.convertDateToString(abertura, "dd/MM/yyyy HH:mm");
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setStatus(StatusCaixa status) {
        this.status = status;
    }

    public StatusCaixa getStatus() {
        return status;
    }

    public List<Dizimo> getDizimos() {
        return dizimos;
    }

    public void setDizimos(List<Dizimo> dizimos) {
        this.dizimos = dizimos;
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
