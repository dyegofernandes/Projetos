/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.salvavidas.modelo.denuncia;

import br.gov.pi.ati.salvavidas.modelo.cadastro.AutorDenuncia;
import br.gov.pi.ati.salvavidas.modelo.cadastro.Denunciado;
import br.gov.pi.ati.salvavidas.modelo.cadastro.Vitima;
import br.gov.pi.ati.salvavidas.modelo.enums.Anonimo;
import br.gov.pi.ati.salvavidas.modelo.enums.Situacao;
import br.gov.pi.ati.salvavidas.modelo.enums.Tipo;
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
public class Denuncia implements Serializable {

    @Id
    @SequenceGenerator(name = "Denuncia", sequenceName = "seq_denuncia")
    @GeneratedValue(generator = "Denuncia")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AutorDenuncia autoDenuncia = new AutorDenuncia();

    @Column(columnDefinition = "Text")
    private String descricao;

    @Column(columnDefinition = "Text")
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

//    @NotNull
//    @Enumerated(EnumType.STRING)
    private Anonimo anomino = Anonimo.SIM;

    @Enumerated(EnumType.STRING)
    private Tipo tipo = Tipo.DENUNCIA;

    @ManyToMany(targetEntity = Vitima.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Vitima> vitimas = new ArrayList<Vitima>();

    @ManyToMany(targetEntity = Denunciado.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Denunciado> denunciados = new ArrayList<Denunciado>();

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

    public List<Vitima> getVitimas() {
        return vitimas;
    }

    public void setVitimas(List<Vitima> vitimas) {
        this.vitimas = vitimas;
    }

    public List<Denunciado> getDenunciados() {
        return denunciados;
    }

    public void setDenunciados(List<Denunciado> denunciados) {
        this.denunciados = denunciados;
    }

    public Anonimo getAnomino() {
        return anomino;
    }

    public void setAnomino(Anonimo anomino) {
        this.anomino = anomino;
    }

    public AutorDenuncia getAutoDenuncia() {
        return autoDenuncia;
    }

    public void setAutoDenuncia(AutorDenuncia autoDenuncia) {
        this.autoDenuncia = autoDenuncia;
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
