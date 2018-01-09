/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import br.gov.pi.ati.siopm.modelo.enums.TipoCabine;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
//@Entity
public class Cabina implements Serializable {

    @Id
    @SequenceGenerator(name = "Cabina", sequenceName = "cabina_id_seq")
    @GeneratedValue(generator = "Cabina")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidade;

    @NotNull
    private Integer numero;

    @Size(max = 260)
    @NotBlank
    private String descricao;

    @NotNull
    private TipoCabine tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Operacao operacao;

    private boolean receberAltertas = true;

    private boolean bloqueioAlertaRoubo = true;

    private boolean bloqueioAlertaPessoa = true;

    private boolean bloqueioAlertaFurto = true;

    private boolean bloqueioAlertaOutros = true;
    
    private boolean ativo = true;

    @OneToMany(targetEntity = Opm.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Opm> opms = new ArrayList<Opm>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoCabine getTipo() {
        return tipo;
    }

    public void setTipo(TipoCabine tipo) {
        this.tipo = tipo;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public boolean isReceberAltertas() {
        return receberAltertas;
    }

    public void setReceberAltertas(boolean receberAltertas) {
        this.receberAltertas = receberAltertas;
    }

    public boolean isBloqueioAlertaRoubo() {
        return bloqueioAlertaRoubo;
    }

    public void setBloqueioAlertaRoubo(boolean bloqueioAlertaRoubo) {
        this.bloqueioAlertaRoubo = bloqueioAlertaRoubo;
    }

    public boolean isBloqueioAlertaPessoa() {
        return bloqueioAlertaPessoa;
    }

    public void setBloqueioAlertaPessoa(boolean bloqueioAlertaPessoa) {
        this.bloqueioAlertaPessoa = bloqueioAlertaPessoa;
    }

    public boolean isBloqueioAlertaFurto() {
        return bloqueioAlertaFurto;
    }

    public void setBloqueioAlertaFurto(boolean bloqueioAlertaFurto) {
        this.bloqueioAlertaFurto = bloqueioAlertaFurto;
    }

    public boolean isBloqueioAlertaOutros() {
        return bloqueioAlertaOutros;
    }

    public void setBloqueioAlertaOutros(boolean bloqueioAlertaOutros) {
        this.bloqueioAlertaOutros = bloqueioAlertaOutros;
    }

    public List<Opm> getOpms() {
        return opms;
    }

    public void setOpms(List<Opm> opms) {
        this.opms = opms;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Cabina other = (Cabina) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numero.toString();
    }

}
