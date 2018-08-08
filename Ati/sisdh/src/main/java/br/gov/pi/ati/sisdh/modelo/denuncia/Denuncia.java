
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.sisdh.modelo.denuncia;

import br.gov.pi.ati.sisdh.modelo.cadastro.Endereco;
import br.gov.pi.ati.sisdh.modelo.cadastro.GrupoDeViolacao;
import br.gov.pi.ati.sisdh.modelo.cadastro.NaturezaDaViolacao;
import br.gov.pi.ati.sisdh.modelo.cadastro.Unidade;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.IdentidadeGenero;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.OrientacaoSexual;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Raca;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Sexo;
import br.gov.pi.ati.sisdh.modelo.cadastro.enums.Situacao;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Juniel
 */
@Entity
public class Denuncia implements Serializable, Comparable<Denuncia> {

    @Id
    @SequenceGenerator(name = "Denuncia", sequenceName = "seq_denuncia")
    @GeneratedValue(generator = "Denuncia")
    private Long id;

    @Size(max = 100)
    private String protocolo;

    @Size(max = 100)
    private String numeroDenuncia;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private GrupoDeViolacao grupoDeViolacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private NaturezaDaViolacao naturezaDaViolacao;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDenuncia;

    @Size(max = 480)
    private String relatoDoDenunciante;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Endereco enderecoDenuncia = new Endereco();

    @Size(max = 250)
    @NotBlank
    private String nomeVitima;

    @Size(max = 250)
    private String nomeSocialVitima;

    private Integer idadeVitima;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Sexo sexoDaVitima;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Raca racaoCorDaVitima;

    @Size(max = 50)
    private String telefoneVitima;
    
    @Enumerated(EnumType.STRING)
    private OrientacaoSexual orientacaoSexualVitima;
    
    @Enumerated(EnumType.STRING)
    private IdentidadeGenero identidadeDeGeneroVitima;

    @Size(max = 250)
    @NotBlank
    private String nomeSuspeito;

    @Size(max = 250)
    private String nomeSocialSuspeito;

    private Integer idadeSuspeito;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Sexo sexoDaSuspeito;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Raca racaoCorDaSuspeito;

    @Size(max = 50)
    private String telefoneSuspeito;
    
     @Enumerated(EnumType.STRING)
    private OrientacaoSexual orientacaoSexualSuspeito;
    
