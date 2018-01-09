/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisforms.modelo.formulario;

import br.gov.pi.ati.sisforms.modelo.enums.Adulto;
import br.gov.pi.ati.sisforms.modelo.enums.FormasDeViolencia;
import br.gov.pi.ati.sisforms.modelo.enums.LgbtSituacaoViolencia;
import br.gov.pi.ati.sisforms.modelo.enums.SimOuNao;
import br.gov.pi.ati.sisforms.modelo.enums.SituacaoDeRua;
import br.gov.pi.ati.sisforms.modelo.enums.TipoViolencia;
import br.gov.pi.ati.sisforms.modelo.enums.UsoDeDrogas;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class FormularioDeDenunciaLGBT implements Serializable {

    @Id
    @SequenceGenerator(name = "FormularioDeDenunciaLGBT", sequenceName = "seq_formularioDeDenunciaLGBT")
    @GeneratedValue(generator = "FormularioDeDenunciaLGBT")
    private Long id;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataDenuncia = new Date();

    @Temporal(TemporalType.TIME)
    @NotNull
    private Date horaDenuncia = new Date();

    private String denunciaReincidente;

    private String nomeSocial;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PessoaDenuncia identificacaoVitima = new PessoaDenuncia();

    private String localDaViolacao;

    private String tempoQueOcorreViolacao;

    private SituacaoDeRua situacaoDeRua;

    private String situacaoDeRuaOutros;

    private TipoViolencia idosoTipoViolencia;

    private FormasDeViolencia idosoFormaViolencia;

    private String idosoFormaViolenciaOutros;

    private TipoViolencia criancaTipoViolencia;

    private FormasDeViolencia criancaFormaViolencia;

    private String criancaFormaViolenciaOutros;

    private TipoViolencia adolescenteTipoViolencia;

    private FormasDeViolencia adolescenteFormaViolencia;

    private String adolescenteFormaViolenciaOutros;

    private TipoViolencia jovemTipoViolencia;

    private FormasDeViolencia jovemFormaViolencia;

    private String jovemFormaViolenciaOutros;

    private Adulto adulto;

    private TipoViolencia adultoTipoViolencia;

    private FormasDeViolencia adultoFormaViolencia;

    private String adultoFormaViolenciaOutros;

    private TipoViolencia pCDTipoViolencia;

    private FormasDeViolencia pCDFormaViolencia;

    private String pCDFormaViolenciaOutros;

    private UsoDeDrogas usoSubstanciaPsicoativa;
    
    private String usoSubstanciaPsicoativaOutros;

    private LgbtSituacaoViolencia lGBtSituacaoViolencia;

    private String lGBtSituacaoViolenciaOutros;

    private String outrasViolacoesDireitosHumanos;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PessoaDenuncia pessoaDenunciada = new PessoaDenuncia();

    private UsoDeDrogas perfilPessoaDenunciada;

    private String perfilPessoaDenunciadaOutras;

    private String ocupacao;

    private String escolaridade;

    private String parentescoComAVitima;

    private SimOuNao antecedentesCriminais = SimOuNao.NAO;
    
    private String antecedentesCriminaisSim;

    @Column(columnDefinition = "Text")
    private String relatoDaDenuncia;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PessoaDenuncia pessoaDenunciante = new PessoaDenuncia();

    private SimOuNao anonimo = SimOuNao.NAO;

    @Column(columnDefinition = "Text")
    private String providencias;

    @Column(columnDefinition = "Text")
    private String contraReferencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public Date getDataDenuncia() {
        return dataDenuncia;
    }

    public void setDataDenuncia(Date dataDenuncia) {
        this.dataDenuncia = dataDenuncia;
    }

    public Date getHoraDenuncia() {
        return horaDenuncia;
    }

    public void setHoraDenuncia(Date horaDenuncia) {
        this.horaDenuncia = horaDenuncia;
    }

    public String getDenunciaReincidente() {
        return denunciaReincidente;
    }

    public void setDenunciaReincidente(String denunciaReincidente) {
        this.denunciaReincidente = denunciaReincidente;
    }

    public PessoaDenuncia getIdentificacaoVitima() {
        return identificacaoVitima;
    }

    public void setIdentificacaoVitima(PessoaDenuncia identificacaoVitima) {
        this.identificacaoVitima = identificacaoVitima;
    }

    public String getLocalDaViolacao() {
        return localDaViolacao;
    }

    public void setLocalDaViolacao(String localDaViolacao) {
        this.localDaViolacao = localDaViolacao;
    }

    public String getTempoQueOcorreViolacao() {
        return tempoQueOcorreViolacao;
    }

    public void setTempoQueOcorreViolacao(String tempoQueOcorreViolacao) {
        this.tempoQueOcorreViolacao = tempoQueOcorreViolacao;
    }

    public SituacaoDeRua getSituacaoDeRua() {
        return situacaoDeRua;
    }

    public void setSituacaoDeRua(SituacaoDeRua situacaoDeRua) {
        this.situacaoDeRua = situacaoDeRua;
    }

    public String getSituacaoDeRuaOutros() {
        return situacaoDeRuaOutros;
    }

    public void setSituacaoDeRuaOutros(String situacaoDeRuaOutros) {
        this.situacaoDeRuaOutros = situacaoDeRuaOutros;
    }

    public TipoViolencia getIdosoTipoViolencia() {
        return idosoTipoViolencia;
    }

    public void setIdosoTipoViolencia(TipoViolencia idosoTipoViolencia) {
        this.idosoTipoViolencia = idosoTipoViolencia;
    }

    public FormasDeViolencia getIdosoFormaViolencia() {
        return idosoFormaViolencia;
    }

    public void setIdosoFormaViolencia(FormasDeViolencia idosoFormaViolencia) {
        this.idosoFormaViolencia = idosoFormaViolencia;
    }

    public String getIdosoFormaViolenciaOutros() {
        return idosoFormaViolenciaOutros;
    }

    public void setIdosoFormaViolenciaOutros(String idosoFormaViolenciaOutros) {
        this.idosoFormaViolenciaOutros = idosoFormaViolenciaOutros;
    }

    public TipoViolencia getCriancaTipoViolencia() {
        return criancaTipoViolencia;
    }

    public void setCriancaTipoViolencia(TipoViolencia criancaTipoViolencia) {
        this.criancaTipoViolencia = criancaTipoViolencia;
    }

    public FormasDeViolencia getCriancaFormaViolencia() {
        return criancaFormaViolencia;
    }

    public void setCriancaFormaViolencia(FormasDeViolencia criancaFormaViolencia) {
        this.criancaFormaViolencia = criancaFormaViolencia;
    }

    public String getCriancaFormaViolenciaOutros() {
        return criancaFormaViolenciaOutros;
    }

    public void setCriancaFormaViolenciaOutros(String criancaFormaViolenciaOutros) {
        this.criancaFormaViolenciaOutros = criancaFormaViolenciaOutros;
    }

    public TipoViolencia getAdolescenteTipoViolencia() {
        return adolescenteTipoViolencia;
    }

    public void setAdolescenteTipoViolencia(TipoViolencia adolescenteTipoViolencia) {
        this.adolescenteTipoViolencia = adolescenteTipoViolencia;
    }

    public FormasDeViolencia getAdolescenteFormaViolencia() {
        return adolescenteFormaViolencia;
    }

    public void setAdolescenteFormaViolencia(FormasDeViolencia adolescenteFormaViolencia) {
        this.adolescenteFormaViolencia = adolescenteFormaViolencia;
    }

    public String getAdolescenteFormaViolenciaOutros() {
        return adolescenteFormaViolenciaOutros;
    }

    public void setAdolescenteFormaViolenciaOutros(String adolescenteFormaViolenciaOutros) {
        this.adolescenteFormaViolenciaOutros = adolescenteFormaViolenciaOutros;
    }

    public TipoViolencia getJovemTipoViolencia() {
        return jovemTipoViolencia;
    }

    public void setJovemTipoViolencia(TipoViolencia jovemTipoViolencia) {
        this.jovemTipoViolencia = jovemTipoViolencia;
    }

    public FormasDeViolencia getJovemFormaViolencia() {
        return jovemFormaViolencia;
    }

    public void setJovemFormaViolencia(FormasDeViolencia jovemFormaViolencia) {
        this.jovemFormaViolencia = jovemFormaViolencia;
    }

    public String getJovemFormaViolenciaOutros() {
        return jovemFormaViolenciaOutros;
    }

    public void setJovemFormaViolenciaOutros(String jovemFormaViolenciaOutros) {
        this.jovemFormaViolenciaOutros = jovemFormaViolenciaOutros;
    }

    public Adulto getAdulto() {
        return adulto;
    }

    public void setAdulto(Adulto adulto) {
        this.adulto = adulto;
    }

    public TipoViolencia getAdultoTipoViolencia() {
        return adultoTipoViolencia;
    }

    public void setAdultoTipoViolencia(TipoViolencia adultoTipoViolencia) {
        this.adultoTipoViolencia = adultoTipoViolencia;
    }

    public FormasDeViolencia getAdultoFormaViolencia() {
        return adultoFormaViolencia;
    }

    public void setAdultoFormaViolencia(FormasDeViolencia adultoFormaViolencia) {
        this.adultoFormaViolencia = adultoFormaViolencia;
    }

    public String getAdultoFormaViolenciaOutros() {
        return adultoFormaViolenciaOutros;
    }

    public void setAdultoFormaViolenciaOutros(String adultoFormaViolenciaOutros) {
        this.adultoFormaViolenciaOutros = adultoFormaViolenciaOutros;
    }

    public TipoViolencia getpCDTipoViolencia() {
        return pCDTipoViolencia;
    }

    public void setpCDTipoViolencia(TipoViolencia pCDTipoViolencia) {
        this.pCDTipoViolencia = pCDTipoViolencia;
    }

    public FormasDeViolencia getpCDFormaViolencia() {
        return pCDFormaViolencia;
    }

    public void setpCDFormaViolencia(FormasDeViolencia pCDFormaViolencia) {
        this.pCDFormaViolencia = pCDFormaViolencia;
    }

    public String getpCDFormaViolenciaOutros() {
        return pCDFormaViolenciaOutros;
    }

    public void setpCDFormaViolenciaOutros(String pCDFormaViolenciaOutros) {
        this.pCDFormaViolenciaOutros = pCDFormaViolenciaOutros;
    }

    public UsoDeDrogas getUsoSubstanciaPsicoativa() {
        return usoSubstanciaPsicoativa;
    }

    public void setUsoSubstanciaPsicoativa(UsoDeDrogas usoSubstanciaPsicoativa) {
        this.usoSubstanciaPsicoativa = usoSubstanciaPsicoativa;
    }

    public LgbtSituacaoViolencia getlGBtSituacaoViolencia() {
        return lGBtSituacaoViolencia;
    }

    public void setlGBtSituacaoViolencia(LgbtSituacaoViolencia lGBtSituacaoViolencia) {
        this.lGBtSituacaoViolencia = lGBtSituacaoViolencia;
    }

    public String getlGBtSituacaoViolenciaOutros() {
        return lGBtSituacaoViolenciaOutros;
    }

    public void setlGBtSituacaoViolenciaOutros(String lGBtSituacaoViolenciaOutros) {
        this.lGBtSituacaoViolenciaOutros = lGBtSituacaoViolenciaOutros;
    }

    public String getOutrasViolacoesDireitosHumanos() {
        return outrasViolacoesDireitosHumanos;
    }

    public void setOutrasViolacoesDireitosHumanos(String outrasViolacoesDireitosHumanos) {
        this.outrasViolacoesDireitosHumanos = outrasViolacoesDireitosHumanos;
    }

    public PessoaDenuncia getPessoaDenunciada() {
        return pessoaDenunciada;
    }

    public void setPessoaDenunciada(PessoaDenuncia pessoaDenunciada) {
        this.pessoaDenunciada = pessoaDenunciada;
    }

    public UsoDeDrogas getPerfilPessoaDenunciada() {
        return perfilPessoaDenunciada;
    }

    public void setPerfilPessoaDenunciada(UsoDeDrogas perfilPessoaDenunciada) {
        this.perfilPessoaDenunciada = perfilPessoaDenunciada;
    }

    public String getPerfilPessoaDenunciadaOutras() {
        return perfilPessoaDenunciadaOutras;
    }

    public void setPerfilPessoaDenunciadaOutras(String perfilPessoaDenunciadaOutras) {
        this.perfilPessoaDenunciadaOutras = perfilPessoaDenunciadaOutras;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getParentescoComAVitima() {
        return parentescoComAVitima;
    }

    public void setParentescoComAVitima(String parentescoComAVitima) {
        this.parentescoComAVitima = parentescoComAVitima;
    }

    public SimOuNao getAntecedentesCriminais() {
        return antecedentesCriminais;
    }

    public void setAntecedentesCriminais(SimOuNao antecedentesCriminais) {
        this.antecedentesCriminais = antecedentesCriminais;
    }

    public String getAntecedentesCriminaisSim() {
        return antecedentesCriminaisSim;
    }

    public void setAntecedentesCriminaisSim(String antecedentesCriminaisSim) {
        this.antecedentesCriminaisSim = antecedentesCriminaisSim;
    }

    public String getRelatoDaDenuncia() {
        return relatoDaDenuncia;
    }

    public void setRelatoDaDenuncia(String relatoDaDenuncia) {
        this.relatoDaDenuncia = relatoDaDenuncia;
    }

    public PessoaDenuncia getPessoaDenunciante() {
        return pessoaDenunciante;
    }

    public void setPessoaDenunciante(PessoaDenuncia pessoaDenunciante) {
        this.pessoaDenunciante = pessoaDenunciante;
    }

    public SimOuNao getAnonimo() {
        return anonimo;
    }

    public void setAnonimo(SimOuNao anonimo) {
        this.anonimo = anonimo;
    }

    public String getProvidencias() {
        return providencias;
    }

    public void setProvidencias(String providencias) {
        this.providencias = providencias;
    }

    public String getContraReferencia() {
        return contraReferencia;
    }

    public void setContraReferencia(String contraReferencia) {
        this.contraReferencia = contraReferencia;
    }

    public String getUsoSubstanciaPsicoativaOutros() {
        return usoSubstanciaPsicoativaOutros;
    }

    public void setUsoSubstanciaPsicoativaOutros(String usoSubstanciaPsicoativaOutros) {
        this.usoSubstanciaPsicoativaOutros = usoSubstanciaPsicoativaOutros;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final FormularioDeDenunciaLGBT other = (FormularioDeDenunciaLGBT) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
