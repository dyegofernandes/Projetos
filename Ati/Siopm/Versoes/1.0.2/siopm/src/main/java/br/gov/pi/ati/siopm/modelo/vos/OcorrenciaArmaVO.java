/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.vos;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Juniel
 */
public class OcorrenciaArmaVO implements Serializable {

    private Long id;

    private String codigo;

    private String situacaoOcorrencia;

    private String dataOcorrencia;

    private String horaOcorrencia;

    private String dataEncerramento;

    private String horaEncerramento;

    private String dataAtendimento;

    private String horaAtendimento;

    private String enderecoFormatado;

    private String logradouro;

    private String numero;

    private String bairro;

    private String complemento;

    private String referencia;

    private String cep;

    private String cidade;

    private String estado;

    private String pais;

    private double latitude;

    private double longitude;

    private String tipo;

    private String nomeModelo;

    private BigDecimal calibre;

    private Integer capacidade;

    private Integer quantidadeDeflagrada;

    private String numeracao;

    private String armaDaPolicia;
    
    private String marca;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(String dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getHoraOcorrencia() {
        return horaOcorrencia;
    }

    public void setHoraOcorrencia(String horaOcorrencia) {
        this.horaOcorrencia = horaOcorrencia;
    }

    public String getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(String dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public String getHoraEncerramento() {
        return horaEncerramento;
    }

    public void setHoraEncerramento(String horaEncerramento) {
        this.horaEncerramento = horaEncerramento;
    }

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(String horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

    public String getEnderecoFormatado() {
        return enderecoFormatado;
    }

    public void setEnderecoFormatado(String enderecoFormatado) {
        this.enderecoFormatado = enderecoFormatado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
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

    public String getArmaDaPolicia() {
        return armaDaPolicia;
    }

    public void setArmaDaPolicia(String armaDaPolicia) {
        this.armaDaPolicia = armaDaPolicia;
    }

    public String getSituacaoOcorrencia() {
        return situacaoOcorrencia;
    }

    public void setSituacaoOcorrencia(String situacaoOcorrencia) {
        this.situacaoOcorrencia = situacaoOcorrencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
