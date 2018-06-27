/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.vos;

import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.cadastro.Circunscricao;
import br.gov.pi.salvemaria.modelo.cadastro.CircunscricaoBairro;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import br.gov.pi.salvemaria.modelo.controleacesso.Usuario;
import br.gov.pi.salvemaria.modelo.enums.Demandante;
import br.gov.pi.salvemaria.modelo.enums.FaixaEtaria;
import br.gov.pi.salvemaria.modelo.enums.FormasDeViolencia;
import br.gov.pi.salvemaria.modelo.enums.Situacao;
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juniel
 */
public class Filtros implements Serializable {

    private Usuario usuario;

    private Unidade unidade;

    private String descricao;

    private Date dataDenunciaInicial;

    private Date dataDenunciaFinal;

    private Date horaDenunciaInicial;

    private Date horaDenunciaFinal;

    private FormasDeViolencia formaDeViolencia;

    private Situacao situacao;

    private Demandante demandante;

    private TipoDenuncia tipo;

    private Bairro bairro;

    private Cidade cidade;

    private Circunscricao circunscricao;

    private CircunscricaoBairro circunscricaoBairro;

    private String vitima;

    private String agressor;

    private Long id;

    private String cpfVitima;

    private String rgVitima;

    private String cnhVitima;

    private String cpfAgressor;

    private String rgAgressor;

    private String cnhAgressor;

    private FaixaEtaria faixaEtariaVitima = FaixaEtaria.TODAS;

    private FaixaEtaria faixaEtariaAgressor = FaixaEtaria.TODAS;

    private List<Unidade> unidadesAcesso = new ArrayList<Unidade>();

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDenunciaInicial() {
        return dataDenunciaInicial;
    }

    public void setDataDenunciaInicial(Date dataDenunciaInicial) {
        this.dataDenunciaInicial = dataDenunciaInicial;
    }

    public Date getDataDenunciaFinal() {
        return dataDenunciaFinal;
    }

    public void setDataDenunciaFinal(Date dataDenunciaFinal) {
        this.dataDenunciaFinal = dataDenunciaFinal;
    }

    public Date getHoraDenunciaInicial() {
        return horaDenunciaInicial;
    }

    public void setHoraDenunciaInicial(Date horaDenunciaInicial) {
        this.horaDenunciaInicial = horaDenunciaInicial;
    }

    public Date getHoraDenunciaFinal() {
        return horaDenunciaFinal;
    }

    public void setHoraDenunciaFinal(Date horaDenunciaFinal) {
        this.horaDenunciaFinal = horaDenunciaFinal;
    }

    public FormasDeViolencia getFormaDeViolencia() {
        return formaDeViolencia;
    }

    public void setFormaDeViolencia(FormasDeViolencia formaDeViolencia) {
        this.formaDeViolencia = formaDeViolencia;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Demandante getDemandante() {
        return demandante;
    }

    public void setDemandante(Demandante demandante) {
        this.demandante = demandante;
    }

    public TipoDenuncia getTipo() {
        return tipo;
    }

    public void setTipo(TipoDenuncia tipo) {
        this.tipo = tipo;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Circunscricao getCircunscricao() {
        return circunscricao;
    }

    public void setCircunscricao(Circunscricao circunscricao) {
        this.circunscricao = circunscricao;
    }

    public CircunscricaoBairro getCircunscricaoBairro() {
        return circunscricaoBairro;
    }

    public void setCircunscricaoBairro(CircunscricaoBairro circunscricaoBairro) {
        this.circunscricaoBairro = circunscricaoBairro;
    }

    public String getVitima() {
        return vitima;
    }

    public void setVitima(String vitima) {
        this.vitima = vitima;
    }

    public String getAgressor() {
        return agressor;
    }

    public void setAgressor(String agressor) {
        this.agressor = agressor;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfVitima() {
        return cpfVitima;
    }

    public void setCpfVitima(String cpfVitima) {
        this.cpfVitima = cpfVitima;
    }

    public String getRgVitima() {
        return rgVitima;
    }

    public void setRgVitima(String rgVitima) {
        this.rgVitima = rgVitima;
    }

    public String getCnhVitima() {
        return cnhVitima;
    }

    public void setCnhVitima(String cnhVitima) {
        this.cnhVitima = cnhVitima;
    }

    public String getCpfAgressor() {
        return cpfAgressor;
    }

    public void setCpfAgressor(String cpfAgressor) {
        this.cpfAgressor = cpfAgressor;
    }

    public String getRgAgressor() {
        return rgAgressor;
    }

    public void setRgAgressor(String rgAgressor) {
        this.rgAgressor = rgAgressor;
    }

    public String getCnhAgressor() {
        return cnhAgressor;
    }

    public void setCnhAgressor(String cnhAgressor) {
        this.cnhAgressor = cnhAgressor;
    }

    public FaixaEtaria getFaixaEtariaVitima() {
        return faixaEtariaVitima;
    }

    public void setFaixaEtariaVitima(FaixaEtaria faixaEtariaVitima) {
        this.faixaEtariaVitima = faixaEtariaVitima;
    }

    public FaixaEtaria getFaixaEtariaAgressor() {
        return faixaEtariaAgressor;
    }

    public void setFaixaEtariaAgressor(FaixaEtaria faixaEtariaAgressor) {
        this.faixaEtariaAgressor = faixaEtariaAgressor;
    }

    public List<Unidade> getUnidadesAcesso() {
        return unidadesAcesso;
    }

    public void setUnidadesAcesso(List<Unidade> unidadesAcesso) {
        this.unidadesAcesso = unidadesAcesso;
    }

}
