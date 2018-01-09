/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opfacil.VOs;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Juniel
 */
public class PagamentoVO {
    
    private Integer codigoOp;
    private String numeroOp;
    private Date dataEmissao;
    private Date dataVencimento;
    private Date dataPagamento;
    private String horaPagamento;
    private String nomeFavorecido;
    private String cpf;
    private String rg;
    private String orgaoEmissor;
    private BigDecimal valorOp;
    private String situacaoOp;
    private String empresa;
    private Integer idServico;
    private Integer agente;
    private Integer pos;
    private String posNomeFantasia;
    private String posCidade;
    private String posBairro;
    private String sistema;

    public PagamentoVO() {
    }

    private void inicializar(){
        
    }
    public Integer getCodigoOp() {
        return codigoOp;
    }

    public void setCodigoOp(Integer codigoOp) {
        this.codigoOp = codigoOp;
    }

    public String getNumeroOp() {
        return numeroOp;
    }

    public void setNumeroOp(String numeroOp) {
        this.numeroOp = numeroOp;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date DataEmissao) {
        this.dataEmissao = DataEmissao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date DataPagamento) {
        this.dataPagamento = DataPagamento;
    }

    public String getHoraPagamento() {
        return horaPagamento;
    }

    public void setHoraPagamento(String horaPagamento) {
        this.horaPagamento = horaPagamento;
    }

    public String getNomeFavorecido() {
        return nomeFavorecido;
    }

    public void setNomeFavorecido(String nomeFavorecido) {
        this.nomeFavorecido = nomeFavorecido;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public BigDecimal getValorOp() {
        return valorOp;
    }

    public void setValorOp(BigDecimal valorOp) {
        this.valorOp = valorOp;
    }

    public String getSituacaoOp() {
        return situacaoOp;
    }

    public void setSituacaoOp(String situacaoOp) {
        this.situacaoOp = situacaoOp;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public Integer getAgente() {
        return agente;
    }

    public void setAgente(Integer agente) {
        this.agente = agente;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public String getPosNomeFantasia() {
        return posNomeFantasia;
    }

    public void setPosNomeFantasia(String posNomeFantasia) {
        this.posNomeFantasia = posNomeFantasia;
    }

    public String getPosCidade() {
        return posCidade;
    }

    public void setPosCidade(String posCidade) {
        this.posCidade = posCidade;
    }

    public String getPosBairro() {
        return posBairro;
    }

    public void setPosBairro(String posBairro) {
        this.posBairro = posBairro;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    
}
