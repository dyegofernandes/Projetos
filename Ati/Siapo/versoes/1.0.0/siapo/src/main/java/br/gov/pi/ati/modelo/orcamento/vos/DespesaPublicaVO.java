/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.modelo.orcamento.vos;

import java.io.InputStream;
import java.io.Serializable;

/**
 *
 * @author Juniel
 */
public class DespesaPublicaVO implements Serializable {

    private String numeroProcesso;
    private String resumoDespesa;
    private String dotacaoPrimeiroMes;
    private String totalExercicioVingente;
    private String codigoOrgao;
    private String codigoUnidade;
    private String codigoFuncao;
    private String codigoSubfuncao;
    private String codigoPrograma;
    private String codigoAcao;
    private String codigoNatureza;
    private String codigoSubelemento;
    private String codigoFonte;
    private String dotacaoInicial;
    private String alteracaoNaLoa;
    private String despesasEmpenhadas;
    private String somaTotalExercioVingente;
    private String saldoOrcamentariaDisponivel;
    private String totalProximoExercicio;
    private String nomeResponsavel;
    private String cargoResponsavel;
    private String cpfResponsavel;
    private String dataHomogacao;
    private String dataCadastro;
    private boolean homologado;
    
    private InputStream qrCode;

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getResumoDespesa() {
        return resumoDespesa;
    }

    public void setResumoDespesa(String resumoDespesa) {
        this.resumoDespesa = resumoDespesa;
    }

    public String getDotacaoPrimeiroMes() {
        return dotacaoPrimeiroMes;
    }

    public void setDotacaoPrimeiroMes(String dotacaoPrimeiroMes) {
        this.dotacaoPrimeiroMes = dotacaoPrimeiroMes;
    }

    public String getTotalExercicioVingente() {
        return totalExercicioVingente;
    }

    public void setTotalExercicioVingente(String totalExercicioVingente) {
        this.totalExercicioVingente = totalExercicioVingente;
    }

    public String getCodigoOrgao() {
        return codigoOrgao;
    }

    public void setCodigoOrgao(String codigoOrgao) {
        this.codigoOrgao = codigoOrgao;
    }

    public String getCodigoUnidade() {
        return codigoUnidade;
    }

    public void setCodigoUnidade(String codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    public String getCodigoFuncao() {
        return codigoFuncao;
    }

    public void setCodigoFuncao(String codigoFuncao) {
        this.codigoFuncao = codigoFuncao;
    }

    public String getCodigoSubfuncao() {
        return codigoSubfuncao;
    }

    public void setCodigoSubfuncao(String codigoSubfuncao) {
        this.codigoSubfuncao = codigoSubfuncao;
    }

    public String getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(String codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    public String getCodigoAcao() {
        return codigoAcao;
    }

    public void setCodigoAcao(String codigoAcao) {
        this.codigoAcao = codigoAcao;
    }

    public String getCodigoNatureza() {
        return codigoNatureza;
    }

    public void setCodigoNatureza(String codigoNatureza) {
        this.codigoNatureza = codigoNatureza;
    }

    public String getCodigoSubelemento() {
        return codigoSubelemento;
    }

    public void setCodigoSubelemento(String codigoSubelemento) {
        this.codigoSubelemento = codigoSubelemento;
    }

    public String getCodigoFonte() {
        return codigoFonte;
    }

    public void setCodigoFonte(String codigoFonte) {
        this.codigoFonte = codigoFonte;
    }

    public String getDotacaoInicial() {
        return dotacaoInicial;
    }

    public void setDotacaoInicial(String dotacaoInicial) {
        this.dotacaoInicial = dotacaoInicial;
    }

    public String getAlteracaoNaLoa() {
        return alteracaoNaLoa;
    }

    public void setAlteracaoNaLoa(String alteracaoNaLoa) {
        this.alteracaoNaLoa = alteracaoNaLoa;
    }

    public String getDespesasEmpenhadas() {
        return despesasEmpenhadas;
    }

    public void setDespesasEmpenhadas(String despesasEmpenhadas) {
        this.despesasEmpenhadas = despesasEmpenhadas;
    }

    public String getSomaTotalExercioVingente() {
        return somaTotalExercioVingente;
    }

    public void setSomaTotalExercioVingente(String somaTotalExercioVingente) {
        this.somaTotalExercioVingente = somaTotalExercioVingente;
    }

    public String getSaldoOrcamentariaDisponivel() {
        return saldoOrcamentariaDisponivel;
    }

    public void setSaldoOrcamentariaDisponivel(String saldoOrcamentariaDisponivel) {
        this.saldoOrcamentariaDisponivel = saldoOrcamentariaDisponivel;
    }

    public String getTotalProximoExercicio() {
        return totalProximoExercicio;
    }

    public void setTotalProximoExercicio(String totalProximoExercicio) {
        this.totalProximoExercicio = totalProximoExercicio;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCargoResponsavel() {
        return cargoResponsavel;
    }

    public void setCargoResponsavel(String cargoResponsavel) {
        this.cargoResponsavel = cargoResponsavel;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public String getDataHomogacao() {
        return dataHomogacao;
    }

    public void setDataHomogacao(String dataHomogacao) {
        this.dataHomogacao = dataHomogacao;
    }

    public boolean isHomologado() {
        return homologado;
    }

    public void setHomologado(boolean homologado) {
        this.homologado = homologado;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public InputStream getQrCode() {
        return qrCode;
    }

    public void setQrCode(InputStream qrCode) {
        this.qrCode = qrCode;
    }

    
    
    
}
