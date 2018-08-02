/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ejccard.modelo.financeiro;

import br.com.ejccard.modelo.cadastro.Membro;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
public class EjcCard implements Serializable {

    @Id
    @SequenceGenerator(name = "EjcCard", allocationSize = 1, sequenceName = "ejccard_id_seq")
    @GeneratedValue(generator = "EjcCard")
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String numero;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date cadastro = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date validade = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Membro membro;

    @NotNull
    private BigDecimal limiteCredito;

    @NotNull
    private BigDecimal credito = BigDecimal.ZERO;

    @NotNull
    private BigDecimal debito = BigDecimal.ZERO;

    private boolean ativo = true;

    public BigDecimal getCreditoDisponivel() {
        BigDecimal valor = BigDecimal.ZERO;

        if (limiteCredito != null && credito != null) {
            valor = valor.add(limiteCredito).subtract(credito);
        }

        return valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    public BigDecimal getDebito() {
        return debito;
    }

    public void setDebito(BigDecimal debito) {
        this.debito = debito;
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
        final EjcCard other = (EjcCard) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
