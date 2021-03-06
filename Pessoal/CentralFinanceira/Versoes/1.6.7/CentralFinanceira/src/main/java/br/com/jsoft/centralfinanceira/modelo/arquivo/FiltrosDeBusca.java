/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsoft.centralfinanceira.modelo.arquivo;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Juniel
 */
public class FiltrosDeBusca {

    private String convenio;
    
    private String diretorioPai;
    
    private String diretorioFilho;

    private String nomeArquivo;

    private Date dataInicial;
    
    private Date dataFinal;

    private BigDecimal valor;
    
    private TipoRepasse tipo;
    
    private BigDecimal unitario;
    
    private String nome;
    
    private String apelido;
    
    private String cpfCnpj;
    
    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoRepasse getTipo() {
        return tipo;
    }

    public void setTipo(TipoRepasse tipo) {
        this.tipo = tipo;
    }   

    public String getDiretorioPai() {
        return diretorioPai;
    }

    public void setDiretorioPai(String diretorioPai) {
        this.diretorioPai = diretorioPai;
    }

    public String getDiretorioFilho() {
        return diretorioFilho;
    }

    public void setDiretorioFilho(String diretorioFilho) {
        this.diretorioFilho = diretorioFilho;
    }

    public BigDecimal getUnitario() {
        return unitario;
    }

    public void setUnitario(BigDecimal unitario) {
        this.unitario = unitario;
    }

}
