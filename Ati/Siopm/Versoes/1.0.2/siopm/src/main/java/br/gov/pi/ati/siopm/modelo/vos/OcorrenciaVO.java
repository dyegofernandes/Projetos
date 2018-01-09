/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.vos;

import java.io.Serializable;

/**
 *
 * @author Juniel
 */
public class OcorrenciaVO implements Serializable {

    private Long id;

    private String codigo;

    private Long idSolicitante;

    private String solicitante;

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

    private String tipoChamada;

    private String classificacaoChamada;

    private String classificacaoOcorrencia;

    private String situacao;
    
    private String opm;
    
    private String resultado;

    private String patrulha;

    private String natureza;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
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

    public String getTipoChamada() {
        return tipoChamada;
    }

    public void setTipoChamada(String tipoChamada) {
        this.tipoChamada = tipoChamada;
    }

    public String getClassificacaoChamada() {
        return classificacaoChamada;
    }

    public void setClassificacaoChamada(String classificacaoChamada) {
        this.classificacaoChamada = classificacaoChamada;
    }

    public String getClassificacaoOcorrencia() {
        return classificacaoOcorrencia;
    }

    public void setClassificacaoOcorrencia(String classificacaoOcorrencia) {
        this.classificacaoOcorrencia = classificacaoOcorrencia;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getPatrulha() {
        return patrulha;
    }

    public void setPatrulha(String patrulha) {
        this.patrulha = patrulha;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(Long idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getOpm() {
        return opm;
    }

    public void setOpm(String opm) {
        this.opm = opm;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

}
