/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.vos;

import br.gov.pi.ati.siopm.modelo.cadastro.ModeloVeiculo;
import br.gov.pi.ati.siopm.modelo.cadastro.NaturezaOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.Opm;
import br.gov.pi.ati.siopm.modelo.cadastro.ResultadoOcorrencia;
import br.gov.pi.ati.siopm.modelo.controleacesso.Usuario;
import br.gov.pi.ati.siopm.modelo.enums.BairroGoogle;
import br.gov.pi.ati.siopm.modelo.enums.ClassificacaoPessoaOcorrencia;
import br.gov.pi.ati.siopm.modelo.enums.SimOuNao;
import br.gov.pi.ati.siopm.modelo.enums.SituacaoVeiculo;
import br.gov.pi.ati.siopm.modelo.enums.TipoDeArma;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juniel
 */
public class FiltrosVO {

    private String rg;

    private String cpf;

    private String cnh;

    private String nome;

    private String naturalidade;

    private ClassificacaoPessoaOcorrencia classificacaoPessoa;

    private String bairro;

    private String descricao;

    private String cidade;

    private BairroGoogle bairroGoogle;

    private String codigo;

    private Usuario usuario;

    private String logradouro;

    private List<Opm> opms;

    private Opm opm;

    private Date dataInicial;

    private Date dataFinal;

    private Date horaInicial;

    private Date horaFinal;

    private List<NaturezaOcorrencia> naturezas;

    private List<ResultadoOcorrencia> resultados;

    private String chassi;

    private String placa;

    private ModeloVeiculo modeloVeiculo;

    private SituacaoVeiculo situacaoVeiculo;

    private TipoDeArma tipoArma;

    private String modeloArma;

    private double calibre;

    private double capacidade;

    private SimOuNao armaPolicia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public BairroGoogle getBairroGoogle() {
        return bairroGoogle;
    }

    public void setBairroGoogle(BairroGoogle bairroGoogle) {
        this.bairroGoogle = bairroGoogle;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public List<Opm> getOpms() {
        return opms;
    }

    public void setOpms(List<Opm> opms) {
        this.opms = opms;
    }

    public Opm getOpm() {
        return opm;
    }

    public void setOpm(Opm opm) {
        this.opm = opm;
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

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<NaturezaOcorrencia> getNaturezas() {
        return naturezas;
    }

    public void setNaturezas(List<NaturezaOcorrencia> naturezas) {
        this.naturezas = naturezas;
    }

    public List<ResultadoOcorrencia> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoOcorrencia> resultados) {
        this.resultados = resultados;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public ClassificacaoPessoaOcorrencia getClassificacaoPessoa() {
        return classificacaoPessoa;
    }

    public void setClassificacaoPessoa(ClassificacaoPessoaOcorrencia classificacaoPessoa) {
        this.classificacaoPessoa = classificacaoPessoa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public ModeloVeiculo getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(ModeloVeiculo modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public SituacaoVeiculo getSituacaoVeiculo() {
        return situacaoVeiculo;
    }

    public void setSituacaoVeiculo(SituacaoVeiculo situacaoVeiculo) {
        this.situacaoVeiculo = situacaoVeiculo;
    }

    public TipoDeArma getTipoArma() {
        return tipoArma;
    }

    public void setTipoArma(TipoDeArma tipoArma) {
        this.tipoArma = tipoArma;
    }

    public String getModeloArma() {
        return modeloArma;
    }

    public void setModeloArma(String modeloArma) {
        this.modeloArma = modeloArma;
    }

    public double getCalibre() {
        return calibre;
    }

    public void setCalibre(double calibre) {
        this.calibre = calibre;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public SimOuNao getArmaPolicia() {
        return armaPolicia;
    }

    public void setArmaPolicia(SimOuNao armaPolicia) {
        this.armaPolicia = armaPolicia;
    }

    
}