    @Enumerated(EnumType.STRING)
    private IdentidadeGenero identidadeDeGeneroSuspeito;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "Só pode cadastrar uma Denúncia usuários que estiverem ligados a uma Unidade!!")
    private Unidade unidadeOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Unidade unidadeResponsavel;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.NOVA;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataProcedimento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDeEncerramento;

    @Column(columnDefinition = "Text")
    private String descricaoAtendimento;

    @ManyToMany(targetEntity = Arquivo.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Arquivo> arquivos = new ArrayList<Arquivo>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDenuncia() {
        return dataDenuncia;
    }

    public void setDataDenuncia(Date dataDenuncia) {
        this.dataDenuncia = dataDenuncia;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public String getDescricaoAtendimento() {
        return descricaoAtendimento;
    }

    public void setDescricaoAtendimento(String descricaoAtendimento) {
        this.descricaoAtendimento = descricaoAtendimento;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public Integer getIdadeVitima() {
        return idadeVitima;
    }

    public void setIdadeVitima(Integer idadeVitima) {
        this.idadeVitima = idadeVitima;
    }

    public Unidade getUnidadeOrigem() {
        return unidadeOrigem;
    }

    public void setUnidadeOrigem(Unidade unidadeOrigem) {
        this.unidadeOrigem = unidadeOrigem;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getNumeroDenuncia() {
        return numeroDenuncia;
    }

    public void setNumeroDenuncia(String numeroDenuncia) {
        this.numeroDenuncia = numeroDenuncia;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public GrupoDeViolacao getGrupoDeViolacao() {
        return grupoDeViolacao;
    }

    public void setGrupoDeViolacao(GrupoDeViolacao grupoDeViolacao) {
        this.grupoDeViolacao = grupoDeViolacao;
    }

    public NaturezaDaViolacao getNaturezaDaViolacao() {
        return naturezaDaViolacao;
    }

    public void setNaturezaDaViolacao(NaturezaDaViolacao naturezaDaViolacao) {
        this.naturezaDaViolacao = naturezaDaViolacao;
    }

    public String getRelatoDoDenunciante() {
        return relatoDoDenunciante;
    }

    public void setRelatoDoDenunciante(String relatoDoDenunciante) {
        this.relatoDoDenunciante = relatoDoDenunciante;
    }

    public Endereco getEnderecoDenuncia() {
        return enderecoDenuncia;
    }

    public void setEnderecoDenuncia(Endereco enderecoDenuncia) {
        this.enderecoDenuncia = enderecoDenuncia;
    }

    public String getNomeVitima() {
        return nomeVitima;
    }

    public void setNomeVitima(String nomeVitima) {
        this.nomeVitima = nomeVitima;
    }

    public String getNomeSocialVitima() {
        return nomeSocialVitima;
    }

    public void setNomeSocialVitima(String nomeSocialVitima) {
        this.nomeSocialVitima = nomeSocialVitima;
    }

    public Sexo getSexoDaVitima() {
        return sexoDaVitima;
    }

    public void setSexoDaVitima(Sexo sexoDaVitima) {
        this.sexoDaVitima = sexoDaVitima;
    }

    public Raca getRacaoCorDaVitima() {
        return racaoCorDaVitima;
    }

    public void setRacaoCorDaVitima(Raca racaoCorDaVitima) {
        this.racaoCorDaVitima = racaoCorDaVitima;
    }

    public String getTelefoneVitima() {
        return telefoneVitima;
    }

    public void setTelefoneVitima(String telefoneVitima) {
        this.telefoneVitima = telefoneVitima;
    }

    public String getNomeSuspeito() {
        return nomeSuspeito;
    }

    public void setNomeSuspeito(String nomeSuspeito) {
        this.nomeSuspeito = nomeSuspeito;
    }

    public String getNomeSocialSuspeito() {
        return nomeSocialSuspeito;
    }

    public void setNomeSocialSuspeito(String nomeSocialSuspeito) {
        this.nomeSocialSuspeito = nomeSocialSuspeito;
    }

    public Integer getIdadeSuspeito() {
        return idadeSuspeito;
    }

    public void setIdadeSuspeito(Integer idadeSuspeito) {
        this.idadeSuspeito = idadeSuspeito;
    }

    public Sexo getSexoDaSuspeito() {
        return sexoDaSuspeito;
    }

    public void setSexoDaSuspeito(Sexo sexoDaSuspeito) {
        this.sexoDaSuspeito = sexoDaSuspeito;
    }

    public Raca getRacaoCorDaSuspeito() {
        return racaoCorDaSuspeito;
    }

    public void setRacaoCorDaSuspeito(Raca racaoCorDaSuspeito) {
        this.racaoCorDaSuspeito = racaoCorDaSuspeito;
    }

    public String getTelefoneSuspeito() {
        return telefoneSuspeito;
    }

    public void setTelefoneSuspeito(String telefoneSuspeito) {
        this.telefoneSuspeito = telefoneSuspeito;
    }

    public Date getDataProcedimento() {
        return dataProcedimento;
    }

    public void setDataProcedimento(Date dataProcedimento) {
        this.dataProcedimento = dataProcedimento;
    }

    public Date getDataDeEncerramento() {
        return dataDeEncerramento;
    }

    public void setDataDeEncerramento(Date dataDeEncerramento) {
        this.dataDeEncerramento = dataDeEncerramento;
    }

    public Unidade getUnidadeResponsavel() {
        return unidadeResponsavel;
    }

    public void setUnidadeResponsavel(Unidade unidadeResponsavel) {
        this.unidadeResponsavel = unidadeResponsavel;
    }

    public OrientacaoSexual getOrientacaoSexualVitima() {
        return orientacaoSexualVitima;
    }

    public void setOrientacaoSexualVitima(OrientacaoSexual orientacaoSexualVitima) {
        this.orientacaoSexualVitima = orientacaoSexualVitima;
    }

    public IdentidadeGenero getIdentidadeDeGeneroVitima() {
        return identidadeDeGeneroVitima;
    }

    public void setIdentidadeDeGeneroVitima(IdentidadeGenero identidadeDeGeneroVitima) {
        this.identidadeDeGeneroVitima = identidadeDeGeneroVitima;
    }

    public OrientacaoSexual getOrientacaoSexualSuspeito() {
        return orientacaoSexualSuspeito;
    }

    public void setOrientacaoSexualSuspeito(OrientacaoSexual orientacaoSexualSuspeito) {
        this.orientacaoSexualSuspeito = orientacaoSexualSuspeito;
    }

    public IdentidadeGenero getIdentidadeDeGeneroSuspeito() {
        return identidadeDeGeneroSuspeito;
    }

    public void setIdentidadeDeGeneroSuspeito(IdentidadeGenero identidadeDeGeneroSuspeito) {
        this.identidadeDeGeneroSuspeito = identidadeDeGeneroSuspeito;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Denuncia other = (Denuncia) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Denuncia den) {
        return this.id.compareTo(den.id);
    }

}
