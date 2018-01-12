/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.ocorrencia;

import br.gov.pi.ati.siopm.modelo.cadastro.Arma;
import br.gov.pi.ati.siopm.modelo.cadastro.Arquivo;
import br.gov.pi.ati.siopm.modelo.cadastro.DrogaOcorrenciaItem;
import br.gov.pi.ati.siopm.modelo.cadastro.Endereco;
import br.gov.pi.ati.siopm.modelo.cadastro.LocalIntermediarioAux;
import br.gov.pi.ati.siopm.modelo.cadastro.NaturezaOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.ObjetoApreendido;
import br.gov.pi.ati.siopm.modelo.cadastro.Organizacao;
import br.gov.pi.ati.siopm.modelo.cadastro.PatrulhaAux;
import br.gov.pi.ati.siopm.modelo.cadastro.PessoaEnvolvida;
import br.gov.pi.ati.siopm.modelo.cadastro.QualificacaoDeVeiculo;
import br.gov.pi.ati.siopm.modelo.cadastro.ResultadoOcorrencia;
import br.gov.pi.ati.siopm.modelo.cadastro.Solicitante;
import br.gov.pi.ati.siopm.modelo.enums.ClassificacaoChamada;
import br.gov.pi.ati.siopm.modelo.enums.ClassificacaoOcorrencia;
import br.gov.pi.ati.siopm.modelo.enums.SimOuNao;
import br.gov.pi.ati.siopm.modelo.enums.SituacaoOcorrencia;
import br.gov.pi.ati.siopm.modelo.enums.TipoChamada;
import br.gov.pi.ati.siopm.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Juniel
 */
@Entity
public class Ocorrencia implements Serializable {

    @Id
    @SequenceGenerator(name = "Ocorrencia", sequenceName = "ocorrencia_id_seq")
    @GeneratedValue(generator = "Ocorrencia")
    private Long id;

