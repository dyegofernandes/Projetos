/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.salvemaria.modelo.denuncia;

import br.gov.pi.salvemaria.modelo.cadastro.Endereco;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import br.gov.pi.salvemaria.modelo.enums.Demandante;
import br.gov.pi.salvemaria.modelo.enums.FormasDeViolencia;
import br.gov.pi.salvemaria.modelo.enums.Situacao;
import br.gov.pi.salvemaria.modelo.enums.TipoDenuncia;
import br.gov.pi.salvemaria.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @ManyToOne(fetch = FetchType.LAZY)
//    @NotNull
    private Unidade unidade;

    @Size(max = 480)
    private String descricao;

    @Size(max = 400)
    private String observacao;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataDenuncia = new Date();

    @NotNull
    @Temporal(TemporalType.TIME)
    private Date horaDenuncia = new Date();

    @Temporal(TemporalType.DATE)
    private Date dataAtendimento;

    @Temporal(TemporalType.TIME)
    private Date horaAtendimento;

    @Temporal(TemporalType.DATE)
    private Date dataDeFechamento;

    @Temporal(TemporalType.TIME)
    private Date horaDeFechamento;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotNull
    private Endereco endereco = new Endereco();

    @NotNull
    private FormasDeViolencia formaDeViolencia = FormasDeViolencia.FISICA;

    @NotNull
    private Situacao situacao = Situacao.NOVA;

    @Column(columnDefinition = "Text")
    private String descricaoAtendimento;

    @Size(max = 100)
    private String vitima;

    private Integer idadeVitima;

    private String cpfVitima;

    private String rgVitima;

    private String cnhVitima;

    private String racaVitima;

    private String parentescoVitima;

    private String caracteriscasVitima;

    @Size(max = 100)
    private String agressor;

    private Integer idadeAgressor;

    private String cpfAgressor;

    private String rgAgressor;

    private String cnhAgressor;

    private String caracteriscasAgressor;

    private String racaAgressor;

    private String parentescoAgressor;

    @NotNull
    private Demandante demandante = Demandante.ANONIMO;

    @NotNull
    private TipoDenuncia tipo = TipoDenuncia.DENUNCIA;

    private String imei;

    private String cpfUsuario;
    
    private String so;

    @ManyToMany(targetEntity = Arquivo.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Arquivo> arquivos = new ArrayList<Arquivo>();

//    @NotAudited
//    @OneToMany(mappedBy = "denuncia")
//    private List<Arquivo> arquivos;
    
    @Override
    public String toString() {
        return descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
//        if(descricao!=null){
//            descricao = descricao.trim().toUpperCase();
//        }
        this.descricao = descricao;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
//        if(observacao!=null){
//            observacao = observacao.trim().toUpperCase();
//        }
        this.observacao = observacao;
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

    public Date getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(Date horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

    public Date getDataDeFechamento() {
        return dataDeFechamento;
    }

    public void setDataDeFechamento(Date dataDeFechamento) {
        this.dataDeFechamento = dataDeFechamento;
    }

    public Date getHoraDeFechamento() {
        return horaDeFechamento;
    }

    public void setHoraDeFechamento(Date horaDeFechamento) {
        this.horaDeFechamento = horaDeFechamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getVitima() {
        return vitima;
    }

    public void setVitima(String vitima) {
//        if(vitima!=null){
//            vitima = vitima.trim().toUpperCase();
//        }
        this.vitima = vitima;
    }

    public Integer getIdadeVitima() {
        return idadeVitima;
    }

    public void setIdadeVitima(Integer idadeVitima) {
        this.idadeVitima = idadeVitima;
    }

    public String getAgressor() {
        return agressor;
    }

    public void setAgressor(String agressor) {
//        if(agressor!=null){
//            agressor = agressor.trim().toUpperCase();
//        }
        this.agressor = agressor;
    }

    public Integer getIdadeAgressor() {
        return idadeAgressor;
    }

    public void setIdadeAgressor(Integer idadeAgressor) {
        this.idadeAgressor = idadeAgressor;
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

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
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

    public String getCaracteriscasVitima() {
        return caracteriscasVitima;
    }

    public void setCaracteriscasVitima(String caracteriscasVitima) {
        this.caracteriscasVitima = caracteriscasVitima;
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

    public String getCaracteriscasAgressor() {
        return caracteriscasAgressor;
    }

    public void setCaracteriscasAgressor(String caracteriscasAgressor) {
        this.caracteriscasAgressor = caracteriscasAgressor;
    }

    public String getRacaVitima() {
        return racaVitima;
    }

    public void setRacaVitima(String racaVitima) {
        this.racaVitima = racaVitima;
    }

    public String getRacaAgressor() {
        return racaAgressor;
    }

    public void setRacaAgressor(String racaAgressor) {
        this.racaAgressor = racaAgressor;
    }

    public String getParentescoVitima() {
        return parentescoVitima;
    }

    public void setParentescoVitima(String parentescoVitima) {
        this.parentescoVitima = parentescoVitima;
    }

    public String getParentescoAgressor() {
        return parentescoAgressor;
    }

    public void setParentescoAgressor(String parentescoAgressor) {
        this.parentescoAgressor = parentescoAgressor;
    }

    public Long getTempoAtendimento() {
        Date dataInicial = Utils.getDataComHora(dataDenuncia, horaDenuncia);
        Date dataFinal = Utils.getDataComHora(dataAtendimento, horaAtendimento);

        return Utils.getTempoAtendimentoEmMinutos(dataInicial, dataFinal);

    }

    public Long getTempoEncerramento() {
        Date dataInicial = Utils.getDataComHora(dataDenuncia, horaDenuncia);
        Date dataFinal = Utils.getDataComHora(dataDeFechamento, horaDeFechamento);

        return Utils.getTempoAtendimentoEmMinutos(dataInicial, dataFinal);

    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
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
