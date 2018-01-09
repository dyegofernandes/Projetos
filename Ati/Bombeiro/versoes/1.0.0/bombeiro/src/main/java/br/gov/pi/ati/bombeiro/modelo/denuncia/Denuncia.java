/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.bombeiro.modelo.denuncia;

import br.gov.pi.ati.bombeiro.modelo.enums.Situacao;
import br.gov.pi.ati.bombeiro.modelo.enums.Tipo;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Juniel
 */
@Entity
public class Denuncia implements Serializable {

    @Id
    @SequenceGenerator(name = "Denuncia", sequenceName = "seq_denuncia")
    @GeneratedValue(generator = "Denuncia")
    private Long id;

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

    @Column(columnDefinition = "Text")
    private String descricaoAtendimento;

    private String imei;

    private String cpfUsuario;

    @Size(max = 100)
    private String nomeDenunciado;

    private Integer idadeDenunciado;

    private String cpfDenunciado;

    private String rgDenunciado;

    private String cnhDenunciado;

    private String caracteristicasDenunciado;

    private String racaDenunciado;

    @Enumerated(EnumType.STRING)
    private Tipo tipo = Tipo.DENUNCIA;

    @ManyToMany(targetEntity = Arquivo.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Arquivo> arquivos = new ArrayList<Arquivo>();

    @NotNull
    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.NOVA;

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
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
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

    public String getDescricaoAtendimento() {
        return descricaoAtendimento;
    }

    public void setDescricaoAtendimento(String descricaoAtendimento) {
        this.descricaoAtendimento = descricaoAtendimento;
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

    public String getNomeDenunciado() {
        return nomeDenunciado;
    }

    public void setNomeDenunciado(String nomeDenunciado) {
        this.nomeDenunciado = nomeDenunciado;
    }

    public Integer getIdadeDenunciado() {
        return idadeDenunciado;
    }

    public void setIdadeDenunciado(Integer idadeDenunciado) {
        this.idadeDenunciado = idadeDenunciado;
    }

    public String getCpfDenunciado() {
        return cpfDenunciado;
    }

    public void setCpfDenunciado(String cpfDenunciado) {
        this.cpfDenunciado = cpfDenunciado;
    }

    public String getRgDenunciado() {
        return rgDenunciado;
    }

    public void setRgDenunciado(String rgDenunciado) {
        this.rgDenunciado = rgDenunciado;
    }

    public String getCnhDenunciado() {
        return cnhDenunciado;
    }

    public void setCnhDenunciado(String cnhDenunciado) {
        this.cnhDenunciado = cnhDenunciado;
    }

    public String getCaracteristicasDenunciado() {
        return caracteristicasDenunciado;
    }

    public void setCaracteristicasDenunciado(String caracteristicasDenunciado) {
        this.caracteristicasDenunciado = caracteristicasDenunciado;
    }

    public String getRacaDenunciado() {
        return racaDenunciado;
    }

    public void setRacaDenunciado(String racaDenunciado) {
        this.racaDenunciado = racaDenunciado;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
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

}