    @ManyToMany(targetEntity = Solicitante.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Solicitante> solicitantes = new ArrayList<Solicitante>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @NotNull
    private Endereco endereco = new Endereco();

    @ManyToMany(targetEntity = Organizacao.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Organizacao> organizacoes = new ArrayList<Organizacao>();

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataOcorrencia = new Date();

    @NotNull
    private Integer codigo = 1;

    private Integer ano = Utils.getAnoAtual();

    @Column(columnDefinition = "Text")
    private String historioInicial;

    @Column(columnDefinition = "Text")
    private String historioFinal;

    @Temporal(TemporalType.DATE)
    private Date dataAtendimento;

    @Temporal(TemporalType.TIME)
    private Date horaAtendimento;

    @Temporal(TemporalType.DATE)
    private Date dataEncerramento;

    @Temporal(TemporalType.TIME)
    private Date horaEncerramento;

    private String numeroBoletinOcorrencia;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoChamada tipoChamada = TipoChamada.TELEFONE;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ClassificacaoChamada classificacaoChamada = ClassificacaoChamada.OCORRENCIA;

//    @NotNull
//    @Enumerated(EnumType.STRING)
//    private ClassificacaoOcorrencia classificacaoOcorrencia = ClassificacaoOcorrencia.NORMAL;
    @NotNull
    @Enumerated(EnumType.STRING)
    private SituacaoOcorrencia situacao = SituacaoOcorrencia.PENDENTE;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SimOuNao alerta = SimOuNao.NAO;

    @ManyToMany(targetEntity = PatrulhaAux.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<PatrulhaAux> patrulhas = new ArrayList<PatrulhaAux>();

    @ManyToMany(targetEntity = NaturezaOcorrencia.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<NaturezaOcorrencia> naturezas = new ArrayList<NaturezaOcorrencia>();

    @ManyToMany(targetEntity = PessoaEnvolvida.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<PessoaEnvolvida> pessoasEnvolvidas = new ArrayList<PessoaEnvolvida>();

    @ManyToMany(targetEntity = QualificacaoDeVeiculo.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<QualificacaoDeVeiculo> qualificacoesVeiculos = new ArrayList<QualificacaoDeVeiculo>();

    @ManyToMany(targetEntity = Arma.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Arma> armas = new ArrayList<Arma>();

    @ManyToMany(targetEntity = LocalIntermediarioAux.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<LocalIntermediarioAux> locaisIntermediarios = new ArrayList<LocalIntermediarioAux>();

    @ManyToMany(targetEntity = DrogaOcorrenciaItem.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<DrogaOcorrenciaItem> drogas = new ArrayList<DrogaOcorrenciaItem>();

    @ManyToMany(targetEntity = ObjetoApreendido.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ObjetoApreendido> objetos = new ArrayList<ObjetoApreendido>();

    @ManyToMany(targetEntity = Arquivo.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Arquivo> arquivos = new ArrayList<Arquivo>();

    @ManyToMany(targetEntity = ResultadoOcorrencia.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<ResultadoOcorrencia> resultados = new ArrayList<ResultadoOcorrencia>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Organizacao> getOrganizacoes() {
        return organizacoes;
    }

    public void setOrganizacoes(List<Organizacao> organizacoes) {
        this.organizacoes = organizacoes;
    }

    public List<Solicitante> getSolicitantes() {
        return solicitantes;
    }

    public void setSolicitantes(List<Solicitante> solicitantes) {
        this.solicitantes = solicitantes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getHistorioInicial() {
        return historioInicial;
    }

    public void setHistorioInicial(String historioInicial) {
        this.historioInicial = historioInicial;
    }

    public ClassificacaoChamada getClassificacaoChamada() {
        return classificacaoChamada;
    }

    public void setClassificacaoChamada(ClassificacaoChamada classificacaoChamada) {
        this.classificacaoChamada = classificacaoChamada;
    }

    public String getHistorioFinal() {
        return historioFinal;
    }

    public void setHistorioFinal(String historioFinal) {
        this.historioFinal = historioFinal;
    }

    public String getNumeroBoletinOcorrencia() {
        return numeroBoletinOcorrencia;
    }

    public void setNumeroBoletinOcorrencia(String numeroBoletinOcorrencia) {
        this.numeroBoletinOcorrencia = numeroBoletinOcorrencia;
    }

    public SituacaoOcorrencia getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoOcorrencia situacao) {
        this.situacao = situacao;
    }

    public SimOuNao getAlerta() {
        return alerta;
    }

    public void setAlerta(SimOuNao alerta) {
        this.alerta = alerta;
    }

    public List<NaturezaOcorrencia> getNaturezas() {
        return naturezas;
    }

    public void setNaturezas(List<NaturezaOcorrencia> naturezas) {
        this.naturezas = naturezas;
    }

    public List<PessoaEnvolvida> getPessoasEnvolvidas() {
        return pessoasEnvolvidas;
    }

    public void setPessoasEnvolvidas(List<PessoaEnvolvida> pessoasEnvolvidas) {
        this.pessoasEnvolvidas = pessoasEnvolvidas;
    }

    public List<QualificacaoDeVeiculo> getQualificacoesVeiculos() {
        return qualificacoesVeiculos;
    }

    public void setQualificacoesVeiculos(List<QualificacaoDeVeiculo> qualificacoesVeiculos) {
        this.qualificacoesVeiculos = qualificacoesVeiculos;
    }

    public List<Arma> getArmas() {
        return armas;
    }

    public void setArmas(List<Arma> armas) {
        this.armas = armas;
    }

    public List<LocalIntermediarioAux> getLocaisIntermediarios() {
        return locaisIntermediarios;
    }

    public void setLocaisIntermediarios(List<LocalIntermediarioAux> locaisIntermediarios) {
        this.locaisIntermediarios = locaisIntermediarios;
    }

    public List<DrogaOcorrenciaItem> getDrogas() {
        return drogas;
    }

    public void setDrogas(List<DrogaOcorrenciaItem> drogas) {
        this.drogas = drogas;
    }

    public List<ObjetoApreendido> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<ObjetoApreendido> objetos) {
        this.objetos = objetos;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public List<ResultadoOcorrencia> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoOcorrencia> resultados) {
        this.resultados = resultados;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public List<PatrulhaAux> getPatrulhas() {
        return patrulhas;
    }

    public void setPatrulhas(List<PatrulhaAux> patrulhas) {
        this.patrulhas = patrulhas;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Date getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(Date horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Date getHoraEncerramento() {
        return horaEncerramento;
    }

    public void setHoraEncerramento(Date horaEncerramento) {
        this.horaEncerramento = horaEncerramento;
    }

    public TipoChamada getTipoChamada() {
        return tipoChamada;
    }

    public void setTipoChamada(TipoChamada tipoChamada) {
        this.tipoChamada = tipoChamada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ocorrencia other = (Ocorrencia) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
