/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo;

import br.gov.pi.ati.sisdh.modelo.cadastro.Bairro;
import br.gov.pi.ati.sisdh.modelo.cadastro.Cidade;
import br.gov.pi.ati.sisdh.modelo.cadastro.GrupoDeViolacao;
import br.gov.pi.ati.sisdh.modelo.cadastro.NaturezaDaViolacao;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.OrientacaoSexual;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Raca;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Sexo;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Situacao;
import br.gov.pi.ati.sisdh.modelo.controleacesso.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juniel
 */
public class FiltroVO implements Serializable{
    private String codigo;
    
    private String numero;
    
    private Usuario usuario; 
    
    private Date dataInicial1;
    
    private Date dataFinal1;
    
    private Date dataInicial2;
    
    private Date dataFinal2;
    
    private GrupoDeViolacao grupoDeViolacao;
    
    private List<NaturezaDaViolacao> naturezaDaViolacoes;
    
    private Cidade cidade;
    
    private Bairro bairro;
    
    private Sexo sexoDaVitima;
    
    private Sexo sexoDaSuspeito;
    
    private Raca racaoCorDaVitima;
    
     private Raca racaoCorDaSuspeito;
     
     private OrientacaoSexual orientacaoSexualVitima;
     
     private OrientacaoSexual orientacaoSexualSuspeito;
     
     private Situacao situacao;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataInicial1() {
        return dataInicial1;
    }

    public void setDataInicial1(Date dataInicial1) {
        this.dataInicial1 = dataInicial1;
    }

    public Date getDataFinal1() {
        return dataFinal1;
    }

    public void setDataFinal1(Date dataFinal1) {
        this.dataFinal1 = dataFinal1;
    }

    public Date getDataInicial2() {
        return dataInicial2;
    }

    public void setDataInicial2(Date dataInicial2) {
        this.dataInicial2 = dataInicial2;
    }

    public Date getDataFinal2() {
        return dataFinal2;
    }

    public void setDataFinal2(Date dataFinal2) {
        this.dataFinal2 = dataFinal2;
    }

    public GrupoDeViolacao getGrupoDeViolacao() {
        return grupoDeViolacao;
    }

    public void setGrupoDeViolacao(GrupoDeViolacao grupoDeViolacao) {
        this.grupoDeViolacao = grupoDeViolacao;
    }

    public List<NaturezaDaViolacao> getNaturezaDaViolacoes() {
        return naturezaDaViolacoes;
    }

    public void setNaturezaDaViolacoes(List<NaturezaDaViolacao> naturezaDaViolacoes) {
        this.naturezaDaViolacoes = naturezaDaViolacoes;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Sexo getSexoDaVitima() {
        return sexoDaVitima;
    }

    public void setSexoDaVitima(Sexo sexoDaVitima) {
        this.sexoDaVitima = sexoDaVitima;
    }

    public Sexo getSexoDaSuspeito() {
        return sexoDaSuspeito;
    }

    public void setSexoDaSuspeito(Sexo sexoDaSuspeito) {
        this.sexoDaSuspeito = sexoDaSuspeito;
    }

    public Raca getRacaoCorDaVitima() {
        return racaoCorDaVitima;
    }

    public void setRacaoCorDaVitima(Raca racaoCorDaVitima) {
        this.racaoCorDaVitima = racaoCorDaVitima;
    }

    public Raca getRacaoCorDaSuspeito() {
        return racaoCorDaSuspeito;
    }

    public void setRacaoCorDaSuspeito(Raca racaoCorDaSuspeito) {
        this.racaoCorDaSuspeito = racaoCorDaSuspeito;
    }

    public OrientacaoSexual getOrientacaoSexualVitima() {
        return orientacaoSexualVitima;
    }

    public void setOrientacaoSexualVitima(OrientacaoSexual orientacaoSexualVitima) {
        this.orientacaoSexualVitima = orientacaoSexualVitima;
    }

    public OrientacaoSexual getOrientacaoSexualSuspeito() {
        return orientacaoSexualSuspeito;
    }

    public void setOrientacaoSexualSuspeito(OrientacaoSexual orientacaoSexualSuspeito) {
        this.orientacaoSexualSuspeito = orientacaoSexualSuspeito;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
     
     
}
