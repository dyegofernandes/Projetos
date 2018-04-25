/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.certificado;

import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
import br.gov.pi.ati.sccd.modelo.enums.SituacaoAgendamento;
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
public class Agendamento implements Serializable {

    @Id
    @SequenceGenerator(name = "Pedido", sequenceName = "pedido_id_seq")
    @GeneratedValue(generator = "Pedido")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cliente cliente;

    @Size(max = 250)
    @NotBlank
    private String protocolo; //AG.117.2.XXXXXX/AA(ano)

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private ItemPedido itemPedido;

    @Size(max = 250)
    @NotBlank
    @Email
    private String email;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataAgendamento;

    @Temporal(TemporalType.TIME)
    @NotNull
    private Date horaInicial;

    @Temporal(TemporalType.TIME)
    @NotNull
    private Date horaFinal;

    @Temporal(TemporalType.TIME)
    private Date horaInicialAtendimento;

    @Temporal(TemporalType.TIME)
    private Date horaFinalAtendimento;

    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private SituacaoAgendamento situacao;

    @Override
    public String toString() {
        return protocolo;
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

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Date getHoraInicialAtendimento() {
        return horaInicialAtendimento;
    }

    public void setHoraInicialAtendimento(Date horaInicialAtendimento) {
        this.horaInicialAtendimento = horaInicialAtendimento;
    }

    public Date getHoraFinalAtendimento() {
        return horaFinalAtendimento;
    }

    public void setHoraFinalAtendimento(Date horaFinalAtendimento) {
        this.horaFinalAtendimento = horaFinalAtendimento;
    }

    public SituacaoAgendamento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoAgendamento situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Agendamento other = (Agendamento) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
