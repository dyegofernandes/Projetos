/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.ati.siopm.modelo.cadastro;

import br.gov.pi.ati.siopm.modelo.enums.ModalidadePoliciamento;
import br.gov.pi.ati.siopm.modelo.enums.StatusViaturaEnum;
import com.xpert.audit.NotAudited;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Patrulha implements Serializable {

    @Id
    @SequenceGenerator(name = "Patrulha", sequenceName = "patrulha_id_seq")
    @GeneratedValue(generator = "Patrulha")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Opm opm;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Viatura viatura;

    @Size(max = 250)
    @NotBlank
    private String nome;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date inicioTurno = new Date();

    @Temporal(TemporalType.TIME)
    @NotNull
    private Date inicioHoraTurno = new Date();

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date fimTurno = new Date();

    @Temporal(TemporalType.TIME)
    @NotNull
    private Date fimHoraTurno = new Date();

    private String imei;

    @ManyToMany(targetEntity = PatrulhaLocalizacao.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<PatrulhaLocalizacao> localizacao = new ArrayList<PatrulhaLocalizacao>();

    private String telefone;

    private ModalidadePoliciamento modalidadePoliciamento;

    @NotNull
    private StatusViaturaEnum status = StatusViaturaEnum.DISPONIVEL;

    @ManyToMany(targetEntity = GuarnicaoViatura.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<GuarnicaoViatura> guarnicoes = new ArrayList<GuarnicaoViatura>();

    @NotAudited
    @OneToMany(mappedBy = "patrulha")
    private List<PatrulhaAux> patrulhasAuxs;

    private boolean ativo = true;

    public Viatura getViatura() {
        return viatura;
    }

    public Opm getOpm() {
        return opm;
    }

    public void setOpm(Opm opm) {
        this.opm = opm;
    }

    public void setViatura(Viatura viatura) {
        this.viatura = viatura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInicioTurno() {
        return inicioTurno;
    }

    public void setInicioTurno(Date inicioTurno) {
        this.inicioTurno = inicioTurno;
    }

    public Date getInicioHoraTurno() {
        return inicioHoraTurno;
    }

    public void setInicioHoraTurno(Date inicioHoraTurno) {
        this.inicioHoraTurno = inicioHoraTurno;
    }

    public Date getFimTurno() {
        return fimTurno;
    }

    public void setFimTurno(Date fimTurno) {
        this.fimTurno = fimTurno;
    }

    public Date getFimHoraTurno() {
        return fimHoraTurno;
    }

    public void setFimHoraTurno(Date fimHoraTurno) {
        this.fimHoraTurno = fimHoraTurno;
    }

    public List<GuarnicaoViatura> getGuarnicoes() {
        return guarnicoes;
    }

    public void setGuarnicoes(List<GuarnicaoViatura> guarnicoes) {
        this.guarnicoes = guarnicoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ModalidadePoliciamento getModalidadePoliciamento() {
        return modalidadePoliciamento;
    }

    public void setModalidadePoliciamento(ModalidadePoliciamento modalidadePoliciamento) {
        this.modalidadePoliciamento = modalidadePoliciamento;
    }

    public StatusViaturaEnum getStatus() {
        return status;
    }

    public void setStatus(StatusViaturaEnum status) {
        this.status = status;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<PatrulhaLocalizacao> getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(List<PatrulhaLocalizacao> localizacao) {
        this.localizacao = localizacao;
    }

    public List<PatrulhaAux> getPatrulhasAuxs() {
        return patrulhasAuxs;
    }

    public void setPatrulhasAuxs(List<PatrulhaAux> patrulhasAuxs) {
        this.patrulhasAuxs = patrulhasAuxs;
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
        final Patrulha other = (Patrulha) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome; 
    }

    
}
