/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.vos;

import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
import br.gov.pi.ati.sisforms.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sisforms.modelo.enums.Situacao;
import br.gov.pi.ati.sisforms.modelo.enums.StatusDominio;
import br.gov.pi.ati.sisforms.modelo.enums.TipoLocal;
import br.gov.pi.ati.sisforms.modelo.servicos.LocalReserva;
import br.gov.pi.ati.sisforms.modelo.servicos.ReservaLocal;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Juniel
 */
public class FiltrosVO implements Serializable{
    
    private Usuario usuario;
    
    private Orgao orgao;
    
    private Date dataInicial;
    
    private Date dataFinal;
    
    private String nome;
    
    private String descricao;
    
     private String assunto;
    
    private String cnpj;
    
    private String cpf;
    
    private String sigla;
    
    private String cargo;
    
    private String matricula;
    
    private Date dataEmissaoInicial;
    
    private Date dataEmissaoFinal;
    
    private Situacao situacao;
    
    private StatusDominio status;
    
    private String numeroContrato;
    
    private String municipio;
    
    private String lotacao;
    
    private String gerencia;
    
    private String coordenadoria;
    
    private String requisitadoPor;
    
    private String periodoInicial;
            
    private String periodoFinal;    
    
    private Integer ano;
    
    private Integer numero;
    
    private ReservaLocal reserva;
    
    private LocalReserva local;
    
    private String solicitante;
    
    public String Titulo;
    
    public Orgao orgaoSolicitante;
    
    private TipoLocal tipo;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataEmissaoInicial() {
        return dataEmissaoInicial;
    }

    public void setDataEmissaoInicial(Date dataEmissaoInicial) {
        this.dataEmissaoInicial = dataEmissaoInicial;
    }

    public Date getDataEmissaoFinal() {
        return dataEmissaoFinal;
    }

    public void setDataEmissaoFinal(Date dataEmissaoFinal) {
        this.dataEmissaoFinal = dataEmissaoFinal;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public StatusDominio getStatus() {
        return status;
    }

    public void setStatus(StatusDominio status) {
        this.status = status;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLotacao() {
        return lotacao;
    }

    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getCoordenadoria() {
        return coordenadoria;
    }

    public void setCoordenadoria(String coordenadoria) {
        this.coordenadoria = coordenadoria;
    }

    public String getRequisitadoPor() {
        return requisitadoPor;
    }

    public void setRequisitadoPor(String requisitadoPor) {
        this.requisitadoPor = requisitadoPor;
    }

    public String getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(String periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public String getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(String periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public ReservaLocal getReserva() {
        return reserva;
    }

    public void setReserva(ReservaLocal reserva) {
        this.reserva = reserva;
    }

    public LocalReserva getLocal() {
        return local;
    }

    public void setLocal(LocalReserva local) {
        this.local = local;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public Orgao getOrgaoSolicitante() {
        return orgaoSolicitante;
    }

    public void setOrgaoSolicitante(Orgao orgaoSolicitante) {
        this.orgaoSolicitante = orgaoSolicitante;
    }

    public TipoLocal getTipo() {
        return tipo;
    }

    public void setTipo(TipoLocal tipo) {
        this.tipo = tipo;
    }
    
     
    
}
