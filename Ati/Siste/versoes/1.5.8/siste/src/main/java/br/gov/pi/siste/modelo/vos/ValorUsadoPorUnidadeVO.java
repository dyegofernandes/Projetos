/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.siste.modelo.vos;

import java.math.BigDecimal;

/**
 *
 * @author Juniel
 */
public class ValorUsadoPorUnidadeVO {
    
    private String tipo;
    
    private Integer codigo;
    
    private String nome;
    
    private BigDecimal valorUsado;
    
    private BigDecimal valorLimite;
    
    private BigDecimal porcentagem;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorUsado() {
        return valorUsado;
    }

    public void setValorUsado(BigDecimal valorUsado) {
        this.valorUsado = valorUsado;
    }

    public BigDecimal getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(BigDecimal valorLimite) {
        this.valorLimite = valorLimite;
    }

    public BigDecimal getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(BigDecimal porcentagem) {
        this.porcentagem = porcentagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
