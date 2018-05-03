/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.certificado;

import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
import br.gov.pi.ati.sccd.modelo.cadastro.Contato;
import br.gov.pi.ati.sccd.modelo.enums.SituacaoAgendamento;
import br.gov.pi.ati.sccd.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Agendamento implements Serializable {

    @Id
    @SequenceGenerator(name = "Agendamento", sequenceName = "agendamento_id_seq")
    @GeneratedValue(generator = "Agendamento")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Cliente cliente;

    @Size(max = 250)
    @NotBlank
    private String protocolo; //AG.117.2.XXXXXX/AA(ano)

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @NotNull
    private ItemPedido itemPedido = new ItemPedido();

    @Size(max = 250)
    @NotBlank
    @Email
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataInicial;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataFinal;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtendimento;

    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private SituacaoAgendamento situacao;

    @ManyToMany(targetEntity = ArquivoAgendamento.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ArquivoAgendamento> arquivos = new ArrayList<ArquivoAgendamento>();

    @ManyToMany(targetEntity = Contato.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Contato> contatos = new ArrayList<Contato>();

    @Column(columnDefinition = "Text")
    private String observacao;

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

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public SituacaoAgendamento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoAgendamento situacao) {
        this.situacao = situacao;
    }

    public List<ArquivoAgendamento> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<ArquivoAgendamento> arquivos) {
        this.arquivos = arquivos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDataValidadeFormatada() {
        if (dataInicial != null) {
            return Utils.getDateString(dataInicial, "dd/MM/yyyy HH:mm");
        }
        return null;
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
