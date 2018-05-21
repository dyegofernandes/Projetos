/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sccd.modelo.cadastro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

/**
 *
 * @author JUniel
 */
@Entity
public class TipoCertificadoFornecedor implements Serializable {

    @Id
    @SequenceGenerator(name = "TipoCertificadoAux", sequenceName = "tipoCertificadoAux_id_seq")
    @GeneratedValue(generator = "TipoCertificadoAux")
    private Long id;
    
    @Size(max = 50)
    private String nome;

    @ManyToMany(targetEntity = TipoCertificado.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<TipoCertificado> tiposCertificados = new ArrayList<TipoCertificado>();

    private BigDecimal valor;

    private BigDecimal quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TipoCertificado> getTiposCertificados() {
        return tiposCertificados;
    }

    public void setTiposCertificados(List<TipoCertificado> tiposCertificados) {
        this.tiposCertificados = tiposCertificados;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal() {
        if (quantidade != null && valor != null) {
            return quantidade.multiply(valor);
        }
        return BigDecimal.ZERO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final TipoCertificadoFornecedor other = (TipoCertificadoFornecedor) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
