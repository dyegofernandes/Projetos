/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import br.gov.pi.ati.siopm.modelo.enums.ArmaPolicia;
import br.gov.pi.ati.siopm.modelo.enums.TipoDeArma;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class Arma implements Serializable {

    @Id
    @SequenceGenerator(name = "Arma", sequenceName = "arma_id_seq")
    @GeneratedValue(generator = "Arma")
    private Long id;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private TipoDeArma tipo;

    @Size(max = 260)
    private String nomeModelo;

    @ManyToOne(fetch = FetchType.LAZY)
    private MarcaDeArma marca;

    private BigDecimal calibre;

    private Integer capacidade;

    private Integer quantidadeDeflagrada;

    private String numeracao;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private ArmaPolicia armaDaPolicia = ArmaPolicia.NAO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoDeArma getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeArma tipo) {
        this.tipo = tipo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public MarcaDeArma getMarca() {
        return marca;
    }

    public void setMarca(MarcaDeArma marca) {
        this.marca = marca;
    }

    public BigDecimal getCalibre() {
        return calibre;
    }

    public void setCalibre(BigDecimal calibre) {
        this.calibre = calibre;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Integer getQuantidadeDeflagrada() {
        return quantidadeDeflagrada;
    }

    public void setQuantidadeDeflagrada(Integer quantidadeDeflagrada) {
        this.quantidadeDeflagrada = quantidadeDeflagrada;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(String numeracao) {
        this.numeracao = numeracao;
    }

    public ArmaPolicia getArmaDaPolicia() {
        return armaDaPolicia;
    }

    public void setArmaDaPolicia(ArmaPolicia armaDaPolicia) {
        this.armaDaPolicia = armaDaPolicia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Arma other = (Arma) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeModelo;
    }

}
